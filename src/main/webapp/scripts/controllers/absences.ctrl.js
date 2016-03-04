'use strict';


angular
    .module('portail.controllers')
    .controller('AbsencesCtrl', function($scope, $compile, $timeout, uiCalendarConfig, Absence, $modal) {


    var date = new Date();
        var d = date.getDate();
        var m = date.getMonth();
        var y = date.getFullYear();

    /* event source that contains custom events on the scope */
    $scope.events = [];
    $scope.eventSources = [];
    /* event source that calls a function on every view switch */
    $scope.eventsF = function (start, end, timezone, callback) {
      var s = new Date(start).getTime() / 1000;
      var e = new Date(end).getTime() / 1000;
      var m = new Date(start).getMonth();
      var events = [{title: 'Feed Me ' + m,start: s + (50000),end: s + (100000),allDay: false, className: ['customFeed']}];
      callback(events);
    };
    
    /* config object */
    $scope.uiConfig = {
        calendar:{
        height: 550,
        editable: true,
        selectable: true,
        weekends: true,
        header:{
          left: 'prev',
          center: 'title',
          right: 'next'
        },
        select: function(start, end, event) {
                console.log(event);
                if(start == end){
                  $scope.alertOnEventClick;  
                }
                var dialogOpts = {
                    backdrop: true,
                    keyboard: true,
                    templateUrl: './views/modaleTpl.html', // Url du template HTML
                    controller: ['$scope', '$modalInstance','scopeParent', 'id',
                        function($scope, $modalInstance,scopeParent,id) { //Controller de la fenêtre. Il doit prend en paramètre tous les élèments du "resolve".
                            $scope.delete = function() {
                                //On fait appel à la fonction du scope parent qui permet de supprimer l'élément.
                                //On peut également faire appel à un service de notre application.
                                scopeParent.delete(id);
                                //validation de la fenêtre modale
                                $modalInstance.doSubmit();
                            };
                            $scope.cancel = function() {
                                // Appel à la fonction d'annulation.
                                $modalInstance.close();
                            };
                        }
                    ],
                    resolve: {
                        scopeParent: function() {
                            return $scope; //On passe à la fenêtre modal une référence vers le scope parent.
                        },
                        id: function(){
                            return $scope.id; // On passe en paramètre l'id de l'élément à supprimer.
                        }
                    }
                };
                $modal.open(dialogOpts);
        },
        events: [
            {
                title: 'All Day Event',
                start: '2016-01-01'
            },
            {
                title: 'Long Event',
                start: '2016-01-07',
                end: '2016-01-10'
        }],
        eventClick: function(){alert("tete")},
        eventDrop: $scope.alertOnDrop,
        eventResize: $scope.alertOnResize,
        eventRender: $scope.eventRender,
        dayClick: function(){alert("tete")},
      }
    };
    /* event sources array*/
    $scope.eventSources = [$scope.events, $scope.eventSource, $scope.eventsF];
    $scope.eventSources2 = [$scope.calEventsExt, $scope.eventsF, $scope.events];

    $scope.uiConfig.calendar.dayNames = ["Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"];
    $scope.uiConfig.calendar.dayNamesShort = ["Dim", "Lun", "Mar", "Mer", "Jeu", "Ven", "Sam"];


  


    var conges = Absence.query(function(data) {
        
		$scope.conges = data[0].congesConsomme;
		$scope.rttUn = data[0].rttQunConsomme;
		$scope.rttDeux = data[0].rttQdeuxConsomme;
                
		$scope.dateProchainConges = data[0].dateProchainConges;
		$scope.dureeProchainConges = data[0].dureeProchainConges;
                
		$scope.soldeConges = data[0].soldeConges;
		$scope.soldesQun = data[0].soldesQun;
		$scope.soldesQdeux = data[0].soldesQdeux;
                
                $scope.restantConges = parseFloat($scope.soldeConges)-parseFloat($scope.conges);
                $scope.restantQun = parseFloat($scope.soldesQun)-parseFloat($scope.rttUn);
                $scope.restantQdeux = parseFloat($scope.soldesQdeux)-parseFloat($scope.rttDeux);
                
                $scope.totalPris = parseFloat($scope.conges)+parseFloat($scope.rttUn)+parseFloat($scope.rttDeux);
                $scope.totalRestant = parseFloat($scope.restantConges)+parseFloat($scope.restantQun)+parseFloat($scope.restantQdeux);
		
		console.log(data[0]);
		$scope.labelConge = ["Pris", "Restants"];
		$scope.dataConge = [$scope.conges, $scope.restantConges];
		$scope.options = {responsive: true, percentageInnerCutout: 70};
		
		$scope.labelRttQ1 = ["Pris", "Restants"];
		$scope.dataRttQ1 = [$scope.rttUn, $scope.restantQun];
		$scope.options = {responsive: true, percentageInnerCutout: 70};
		
		if($scope.rttDeux == "0.0" && $scope.restantQdeux == "0.0"){
			$scope.isCachee = "cachee";
                        $scope.isCentre = "centre";
		}else {
			$scope.labelRttQ2 = ["Pris", "Restants"];
			$scope.dataRttQ2 = [$scope.rttDeux, $scope.restantQdeux];
			$scope.options = {responsive: true, percentageInnerCutout: 70};
		}
		
		$scope.colours = ['#e31937','#d8d8d8'];
                
                
	});



});

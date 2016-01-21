'use strict';


angular
    .module('portail.controllers')
    .controller('AbsencesCtrl',
   function($scope, $compile, $modal, $timeout, uiCalendarConfig) {
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
          left: 'title',
          center: '',
          right: 'today prev,next'
        },
       /* select: function(start, end, event) {
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
                                //Fermeture de la fenêtre modale
                                $modalInstance.close();
                            };
                            $scope.cancel = function() {
                                // Appel à la fonction d'annulation.
                                $modalInstance.dismiss('cancel');
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
        },*/
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

});

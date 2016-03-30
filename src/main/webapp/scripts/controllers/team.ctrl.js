
angular
        .module('portail.controllers')
        .controller('TeamCtrl', function($scope, $http, $timeout, Absence) {
    
            $scope.schedulerConfig = {
                scale: "Day",
                days: 365,
                startDate: new DayPilot.Date().firstDayOfMonth(),
                timeHeaders: [
                    { groupBy: "Month" },
                    { groupBy: "Cell", format: "d" }
                ],
            };
//            
            $scope.navigatorConfig = {
                selectMode: "day",
                showMonths: 3,
                skipMonths: 3,
                onTimeRangeSelected: function(args) {
                	$scope.schedulerConfig.startDate = args.day;

                },
                showYear : true
            };
            
            $scope.schedulerConfig.resources = [];
            $scope.events = [];
            Absence.getByEquipe({id:'CNP', month:new DayPilot.Date().getMonth()},function(data){
            	data.forEach(function(elt){
            		$scope.schedulerConfig.resources.push({ id : elt.trigramme, name : elt.nom + " " + elt.prenom});
            		elt.listEvent.forEach(function(evt){
            			$scope.events.push(
            			{id: evt.id,
            		    text: evt.text,
            		    start: evt.dateDebut,
            		    end: evt.dateFin,
            		    resource: elt.trigramme});
            		});
            	})

            });
  });

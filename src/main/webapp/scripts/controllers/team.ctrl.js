
angular
        .module('portail.controllers')
        .controller('TeamCtrl', function($scope, $http, $timeout, Absence) {
    
            $scope.schedulerConfig = {
                scale: "Day",
                days: 365,
                startDate: new DayPilot.Date().firstDayOfMonth(),
                timeHeaders: [
                    { groupBy: "Month" },
                    { groupBy: "Cell", format: "dd/MM" }
                ],
                eventResizeHandling : "Disabled",
                eventMoveHandling : "Disabled",
                locale : "fr-fr",
                cellBackColorNonBusiness : "#000000",
                eventEndSpec : "Date",
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

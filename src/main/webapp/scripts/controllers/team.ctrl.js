
angular
        .module('portail.controllers')
        .controller('TeamCtrl', function($scope, $http, $timeout, Absence) {
    
            $scope.schedulerConfig = {
                scale: "Day",
                days: new DayPilot.Date().daysInMonth(),
                startDate: new DayPilot.Date().firstDayOfMonth(),
                timeHeaders: [
                    { groupBy: "Month" },
                    { groupBy: "Day", format: "d" }
                ],
                cellWidthSpec: "Auto",
                treeEnabled: true,
                
            };
//            
            $scope.navigatorConfig = {
                selectMode: "month",
                showMonths: 3,
                skipMonths: 3
//                onTimeRangeSelected: function(args) {                        
//                    loadEvents(args.start.firstDayOfMonth(), args.start.addMonths(1).firstDayOfMonth());
//                }
            };
//            
//            $timeout(function() {
//                loadResources();
//            });
//                
//            
//            
//            function loadEvents(from, to) {
//                var from = from || $scope.scheduler.visibleStart();
//                var to = to || $scope.scheduler.visibleEnd();
//                var params = {
//                    start: from.toString(),
//                    end: to.toString()
//                };
//                $scope.schedulerConfig.startDate = from;
//                $scope.schedulerConfig.days = Math.floor(new DayPilot.TimeSpan(to.getTime() - from.getTime()).totalDays());
//            }
      
            $scope.schedulerConfig.resources = [];
            $scope.events = [];
            Absence.getByEquipe({id:'CNP'},function(data){
            	data.forEach(function(elt){
            		console.log(elt);
            		//console.log($scope.navigatorConfig.showMonths);
            		
            		$scope.schedulerConfig.resources.push({ id : elt.trigramme, name : elt.nom + " " + elt.prenom});
            		elt.listEvent.forEach(function(evt){
            			console.log(evt.numMoisFin);
            			if(evt.numMoisDebut == $scope.navigatorConfig.showMonths || evt.numMoisFin == $scope.navigatorConfig.showMonths){
	            			$scope.events.push(
	            			{id: evt.id,
	            		    text: evt.text,
	            		    start: evt.dateDebut,
	            		    end: evt.dateFin,
	            		    resource:elt.trigramme});
	            		}
            		});
            	})
            })
  });

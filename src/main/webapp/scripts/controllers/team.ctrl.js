
angular
        .module('portail.controllers')
        .controller('TeamCtrl', ['$scope', '$http', '$timeout', function($scope, $http, $timeout, Absence) {
    
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
            
            $scope.navigatorConfig = {
                selectMode: "month",
                showMonths: 3,
                skipMonths: 3,
                onTimeRangeSelected: function(args) {                        
                    loadEvents(args.start.firstDayOfMonth(), args.start.addMonths(1).firstDayOfMonth());
                }
            };
            
            $timeout(function() {
                loadResources();
            });
                
            
            
            function loadEvents(from, to) {
                var from = from || $scope.scheduler.visibleStart();
                var to = to || $scope.scheduler.visibleEnd();
                var params = {
                    start: from.toString(),
                    end: to.toString()
                };
                $scope.schedulerConfig.startDate = from;
                $scope.schedulerConfig.days = Math.floor(new DayPilot.TimeSpan(to.getTime() - from.getTime()).totalDays());
            }
            
            function loadResources() {
  
                $scope.schedulerConfig.resources = [
                    
                    { name : "Personne 1", id : "Personne1" },
                    { name : "Personne 2", id : "Personne2" },
                    { name : "Personne 3", id : "Personne3" },
                    { name : "Personne 4", id : "Personne4" },
                    { name : "Personne 5", id : "Personne5" },
                    { name : "Personne 6", id : "Personne6" }
                ];
                
            };
            var conges = Absence.query(function(data) {
        
		$scope.team = data[0].tags;
            });
  }]);

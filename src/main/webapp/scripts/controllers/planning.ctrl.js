angular
    .module('portail.controllers')
    .controller('PlanningCtrl', ['$scope', '$http', function ($scope, $http) {
      
         $scope.OT=  [
      
            {type: 'OT1',
             date: '17/03/2016'
            }, 
            {type: 'OT2',
             date: '17/03/2016'
            }, 
            {type: 'OT3',
             date: '17/03/2016'
            },
            {type: 'OT4',
             date: '17/03/2016'
            }, 
            {type: 'OT5',
             date: '17/03/2016'
            },
            {type: 'OT6',
             date: '17/03/2016'
            }
        ]; 
            
}]);

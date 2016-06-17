angular
        .module('portail.controllers')
        .controller('StatistiquesCtrl', function($scope, $http, $timeout, $filter, VisDataSet, Statistique) {
            
        
      //var names = ['SquareShaded', 'Bar', 'Blank', 'CircleShaded'];
    var groups = new vis.DataSet();
    groups.add({
        id: 0,
        content: "group0"
    });

    groups.add({
        id: 1,
        content: "group1"
    });

    groups.add({
        id: 2,
        content: "group2"       
    });
    
    $scope.dmStats  = [];
    var cDEV = 0;
    
   /* var test = Statistique.getDemandeStats(function(data) {
                    data.listStats.forEach(function(evt){
                            cDEV++;
                            $scope.dmStats.push(
                                {type: evt.typeActivite}
                            );
                        
                    });
                    $scope.infosDev = cDEV;
                });*/
    
    
   


    var items = [
        {x: '2014-06-12', y: 0 , group: 0},
        {x: '2014-06-13', y: 30, group: 0},
        {x: '2014-06-14', y: 10, group: 0},
        {x: '2014-06-15', y: 15, group: 0},
        {x: '2014-06-12', y: 30, group: 1},
        {x: '2014-06-13', y: 10, group: 1},
        {x: '2014-06-14', y: 15, group: 1},
        {x: '2014-06-15', y: 52, group: 1},
        {x: '2014-06-12', y: 20, group: 2},
        {x: '2014-06-13', y: 60, group: 2},
        {x: '2014-06-14', y: 10, group: 2},
        {x: '2014-06-15', y: 50, group: 2},
        
        
    ];

    $scope.data =  {items: new vis.DataSet(items), groups: groups};
    $scope.options = {
        style:'bar',
        stack: 'true',
        barChart: {width:50, align:'center', sideBySide:true, stack: true},
        drawPoints: false,
        dataAxis: {
            icons:true
        },
        orientation:'top',
        start: '2014-06-10',
        end: '2014-06-18'
    };

  

});
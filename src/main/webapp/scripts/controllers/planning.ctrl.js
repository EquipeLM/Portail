angular
        .module('portail.controllers')
        .controller('PlanningCtrl', function($scope, $http, $timeout, $filter) {
        
        $scope.events = [];

        $scope.schedulerConfig = {
            scale: "Week",
            days: 365,
            //autoScroll : "Always",
            
            locale : "fr-fr",
            cellBackColorNonBusiness : "#000000",
            eventEndSpec : "Date",
            //timeline: getTimeline(),
            timeHeaders: [
                    { groupBy: "Year" },
                    { groupBy: "Week" }
                ],
            startDate: new DayPilot.Date().firstDayOfMonth(),
            eventDeleteHandling: "Update",
            allowEventOverlap: false,
            cellWidthSpec: "Auto",
            eventHeight: 50,
            treeEnabled: true,
            rowHeaderColumns: [
                {title: 'Demandes', width: 80},
                {title: "Type", width: 50},
                {title: "Consommé", width: 50},
                {title: "RAF", width: 50},
                {title: "Prévue", width: 50},
                {title: "Planifié", width: 50}
            ],
            resources : [
                { name: "Libelle DM", id: "101", columns: [{html: "DEV"},  {html: "0.5"}, {html: "0.5"}, {html: "1"}, {html: "1"}], 
                    children : [{"id":"11","name":"nom OT", columns: [{html: "DEV"},  {html: "0.5"}, {html: "0.5"}, {html: "1"}, {html: "1"}]}] },
                { name: "Libelle DM", id: "102", columns: [{html: "DEV"},  {html: "0.5"}, {html: "0.5"}, {html: "1"}, {html: "1"}] },
               
  ],
            
            
        };
             
                
})

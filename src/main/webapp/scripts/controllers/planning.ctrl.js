angular
        .module('portail.controllers')
        .controller('PlanningCtrl', function($scope, $http, $timeout, $filter, Planning) {
        
        $scope.events = [];

        $scope.schedulerConfig = {
            scale: "Week",
            days: 365,
            //autoScroll : "Always",
            
            locale : "fr-fr",
            cellBackColorNonBusiness : "#000000",
            heightSpec : "Max",
            
            height : 400,
           
            //eventEndSpec : "Date",
            //timeline: getTimeline(),
            timeHeaders: [
                    { groupBy: "Month" },
                    { groupBy: "Week" }
                ],
            startDate: new DayPilot.Date(),
            //eventDeleteHandling: "Update",
            allowEventOverlap: false,
           
            
            treeEnabled: true,
            rowHeaderColumns: [
                {title: 'Demandes', width: 80},
                {title: 'Tri', width: 50},
                {title: "Type", width: 50},
                {title: "Consommé", width: 50},
                {title: "RAF", width: 50},
                {title: "Prévue", width: 50},
                {title: "Planifié", width: 50}
            ],
            eventClickHandling : "Edit"
            /*resources : [
                { name: "Libelle DM", id: "101", columns: [{html: "DEV"},  {html: "0.5"}, {html: "0.5"}, {html: "1"}, {html: "1"}], 
                    children : [{"id":"11","name":"nom OT", columns: [{html: "DEV"},  {html: "0.5"}, {html: "0.5"}, {html: "1"}, {html: "1"}]}] },
                { name: "Libelle DM", id: "102", columns: [{html: "DEV"},  {html: "0.5"}, {html: "0.5"}, {html: "1"}, {html: "1"}] },
               
            ]*/
        };
        $scope.schedulerConfig.resources = [];
            $scope.events = [];
           
            Planning.getByEquipe({tag:'CNP'},function(data){
            	data.forEach(function(elt){
            		$scope.schedulerConfig.resources.push({id : elt.idDm, name : elt.libelleDM/*, columns : [{html: elt.type},  {html: elt.consomme}, {html: elt.raf}, {html: elt.prevue}, {html: "0"}]*/, 
                    children : [{id:elt.idOt, name: elt.libelleOT, columns: [{html: elt.trigrammeOT}, {html: elt.type},  {html: elt.consomme}, {html: elt.raf}, {html: elt.prevue}, {html: "0"}]}]});
            		elt.listPlanning.forEach(function(evt){
            			$scope.events.push(
            			{id : evt.idDm,
                                text: evt.planifie,
                                start: evt.semaine,
                                end: evt.semaine,
                                resource: evt.idOt});
            		});
            		
            	});
            });
        
        
             
                
})

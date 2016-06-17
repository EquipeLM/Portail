angular
        .module('portail.controllers')
        .controller('PlanningCardCtrl', function($scope, $http, $timeout, $filter, Planning, Absence) {
            
        var vm = this;
	vm.grettings = "hola";

	vm.myInterval = 5000;
	vm.slides = [];

$scope.events = [];

        $scope.schedulerConfig = {
            scale: "Week",
            days: 365,
            //autoScroll : "Always",
            eventHeight: 32,
            locale : "fr-fr",
            cellBackColorNonBusiness : "#000000",
            heightSpec : "Max",
            autoRefreshEnabled: true, 
            eventResizeHandling : "Disabled",
            eventMoveHandling : "Disabled",
            height : 380,
            
            contextMenu : new DayPilot.Menu({items: [
                {text:"Edit", onclick: function () { events.edit(); }},
                {text:"Delete"}             
            ]}),
            timeHeaders: [
                    { groupBy: "Month" },
                    { groupBy: "Week" }
                ],
            startDate: new DayPilot.Date(),
            
            //allowEventOverlap: false,
           
            
            //treeEnabled: true,
            rowHeaderColumns: [
                {title: 'OT', width: 80},
                {title: 'Tri', width: 30},
                {title: "Type", width: 50},
                {title: "Consommé", width: 80},
                {title: "RAF", width: 50},
                {title: "Prévue", width: 50},
                
            ],
            
            
            /*resources : [
                { name: "Libelle DM", id: "101", columns: [{html: "DEV"},  {html: "0.5"}, {html: "0.5"}, {html: "1"}, {html: "1"}], 
                    children : [{"id":"11","name":"nom OT", columns: [{html: "DEV"},  {html: "0.5"}, {html: "0.5"}, {html: "1"}, {html: "1"}]}] },
                { name: "Libelle DM", id: "102", columns: [{html: "DEV"},  {html: "0.5"}, {html: "0.5"}, {html: "1"}, {html: "1"}] },
               
            ]*/
        };
        
        /*$scope.EditEvent(function (){
            $scope.events.edit(this.source);
        })*/
        
       
        
        
        $scope.schedulerConfig.resources = [];
            
            var orderBy = $filter('orderBy');
            Planning.getByEquipe({tag:'CNP'},function(data){
            	data.forEach(function(elt){
            		$scope.schedulerConfig.resources.push({id:elt.idOt, name: elt.libelleOT, name2 : elt.trigrammeOT, columns: [{html: elt.trigrammeOT}, {html: elt.type},  {html: elt.consomme}, {html: elt.raf}, {html: elt.prevue}]})
                        
            		elt.listPlanning.forEach(function(evt){
                            
            			$scope.events.push(
            			{
                                text: evt.planifie,
                                start: evt.semaine,
                                end: evt.semaine,
                                resource: evt.idOt});
            		});
                    });
                    $scope.order = function(predicate) {
            		$scope.predicate = predicate;
            		$scope.reverse = false;
            		$scope.schedulerConfig.resources = orderBy($scope.schedulerConfig.resources, predicate, $scope.reverse);
            	};
            	$scope.order('name2');
            	});
                
                
                $scope.schedulerConfig1 = {
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
                height : 380,
                heightSpec : "Max",
            };            
           
            
            $scope.schedulerConfig1.resources = [];
            $scope.events = [];
            var orderBy = $filter('orderBy');
            Absence.getByEquipe({id:'CNP', month:new DayPilot.Date().getMonth()},function(data){
            	data.forEach(function(elt){
            		$scope.schedulerConfig1.resources.push({ id : elt.trigramme, name : elt.prenom + " " + elt.nom, name2 : elt.nom});
            		elt.listEvent.forEach(function(evt){
            			$scope.events.push(
            			{id: evt.id,
            		    text: evt.text,
            		    start: evt.dateDebut,
            		    end: evt.dateFin,
            		    resource: elt.trigramme});
            		});
            		
            	})
            	$scope.order = function(predicate) {
            		$scope.predicate = predicate;
            		$scope.reverse = false;
            		$scope.schedulerConfig.resources = orderBy($scope.schedulerConfig.resources, predicate, $scope.reverse);
            	};
            	$scope.order('name2');

            });
});
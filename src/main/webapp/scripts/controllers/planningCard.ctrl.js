angular
        .module('portail.controllers')
        .controller('PlanningCardCtrl', function($scope, $http, $timeout, $filter, Planning, Absence, Login, $window) {
            
            $scope.testlog = function(){
                Login.loginTest(function(data){
                    if(data.trigramme == ''){
                        $window.location = '/portail/#/loginError';            
                    }
                });
            }
            
            
    var vm = this;
    vm.myInterval = 5000;
    vm.slides = [];

    $scope.events = [];
    
// Configuration du planning de la tuile

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
                {title: 'OT', width: 90},
                {title: 'Id', width: 30},
                {title: 'Tri', width: 30},
                
               
                
            ],
        };
       
// Affichage du planifié de chaque ressource       
       
        $scope.schedulerConfig.resources = [];
            
            var orderBy = $filter('orderBy');
            Planning.getByEquipe({tag:'CNP'},function(data){
            	data.forEach(function(elt){
            		$scope.schedulerConfig.resources.push({id:elt.idOt, name: elt.libelleOT, name2 : elt.trigrammeOT, columns: [{html: elt.idOt}, {html: elt.trigrammeOT}]})
                        
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
                
                
// Configuration du planning d'absences de chaque ressource               
                
                $scope.schedulerConfig1 = {
                scale: "Day",
                days: 365,
                eventHeight: 35,
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
           
// Affichage des absences de l'équipe de la CNP           
            
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
            
// Fonction qui permet l'ouverture de la modale quand une tâche est terminée        
        
    
    
});
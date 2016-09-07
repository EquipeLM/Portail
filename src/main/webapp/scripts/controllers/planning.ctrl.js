angular
        .module('portail.controllers')
        .controller('PlanningCtrl', function($scope, $http, $timeout, $filter, Planning, $mdDialog, $mdMedia, Tache, Planning, Absence, Login, $window) {
        
        
        
        $scope.testlog = function(){
                Login.loginTest(function(data){
                    if(data.trigramme == ''){
                        $window.location = '/portail/#/loginError';            
                    }
                });
            }
        
        $scope.sortType     = 'name'; // set the default sort type
        $scope.sortReverse  = false;  // set the default sort order
        $scope.searchTache   = '';     // set the default search/filter term
  
        $scope.sortType     = 'tacheRetard.dm'; // set the default sort type
        $scope.sortReverse  = false;  // set the default sort order
        $scope.searchTache   = '';     // set the default search/filter term
        $scope.events = [];

// Configuration du planning

        $scope.schedulerConfig = {
            scale: "Week",
            days: 365,
            //autoScroll : "Always",
            eventHeight: 45,
            locale : "fr-fr",
            cellBackColorNonBusiness : "#000000",
            heightSpec : "Max",
            autoRefreshEnabled: true, 
            height : 800,
            contextMenu : new DayPilot.Menu({items: [
                {text:"Edit", onclick: function () { alert('Edit'); }},
                {text:"Delete"}             
            ]}),
            timeHeaders: [
                    { groupBy: "Month" },
                    { groupBy: "Week" }
                ],
            startDate: new DayPilot.Date(),
            //eventDeleteHandling: "Update",
            allowEventOverlap: false,
           
            
            treeEnabled: true,
            rowHeaderColumns: [
                {title: 'OT', width: 100},
                {title: 'Type', width: 50},
                
                {title: 'Prevue', width : 50},
                {title: 'Raf', width : 50},
                {title: 'Consommée', width : 85},
                {title: 'Tri', width: 50}
                
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
            
        
// Ajout des toutes les plannifications de chaque ressources appartenant à la CNP

        $scope.schedulerConfig.resources = [];
            
            var orderBy = $filter('orderBy');
            Planning.getByEquipe({tag:'CNP'},function(data){
            	data.forEach(function(elt){
            		$scope.schedulerConfig.resources.push({id:elt.idOt, name: elt.libelleOT+ ' - '+ elt.idOt, name2 : elt.trigrammeOT, columns: [{html: elt.typeOT}, {html: elt.prevue}, {html:elt.raf}, {html: elt.consomme}, {html: elt.trigrammeOT}]})
                        
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
                eventHeight: 45,
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
            
// Affichage dans un select de la modal les forfaits 

        $scope.loadForfaits = function() {
        // Use timeout to simulate a 650ms request.
        $scope.forfaits = [];
                var test = Planning.getForfaitModal(function(data) {
                    data.listPlanModal.forEach(function(evt){
                        $scope.forfaits.push(
                            {id: evt.idforfait, name: evt.libelleForfait, name2: evt.refForfait}
                        )
                    }); 
                });

         };
         
// Affichage dans un select de la modal les types            
                
        $scope.loadTypes = function() {
        // Use timeout to simulate a 650ms request.
        $scope.types = [];
                var test = Planning.getTypeModal(function(data) {
                    data.listPlanModal.forEach(function(evt){
                        $scope.types.push(
                            {id: evt.idTypeDm, name: evt.libelleDm}
                        )
                    }); 
                });
         };
         
// Affichage dans un select de la modal les nom et prenom de chaque ressource appartenant à la CNP
       
        $scope.loadUsers = function() {  
        $scope.users = [];
       
          var test = Tache.getRessourceTri({tag :"CNP"},function(data) {
                    data.listTache.forEach(function(evt){
                        $scope.users.push(
                            {name: evt.nom +' '+ evt.prenom, id: evt.trigramme}
                        )
                    });
                    
                });
        
        };
        
   
        
       
// Fonction qui permet d'ajouter une demande grâce à une modale

        $scope.formData = {};
        $scope.formData.idClient;
        $scope.formData.description;
        
        
        $scope.hide = function() {
            $mdDialog.hide();
        };
        $scope.cancel = function() {
            $mdDialog.cancel();
        };
        $scope.validerDemande = function() {
            
            
        $scope.formData.motCle = "for";
        $scope.selectedUser;
        $scope.formData.qui = $scope.user.id;
        $scope.formData.typeDm = $scope.type.id;
        $scope.formData.forfait = $scope.forfait.id;
	
                /*Planning.addDemande($scope.formData, function() {
                       //va appeler ta fonction ajouterAbsence avec les valeurs bindées dans formData      
                });*/
		
         console.log($scope.formData); 
        	
  
      };  
        
             
                
});
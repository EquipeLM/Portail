angular
        .module('portail.controllers')
        .controller('PlanningCtrl', function($scope, $http, $timeout, $filter, Planning, $mdDialog, $mdMedia, Tache, Planning) {
        
        $scope.events = [];

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
                {title: 'Demandes', width: 80},
                {title: 'Tri', width: 50},
                {title: "Type", width: 50},
                {title: "Consommé", width: 80},
                {title: "RAF", width: 50},
                {title: "Prévue", width: 50},
                {title: "Planifié", width: 60}
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
            
           
            Planning.getByEquipe({tag:'CNP'},function(data){
            	data.forEach(function(elt){
            		$scope.schedulerConfig.resources.push({id : elt.idDm, name : elt.libelleDM/*, columns : [{html: elt.type},  {html: elt.consomme}, {html: elt.raf}, {html: elt.prevue}, {html: "0"}]*/, expanded : true,
                         children : [{id:elt.idOt, name: elt.libelleOT, columns: [{html: elt.trigrammeOT}, {html: elt.type},  {html: elt.consomme}, {html: elt.raf}, {html: elt.prevue}, {html: "0"}]}]})
                        
            		elt.listPlanning.forEach(function(evt){
            			$scope.events.push(
            			{
                                text: evt.planifie,
                                start: evt.semaine,
                                end: evt.semaine,
                                resource: evt.idOt});
            		});
                    });
            	});
           
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
        
             
                
})

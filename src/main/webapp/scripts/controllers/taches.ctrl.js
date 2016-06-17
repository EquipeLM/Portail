'use strict';


angular
    .module('portail.controllers')
    .controller('TachesCtrl',['$scope', '$http','$mdDialog', '$mdMedia', '$resource', "Tache", '$timeout', function ($scope, $http, $mdDialog, $mdMedia, $resource, Tache, $timeout) {
            
        
        
        $scope.sortType     = 'name'; // set the default sort type
        $scope.sortReverse  = false;  // set the default sort order
        $scope.searchTache   = '';     // set the default search/filter term
  
        $scope.sortType     = 'tacheRetard.dm'; // set the default sort type
        $scope.sortReverse  = false;  // set the default sort order
        $scope.searchTache   = '';     // set the default search/filter term
            
        
        $scope.showAdvancedEndBis = function(ev) {
            var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
            $mdDialog.show({
      
                templateUrl: './views/modalTacheEnd.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose:true,
                fullscreen: useFullScreen
            })  
        };
        
        $scope.showAdvancedImputation = function(ev) {
            var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
            $mdDialog.show({
      
                templateUrl: './views/modalTacheImputation.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose:true,
                fullscreen: useFullScreen
            })  
        };
        
        $scope.showAdvancedComs = function(ev) {
            var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
            $mdDialog.show({
      
                templateUrl: './views/modalCommentaireTaches.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose:true,
                fullscreen: useFullScreen
            })  
        };
        
        
        
        $scope.someBoolean = true;
         
        var comptDelais = 0;
        var comptAvance = 0;
        var comptRetard = 0;
        var comptTermine = 0;
        $scope.taches = [];
        $scope.tacheRetards = [];
        $scope.tacheAvances = [];
        $scope.tacheTermines = [];
         
                var test = Tache.get(function(data) {
                    data.listTache.forEach(function(evt){
                        if(evt.libelleDmDelais !== null){
                            if(evt.chargeConso > parseFloat("0")){
                                $scope.someBoolean = false;
                            }
                            comptDelais++;
                        $scope.taches.push(
                            {id: evt.idOt, 
                             idDemande : evt.idDemande,
                             dm: evt.libelleDmDelais,
                             ot: evt.libelleOT,
                             type: evt.libelleTypeOT,
                             date : evt.date,
                             charge: evt.chargePrevue,
                             restant : evt.chargeRestante}
                        );
                        }else if(evt.libelleDmRetard !== null){
                            if(evt.chargeConso > parseFloat("0")){
                                $scope.someBoolean = false;
                            }
                            comptRetard++;
                        $scope.tacheRetards.push(
                            {id: evt.idOt, 
                             idDemande : evt.idDemande,
                             dm: evt.libelleDmRetard,
                             ot: evt.libelleOT,
                             type: evt.libelleTypeOT,
                             date : evt.date,
                             charge: evt.chargePrevue,
                             restant : evt.chargeRestante}
                        )
                        }
                        else if(evt.libelleDmAvance !== null){
                            if(evt.chargeConso > parseFloat("0")){
                                $scope.someBoolean = false;
                            }
                            comptAvance++;
                        $scope.tacheAvances.push(
                            {id: evt.idOt, 
                             idDemande : evt.idDemande,
                             dm: evt.libelleDmAvance,
                             ot: evt.libelleOT,
                             type: evt.libelleTypeOT,
                             date : evt.date,
                             charge: evt.chargePrevue,
                             restant : evt.chargeRestante}
                        )
                        }
                        
                        else if(evt.libelleDmTermine !== null){
                            comptTermine++;
                        $scope.tacheTermines.push(
                            {id: evt.idOt, 
                             idDemande : evt.idDemande,
                             dm: evt.libelleDmTermine,
                             ot: evt.libelleOT,
                             type: evt.libelleTypeOT,
                             date : evt.date,
                             charge: evt.chargePrevue}
                        )
                        }
                        
                        $scope.formTacheConsoEnd = {};
                        $scope.formTacheConsoEnd.consoEnd;
                        $scope.formTacheConsoEnd.idDemande = evt.idDemande;
                        $scope.formTacheConsoEnd.type = evt.libelleTypeOT;
                        $scope.formTacheConsoEnd.idOt = evt.idOt;
                        
                            
                        $scope.hide = function() {
                            $mdDialog.hide();
                        };
        
                        $scope.cancel = function() {
                            $mdDialog.cancel();
                        };
        
                        $scope.validerConsoEnd = function() {
                            $mdDialog.hide();
                            Tache.addConsoEnd($scope.formTacheConsoEnd, function() {});
                            console.log($scope.formTacheConsoEnd); 
                            
                        };
                        
                        $scope.formTacheConsoJour = {};
                        $scope.formTacheConsoJour.consoFaite;
                        $scope.formTacheConsoJour.raf;
                        
                        
                            
                        $scope.hide = function() {
                            $mdDialog.hide();
                        };
        
                        $scope.cancel = function() {
                            $mdDialog.cancel();
                        };
        
                        $scope.validerConsoJour = function() {
                            //$mdDialog.hide();
                            $scope.formTacheConsoJour.idDemande = evt.idDemande;
                            $scope.formTacheConsoJour.type = evt.libelleTypeOT;
                            $scope.formTacheConsoJour.idOt = evt.idOt;
                            Tache.addConsoJour($scope.formTacheConsoJour, function() {});
                            console.log($scope.formTacheConsoJour); 
                            
                        };
                        
                                                
                        
                        
                    });
                    
                   var totalDelais =  comptAvance + comptRetard;
                   var totalRetard =  comptAvance + comptDelais;
                   var totalAvance =  comptDelais + comptRetard;
                   
                   $scope.delais = comptDelais;
                   $scope.retard = comptRetard;
                   $scope.avance = comptAvance;
                   $scope.termine = comptTermine;
                   
                   $scope.labelDelais = ["Delais", "Autres"];
                   $scope.dataDelais = [comptDelais, totalDelais];
                   $scope.options = {responsive: true, percentageInnerCutout: 70};
                   $scope.coloursDelais = ['#929292','#d8d8d8'];
                
                   $scope.labelRetard = ["Retard", "Autres"];
                   $scope.dataRetard = [comptRetard, totalRetard];
                   $scope.options = {responsive: true, percentageInnerCutout: 70};
                   $scope.coloursRetard = ['#dd5e60','#d8d8d8'];

                   $scope.labelAvance = ["Avance", "Autres"];
                   $scope.dataAvance = [comptAvance, totalAvance];
                   $scope.options = {responsive: true, percentageInnerCutout: 70};
                   $scope.coloursAvance = ['#72d3a9','#d8d8d8']; 
                   
                   $scope.labelTermine = ["Termine", ""];
                   $scope.dataTermine = [comptTermine, "0"];
                   $scope.options = {responsive: true, percentageInnerCutout: 70};
                   $scope.coloursTermine = ['#d8d8d8','#d8d8d8']; 
                
                });
            
         
         $scope.showAdvancedAddTache = function(ev) {
            var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
            $mdDialog.show({
      
                templateUrl: './views/modalAjoutTacheScreen.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose:true,
                fullscreen: useFullScreen
            })  
        };
     
        $scope.loadDemandes = function() {
        // Use timeout to simulate a 650ms request.
        $scope.demandes = [];
         
                var test = Tache.getDemandeLibelle({tag: "CNP"}, function(data) {
                    data.listTache.forEach(function(evt){
                        $scope.demandes.push(
                            {id: evt.idDm, name: evt.libelleDm, estimation : evt.estimationRevisee}
                        )
                    }); 
                });
        
         };
         
            
                
        $scope.loadTypes = function() {
     
        $scope.types = [];
       
          var test = Tache.getTypeActiviteLibelle(function(data) {
                    data.listTache.forEach(function(evt){
                        $scope.types.push(
                            {name: evt.libelleTypeOT, id: evt.idType}
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
        
        $scope.formTache = {};
        $scope.formTache.chargePrevue;
        
        
        
        
       
        $scope.hide = function() {
        $mdDialog.hide();
      };
      $scope.cancel = function() {
        $mdDialog.cancel();
      };
      $scope.valider = function() {
                
                $scope.formTache.demande = $scope.demande.name;
                $scope.formTache.idDemande = $scope.demande.id;
                $scope.formTache.type = $scope.type.id;
                $scope.formTache.user= $scope.user.id;
                $scope.formTache.designation = $scope.demande.name +' - '+ $scope.type.name;
                $scope.formTache.estimationRevisee = $scope.demande.estimation;
                
                Tache.addTache($scope.formTache, function() {
                       //va appeler ta fonction ajouterAbsence avec les valeurs bindées dans formData      
                });
		
         console.log($scope.formTache); 
         	
  
      };  
        
        
         
        
         
         
    
}]);

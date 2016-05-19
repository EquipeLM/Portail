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
        
        
        
        $scope.hide = function() {
            $mdDialog.hide();
        };
        $scope.cancel = function() {
          $mdDialog.cancel();
        };
        $scope.valider = function() {
                
        };  
        
        
         
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
                            comptDelais++;
                        $scope.taches.push(
                            {id: evt.id, 
                             dm: evt.libelleDmDelais,
                             ot: evt.libelleOT,
                             type: evt.libelleTypeOT,
                             date : evt.date,
                             charge: evt.chargePrevue,
                             restant : evt.chargeRestante}
                        );
                        }else if(evt.libelleDmRetard !== null){
                            comptRetard++;
                        $scope.tacheRetards.push(
                            {id: evt.id, 
                             dm: evt.libelleDmRetard,
                             ot: evt.libelleOT,
                             type: evt.libelleTypeOT,
                             date : evt.date,
                             charge: evt.chargePrevue,
                             restant : evt.chargeRestante}
                        )
                        }
                        else if(evt.libelleDmAvance !== null){
                            comptAvance++;
                        $scope.tacheAvances.push(
                            {id: evt.id, 
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
                            {id: evt.id, 
                             dm: evt.libelleDmTermine,
                             ot: evt.libelleOT,
                             type: evt.libelleTypeOT,
                             date : evt.date,
                             charge: evt.chargePrevue}
                        )
                        }
                        
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
                            {id: evt.id, name: evt.libelleDm}
                        )
                    }); 
                });
        
         };
         
            
                
        $scope.loadTypes = function() {
     
        $scope.types = [];
       
          var test = Tache.getTypeActiviteLibelle(function(data) {
                    data.listTache.forEach(function(evt){
                        $scope.types.push(
                            {name: evt.libelleTypeOT}
                        )
                    }); 
                });
        
        };

        $scope.loadUsers = function() {
        // Use timeout to simulate a 650ms request.
        $scope.users = [];
        return $timeout(function() {
          $scope.users = [
            { id: 1, name: 'Prenom Nom' },
            { id: 2, name: 'Prenom Nom' },
            { id: 3, name: 'Prenom Nom' },
            { id: 4, name: 'Prenom Nom' },
            { id: 5, name: 'Prenom Nom' },
          ];
        }, 650);
        };
        
         $scope.quantity = 2;
         
        $scope.formTacheConsoEnd = { 
            "codeEnd": ""
        };
       // $scope.formTacheConsoEnd.consoEnd ;
         
        $scope.hide = function() {
            $mdDialog.hide();
        };
        
        $scope.cancel = function() {
            $mdDialog.cancel();
        };
        
        $scope.valider = function() {
                
                
		//var response = $http.post('api/taches/conso', $scope.formTacheConsoEnd);
                
                Tache.addConsoEnd($scope.formTacheConsoEnd, function() {});
		/*response.success(function(data, status, headers, config) {
                    
                });
		response.error(function(data, status, headers, config) {
		    console.log( "Exception details: " + JSON.stringify({data: data}));
		});*/
                
         console.log($scope.formTacheConsoEnd); 
                
          
        
         
      };
         
         
    
}]);

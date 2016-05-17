'use strict';


angular
    .module('portail.controllers')
    .controller('TachesCtrl',['$scope', '$http','$mdDialog', '$mdMedia', '$resource', "Tache", '$timeout', function ($scope, $http, $mdDialog, $mdMedia, $resource, Tache, $timeout) {
            
        $scope.labelRetard = ["retard", "Autres"];
	$scope.dataRetard = ["3", "7"];
	$scope.options = {responsive: true, percentageInnerCutout: 70};
        $scope.coloursRetard = ['#dd5e60','#d8d8d8'];
            
        $scope.labelDelais = ["delais", "Autres"];
	$scope.dataDelais = ["5", "5"];
	$scope.options = {responsive: true, percentageInnerCutout: 70};
        $scope.coloursDelais = ['#929292','#d8d8d8'];
            
        $scope.labelAvance = ["avance", "Autres"];
	$scope.dataAvance = ["2", "8"];
	$scope.options = {responsive: true, percentageInnerCutout: 70};
        $scope.coloursAvance = ['#72d3a9','#d8d8d8'];
        
        $scope.sortType     = 'name'; // set the default sort type
        $scope.sortReverse  = false;  // set the default sort order
        $scope.searchTache   = '';     // set the default search/filter term
  
        $scope.sortType     = 'tacheRetard.dm'; // set the default sort type
        $scope.sortReverse  = false;  // set the default sort order
        $scope.searchTache   = '';     // set the default search/filter term
            
        
        $scope.showAdvancedEnd = function(ev) {
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
        
        
         
        
        $scope.taches = [
                    {'dm':'Analyse CQTM - 04/2016',
                        'ot':'CQTM 105541',
                        'type':'RE7',
                        'date':'0/1/1900',
                        'charge':0.2},
                    {'dm':'Analyse CQTM - 04/2016',
                        'ot':'CQTM 105579',
                        'type':'RE7',
                        'date':'0/1/1900',
                        'charge':1.3},
                    {'dm':'Analyse CQTM - 04/2016',
                        'ot':'CQTM 105731',
                        'type':'RE7',
                        'date':'0/1/1900',
                        'charge':0.4},
                    {'dm':'Analyse CQTM - 04/2016',
                        'ot':'CQTM 105640',
                        'type':'RE7',
                        'date':'0/1/1900',
                        'charge':0.4},
                    {'dm':'Analyse CQTM - 04/2016',
                        'ot':'CQTM 105641',
                        'type':'RE7',
                        'date':'0/1/1900',
                        'charge':0.4},
                    {'dm':'Analyse CQTM - 04/2016',
                        'ot':'CQTM 105597',
                        'type':'RE7',
                        'date':'0/1/1900',
                        'charge':0.4},
                    {'dm':'Analyse CQTM - 04/2016',
                        'ot':'CQTM 105457',
                        'type':'RE7',
                        'date':'0/1/1900',
                        'charge':0.3},
                    {'dm':'C2V2 Eurocroissance : Sprint 10 Partages - Environnement 1 - Demande de Batch 2 | Quotidiens :3 | Mensuels :1',
                        'ot':'C2V2 Eurocroissance  Sprint 10 Partages - Environnement 1 - Demande de Batch 2 - Traitement du Batch Recette',
                        'type':'RE7',
                        'date':'0/1/1900',
                        'charge':0.2},
                    {'dm':'C2V2 Eurocroissance : Sprint 11bis - Environnement 2 - Demande de Batch 3 | Nouveau Run | Quotidiens :3 | Mensuels :1',
                        'ot':'C2V2 Eurocroissance  Sprint 11bis - Environnement 2 - Demande de Batch 3 - Traitement du Batch Recette',
                        'type':'RE7',
                        'date':'0/1/1900',
                        'charge':0.3},
                    {'dm':'Campagne Commerciale - Intégration EuroCroissance',
                        'ot':'Campagne Commerciale - Intégration EuroCroissance - Etude Impact / SFG',
                        'type':'SFG',
                        'date':'0/1/1900',
                        'charge':0.3},
                    {'dm':'Editique VL  exclusion de la date comme critère de recherche',
                        'ot':'Editique VL  exclusion de la date comme critère de recherche - Recette',
                        'type':'RE7',
                        'date':'0/1/1900',
                        'charge':0.3}, 

        ];
        
        $scope.tacheRetards = [
                    {   'dm':'Activation des avenants VR en PROD',
                        'ot':'Ouverture des avenants VR en PROD',
                        'type':'INT',
                        'date':'0/1/1900',
                        'charge': 0.1},
                    {'dm':'Analyse CQTM - 04/2016',
                        'ot':'CQTM 105492',
                        'type':'RE7',
                        'date':'0/1/1900',
                        'charge':0.1},
                    {'dm':'C2V2 Eurocroissance : Sprint 10bis - Environnement 2 - Demande de Batch 1 | Nouveau Run | Quotidiens :2 | Mensuels :1',
                        'ot':'C2V2 Eurocroissance  Sprint 10bis - Environnement 2 - Demande de Batch 1 - Traitement du Batch Recette',
                        'type':'RE7',
                        'date':'0/1/1900',
                        'charge': 0.1},
                    {'dm':'C2V2 Eurocroissance : Sprint 11bis - Environnement 2 - Demande de Batch 2 | Nouveau Run | Contrats :115 | Quotidiens :2 | Mensuels :1',
                        'ot':'C2V2 Eurocroissance  Sprint 11bis - Environnement 2 - Demande de Batch 2 - Traitement du Batch Recette',
                        'type':'RE7',
                        'date':'0/1/1900',
                        'charge':0.9},
                    {'dm':'Eurocroissance Lot 3 - Modification du plan de VR',
                        'ot':'EuroCroissance Lot 3 - Analyse',
                        'type':'SFD',
                        'date':'0/1/1900',
                        'charge':0.8},
                    {'dm':'Eurocroissance Lot 3 - Modification du plan de VR',
                        'ot':'Pré-analyse modification de plan de VR',
                        'type':'SFD',
                        'date':'0/1/1900',
                        'charge':1},
                    {'dm':'EuroCroissance lot 3 éditique RSP',
                        'ot':'SUPPORT 2016/03/10 RSP sans opération Cécile GUILLOIT',
                        'type':'RE7',
                        'date':'0/1/1900',
                        'charge':0.1},
                    {'dm':'EuroCroissance lot 3 éditique RSP',
                        'ot':'CQTM 105641',
                        'type':'RE7',
                        'date':'0/1/1900',
                        'charge':0.1},
                    {'dm':'EuroCroissance lot 3 éditique RSP',
                        'ot':'CQTM 105563',
                        'type':'RE7',
                        'date':'0/1/1900',
                        'charge':0.3},
                    {'dm':'EuroCroissance lot 3 éditique RSP - complément',
                        'ot':'SUPPORT 20160315 - Pré-Prod RSP - C.Guilloit',
                        'type':'RE7',
                        'date':'0/1/1900',
                        'charge':0.1},
                    {'dm':'Interaction P3- P4 - Arbitrage 30 jours',
                        'ot':'Interaction P3- P4 - Arbitrage 30 jours - SFD',
                        'type':'SFD',
                        'date':'0/1/1900',
                        'charge':2.3},
                    {'dm':'Interactions P3 P4 arbitrage 30j',
                        'ot':'Interactions P3 P4 arbitrage 30j - Analyse',
                        'type':'SFD',
                        'date':'0/1/1900',
                        'charge':0.1},
                    {'dm':'Interactions P3 P4 arbitrage 30j',
                        'ot':'Pilotes arbitrage 30j',
                        'type':'DEV',
                        'date':'0/1/1900',
                        'charge':0.1},
                    {'dm':'Transfert GMO Eurocroissance évolution courrier'
                        ,'ot':'Transfert GMO Eurocroissance évolution courrier - Tests Hom',
                        'type':'HOM',
                        'date':'0/1/1900',
                        'charge':0.1},

	                
                    ];
                    
         $scope.tacheAvances = [
                    {'dm':'Analyse CQTM - 04/2016','ot':'CQTM 105470','type':'RE7','date':'0/1/1900','charge':0.1},
                    {'dm':'Suivi Production - 04/2016','ot':'Wapiti 804730','type':'EVO','date':'0/1/1900','charge':0.5},

             
         ]
         
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
         
                var test = Tache.get({id: "CNP"}, function(data) {
                    data.listTache.forEach(function(evt){
                        $scope.demandes.push(
                            {id: evt.id, name: evt.libelle}
                        )
                    }); 
                });
        
        
         };
         
            
                
        $scope.loadTypes = function() {
        // Use timeout to simulate a 650ms request.
        $scope.types = [];
       
          var test = Tache.get(function(data) {
                    data.listTache.forEach(function(evt){
                        $scope.types.push(
                            {name: evt.libelle}
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
    
}]);

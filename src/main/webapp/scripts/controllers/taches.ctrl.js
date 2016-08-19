'use strict';


angular
    .module('portail.controllers')
    .controller('TachesCtrl',['$scope', '$http','$mdDialog', '$mdMedia', '$resource', "Tache", '$timeout', function ($scope, $http, $mdDialog, $mdMedia, $resource, Tache, $timeout, $filter, $modal, $log) {
            
// Fonction de recherche dans le tableau
                    
    $scope.sortType     = 'name'; // set the default sort type
    $scope.sortReverse  = false;  // set the default sort order
    $scope.searchTache   = '';     // set the default search/filter term
  
    $scope.sortType     = 'tacheRetard.dm'; // set the default sort type
    $scope.sortReverse  = false;  // set the default sort order
    $scope.searchTache   = '';     // set the default search/filter term
            
// Fonction qui permet l'ouverture de la modale quand une tâche est terminée        
        
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
    
// Fonction qui permet l'ouverture de la modale quand une tâche est en cours afin de mettre son temps de la journée     
            
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
        
// Fonction qui permet l'ouverture de la modale pour l'ajout d'un commentaire       
        
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
        
// Affichage de toutes les tâches dans un tableau        
         
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
                
// Récupération et envoi des datas pour les consommations terminées                
                
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
                 
// Récupération et envoi des datas pour les consommations en cours                    
                
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
                        
//  Récupération et envoi des datas pour laisser un commentaire sur la tâche                 
                
            $scope.formDataComs = {};
            $scope.formDataComs.commentaire;
            $scope.formDataComs.idOt;
                        
            $scope.validerComs = function() {
                
                Tache.addComs($scope.formDataComs, function() {});
                console.log($scope.formDataComs);
                $mdDialog.hide();
            }; 
               
                
// Afficher tous les commentaires ainsi que ajouter un champ pour dire sur quelle tâche
             
            $scope.coms = [];
                        
            Tache.getComs(function(data) {
                data.listTache.forEach(function(evt){
                    $scope.coms.push(
                        {commentaire : evt.commentaire,
                         qui : evt.ressource,
                         date : evt.dateComs,
                         id: evt.idOt}
                    );
           
                });
                
            });
                     
                
// $scope qui permettent d'avoir les indicateurs des tâches

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
                
        });
    
    
// Fonction qui permet l'affichage de la modal d'ajout de tâche

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
    
// Affichage des libellés de demandes dans le select de la modale    
     
    $scope.loadDemandes = function() {
        $scope.demandes = [];
        var test = Tache.getDemandeLibelle({tag: "CNP"}, function(data) {
            data.listTache.forEach(function(evt){
                $scope.demandes.push(
                    {id: evt.idDm, name: evt.libelleDm, estimation : evt.estimationRevisee}
                )
            }); 
        });
    };
         
// Affichage des libellés de types dans le select de la modale    
            
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
    
// Affichage des nom et prenom des personnes de la CNP dans le select de la modale    

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
    
// Fonction qui permet l'envoi des données pour l'ajout dune tâche    

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
        });
		
        console.log($scope.formTache); 
    };  
        
        
    $scope.increaseLimit = function () {
        if ($scope.limit < $scope.items.length) {
            $scope.limit += 15;
        }
    };
 
}]);

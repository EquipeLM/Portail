'use strict';

/* Controllers */

angular
    .module('portail.controllers')
    
    .controller('HomeCtrl', ['$scope', '$http','Incoherence', 'Tache', 'Planning', 'Absence', '$mdDialog', '$mdMedia', '$resource', '$timeout', function ($scope, $http, Incoherence, Tache,Planning, Absence, $mdDialog, $mdMedia, $resource, $timeout, tacheAvance) {
    
    $scope.tacheAvance = tacheAvance; 
    
    var compt = 0;
    
// Permet l'afficahge du nombre d'incohérence de myPm
    
    var test = Incoherence.get(function(data) {
        data.listInco.forEach(function(evt){
            if(evt.idResponsable !== null){
                compt++; 
                ({id: evt.id, 
                tri: evt.idResponsable});
            }
        });
        
        $scope.notif = compt;
    });
    
// Ouverture de la modale d'ajout de tâche    
    
     $scope.showAdvancedAddTache = function(ev) {
            var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
            $mdDialog.show({
      
                templateUrl: './views/modalAjoutTache.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose:true,
                fullscreen: useFullScreen
            })  
        };
        
// Ouverture de la modale d'ajout de demande          
        
        $scope.showAdvancedAddDM = function(ev) {
            var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
            $mdDialog.show({
      
                templateUrl: './views/modalAjoutDM.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose:true,
                fullscreen: useFullScreen
            })  
        };
        
        
        $scope.showAdvancedAddPlan = function(ev) {
        var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
        $mdDialog.show({
            templateUrl: './views/ModalPlannif.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose:true,
            fullscreen: useFullScreen
        })  
    };
        
// Permet l'affichage des libellés de demandes dans le select de la modale     
     
     $scope.loadDemandes = function() {
        // Use timeout to simulate a 650ms request.
        $scope.demandes = [];
         
                var test = Tache.getDemandeLibelle({tag: "CNP"}, function(data) {
                    data.listTache.forEach(function(evt){
                        $scope.demandes.push(
                            {id: evt.idDm, name: evt.libelleDm}
                        )
                    }); 
                });
        
         };
         
// Permet l'affichage des libellés de types dans le select de la modale            
                
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
        
// Permet l'affichage des personnes dans le select de la modale        

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
        
// Envoi des datas de l'ajout tâche

        $scope.formTache = {};
        $scope.formTache.chargePrevue;
        
        $scope.hide = function() {
            $mdDialog.hide();
        };
        
        $scope.cancel = function() {
            $mdDialog.cancel();
        };
        
        $scope.validerTache = function() {
                
                $scope.formTache.demande = $scope.demande.name;
                $scope.formTache.idDemande = $scope.demande.id;
                $scope.formTache.type = $scope.type.id;
                $scope.formTache.user= $scope.user.id;
                $scope.formTache.designation = $scope.demande.name +' - '+ $scope.type.name;
                
                Tache.addTache($scope.formTache, function() {
                       //va appeler ta fonction ajouterAbsence avec les valeurs bindées dans formData      
                });
		
         console.log($scope.formTache); 
         	
  
      };  
      
      $scope.formPlanData = {};
        $scope.formPlanData.idOtPlan;
        $scope.formPlanData.idRessource;
        $scope.formPlanData.noSem;
        $scope.formPlanData.charge;
        
     
      $scope.validerPlan = function() {
                
                
                
                Planning.addPlan($scope.formPlanData, function() {
                           
                });
               console.log($scope.formPlanData);
                $mdDialog.hide();
                
            };
    
                    
    $scope.status = '  ';
    $scope.customFullscreen = $mdMedia('xs') || $mdMedia('sm');
    
    if ($scope.planning) {
        alert("CheckBox is checked.");
    }              
    
 //il faut initialiser le scope pour pouvoir faire le binding avec le modele
 
    $scope.formData = {};
	$scope.formData.dateProchainConges = new Date();

	$scope.formData.dateFinProchainConges = new Date();
	$scope.formData.typeJourneeDebut = "amPm";
	$scope.formData.typeJourneeFin = null;
	$scope.formData.isPoseSurPeriode = "false";
	$scope.formData.dureeProchainConges = null;
	$scope.formData.idTypeAbsence = "choixConge";
	$scope.formData.soldeConges = null;
	$scope.formData.soldesQun = null;
	$scope.formData.soldesQdeux = null;
        $scope.formData.restantConges = null;
        $scope.formData.restantQun = null;
        $scope.formData.restantQdeux = null;
        $scope.formData.totalPris = null;
        $scope.formData.totalRestant = null;
	$scope.formData.labelConge = null;
	$scope.formData.dataConge = null;
	$scope.formData.options = null;
	$scope.formData.labelRttQ1 = null;
	$scope.formData.dataRttQ1 = null;
	$scope.formData.options = null;
	
    $scope.affichePeriodeFin = function(value){
    	$scope.isCachee = "cachee";
    	$scope.isJourneeCachee = "";
        
    	if("true" == value){
    		 $scope.isCachee = "";
    		 $scope.isJourneeCachee = "cachee";
                 $scope.centre = "centree";        
    	} 
        
    }
    
// Ouverture de la modale d'ajout d'absence
    
    $scope.showAdvanced = function(ev) {
        var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
        $mdDialog.show({
      
            templateUrl: './views/modalTuile.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose:true,
            fullscreen: useFullScreen
        })
        
       
        
        
    
        
    
        $scope.$watch(function() {
            return $mdMedia('xs') || $mdMedia('sm');
        }, function(wantsFullScreen) {
            $scope.customFullscreen = (wantsFullScreen === true);
        });
    };
    
  
    $scope.myDate = new Date();
    $scope.minDate = new Date(
    $scope.myDate.getFullYear(),
    $scope.myDate.getMonth() - 2,
    $scope.myDate.getDate());
    $scope.maxDate = new Date(
    $scope.myDate.getFullYear(),
    $scope.myDate.getMonth() + 2,
    $scope.myDate.getDate());
    
   
      $scope.hide = function() {
        $mdDialog.hide();
      };
      $scope.cancel = function() {
        $mdDialog.cancel();
      };
      $scope.valider = function() {
             
                
		var response = $http.post('api/absences/absence', $scope.formData);
                
                Absence.save($scope.formData, function() {
                       //va appeler ta fonction ajouterAbsence avec les valeurs bindées dans formData
                });
		response.success(function(data, status, headers, config) {                     
                });
		response.error(function(data, status, headers, config) {
		    console.log( "Exception details: " + JSON.stringify({data: data}));
		});
         console.log($scope.formData);       
      };
      $scope.supprimer = function (){
          
          alert("element supprimé");
      }
      
     
           
   
    }])

    

.config(function($mdDateLocaleProvider) {
  $mdDateLocaleProvider.formatDate = function(date) {
    return moment(date).format('DD/MM/YYYY');
  };
  $mdDateLocaleProvider.shortDays = ['Di', 'Lu', 'Ma', 'Me', 'Je', 'Ve', 'Sa'];
  // Can change week display to start on Monday.
  $mdDateLocaleProvider.firstDayOfWeek = 1;
});


    
   
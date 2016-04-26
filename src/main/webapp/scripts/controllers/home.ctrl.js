'use strict';

/* Controllers */

angular
    .module('portail.controllers')
    .controller('HomeCtrl', ['$scope', '$http', 'Absence', '$mdDialog', '$mdMedia', '$resource', '$timeout', function ($scope, $http, Absence, $mdDialog, $mdMedia, $resource, $timeout) {
    
        
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
     
    $scope.loadDemandes = function() {
    // Use timeout to simulate a 650ms request.
    $scope.demandes = [];
    return $timeout(function() {
      $scope.demandes = [
        { id: 1, name: 'Analyse CQTM - 04/2016' },
        { id: 2, name: 'C2V2 Eurocroissance : Sprint 11bis - Environnement 2 - Demande de Batch 3 | Nouveau Run | Quotidiens :3 | Mensuels :1' },
        { id: 3, name: 'Campagne Commerciale - Intégration EuroCroissance' },
        { id: 4, name: 'Editique VL  exclusion de la date comme critère de recherche' },
        { id: 5, name: 'Activation des avenants VR en PROD' },
      ];
    }, 650);
    };
    
    $scope.loadTypes = function() {
    // Use timeout to simulate a 650ms request.
    $scope.types = [];
    return $timeout(function() {
      $scope.types = [
        { id: 1, name: 'Developpement / test' },
        { id: 2, name: 'MCO : données' },
        { id: 3, name: 'MCO : traitement' },
        { id: 4, name: 'PRJ : homologation' },
        { id: 5, name: 'PRJ: recette' },
      ];
    }, 650);
    };
                    
                    
    $scope.status = '  ';
    $scope.customFullscreen = $mdMedia('xs') || $mdMedia('sm');
    
    if ($scope.planning) {
        alert("CheckBox is checked.");
    }              
    
    //il faut initialiser le scope pour pouvoir faire le binding avec le modele
 
    $scope.formData = {};
	$scope.formData.dateProchainConges = new Date();
        
        //$scope.formData.dateProchainConges.setHours(5);
        //$scope.formData.dateFinProchainConges = $scope.formData.dateProchainConges;
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
   
    }])

    

.config(function($mdDateLocaleProvider) {
  $mdDateLocaleProvider.formatDate = function(date) {
    return moment(date).format('DD/MM/YYYY');
  };
  $mdDateLocaleProvider.shortDays = ['Di', 'Lu', 'Ma', 'Me', 'Je', 'Ve', 'Sa'];
  // Can change week display to start on Monday.
  $mdDateLocaleProvider.firstDayOfWeek = 1;
});


    
   
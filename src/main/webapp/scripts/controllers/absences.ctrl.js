'use strict';


angular
    .module('portail.controllers')
    .controller('AbsencesCtrl',['$scope', '$http', 'Absence', '$mdDialog', '$mdMedia', '$resource', 'Login', '$window', function ($scope, $http, Absence, $mdDialog, $mdMedia, $resource, $modal, uiCalendarConfig, $dialog, Login, $window, $route) {


            $scope.testlog = function(){
                Login.loginTest(function(data){
                    if(data.trigramme == ''){
                        $window.location = '/portail/#/loginError';            
                    }
                });
            }

            // Fonction qui permet l'ouverture de la modal de modification
        
    $scope.alertOnEventClick =function(ev) {
        var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
        $mdDialog.show({
      
            templateUrl: './views/modalTuileUpdate.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose:true,
            fullscreen: useFullScreen
        });
    };
    
   
// Configuration du calendrier

    $scope.uiConfig = {
        calendar:{
        height: 610,
        editable: true,
        
        weekends: true,
        header:{
          left: 'prev',
          center: 'title',
          right: 'next'
        },
        refetchEvents : true,
        weekNumbers: true,
        
        monthNames: ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'],
        dayNamesShort: ["Dim", "Lun", "Mar", "Mer", "Jeu", "Ven", "Sam"],
        eventClick: $scope.alertOnEventClick
       
        }
    };
    
    
// Affichage des absences de la personne connecté

    $scope.events = [];
    Absence.get({id: "MBE"},function(data){
        $scope.events.splice(0, $scope.events.length); 
            data.listEvent.forEach(function(evt){
                $scope.events.push(
                    {id: evt.id,
                    title: evt.text,
                    start: new Date(evt.dateDebut),
                    end: new Date(evt.dateFin),
                    color: evt.couleur,
                    stick : true,
                    });
            });
    });
    
           
// Affichage des jours fériés

    $scope.eventsF = [];
    Absence.getJourFerie(function(data){
        $scope.eventsF.splice(0, $scope.eventsF.length); 
            data.listEvent.forEach(function(evt){
                $scope.eventsF.push(
                    {id: evt.id,
                    title: evt.text,
                    start: new Date(evt.dateDebut),
                    end: new Date(evt.dateFin),
                    color: evt.couleur,
                    stick : true,
                    });
            });
                       
    });            
            
    $scope.eventSources = [$scope.events, $scope.eventsF];
    
    
// Indicateurs d'absences avec la récupération de datas

    var conges = Absence.query(function(data) {
        
		$scope.conges = data[0].congesConsomme;
		$scope.rttUn = data[0].rttQunConsomme;
		$scope.rttDeux = data[0].rttQdeuxConsomme;
                
		$scope.dateProchainConges = data[0].dateProchainConges;
		$scope.dureeProchainConges = data[0].dureeProchainConges;
                
		$scope.soldeConges = data[0].soldeConges;
		$scope.soldesQun = data[0].soldesQun;
		$scope.soldesQdeux = data[0].soldesQdeux;
                
                $scope.restantConges = parseFloat($scope.soldeConges)-parseFloat($scope.conges);
                $scope.restantQun = parseFloat($scope.soldesQun)-parseFloat($scope.rttUn);
                $scope.restantQdeux = parseFloat($scope.soldesQdeux)-parseFloat($scope.rttDeux);
                
                $scope.totalPris = parseFloat($scope.conges)+parseFloat($scope.rttUn)+parseFloat($scope.rttDeux);
                $scope.totalRestant = parseFloat($scope.restantConges)+parseFloat($scope.restantQun)+parseFloat($scope.restantQdeux);
		
	
        
		$scope.labelConge = ["Pris", "Restants"];
		$scope.dataConge = [$scope.conges, $scope.restantConges];
		$scope.options = {responsive: true, percentageInnerCutout: 70};
		
		$scope.labelRttQ1 = ["Pris", "Restants"];
		$scope.dataRttQ1 = [$scope.rttUn, $scope.restantQun];
		$scope.options = {responsive: true, percentageInnerCutout: 70};
		
		if($scope.rttDeux == "0.0" && $scope.restantQdeux == "0.0"){
			$scope.isCachee = "cachee";
                        $scope.isCentre = "centre";
                        $scope.isAjuste = "ajuste";
		}else {
			$scope.labelRttQ2 = ["Pris", "Restants"];
			$scope.dataRttQ2 = ["0", $scope.restantQdeux];
			$scope.options = {responsive: true, percentageInnerCutout: 70};
		}
                
                if($scope.rttDeux < "0.0"){
                    $scope.dataRttQ2 = ["0", $scope.restantQdeux];
                }
		
		$scope.colours = ['#616161','#d8d8d8'];
               
    });
        
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
    
// Fonction qui permet l'ouverture de la modale d'ajout d'absence

    $scope.showAdvanced = function(ev) {
        var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
        $mdDialog.show({
      
            templateUrl: './views/modalTuile.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose:true,
            fullscreen: useFullScreen,
           
        })
        
    };

// Fonction qui permet l'ouverture de la modale de solde
        
    $scope.showAdvanced2 = function(ev) {
        var useFullScreen = ($mdMedia('sm') || $mdMedia('xs'))  && $scope.customFullscreen;
        $mdDialog.show({
      
            templateUrl: './views/modalSolde.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose:true,
            fullscreen: useFullScreen
        })
    
    }; 
        
        $scope.$watch(function() {
            return $mdMedia('xs') || $mdMedia('sm');
        }, function(wantsFullScreen) {
            $scope.customFullscreen = (wantsFullScreen === true);
        });
    
    
  
    $scope.myDate = new Date();
    $scope.minDate = new Date(
    $scope.myDate.getFullYear(),
    $scope.myDate.getMonth() - 2,
    $scope.myDate.getDate());
    $scope.maxDate = new Date(
    $scope.myDate.getFullYear(),
    $scope.myDate.getMonth() + 2,
    $scope.myDate.getDate());
    
    
// Fonction de l'annulation ou de fermeture de la modale    
   
      $scope.hide = function() {
        $mdDialog.hide();
      };
      $scope.cancel = function() {
        $mdDialog.cancel();
      };
      
// Fonction de validation et l'envoi des données d'une absence

    $scope.valider = function() {
	
            Absence.save($scope.formData, function() {
                //va appeler la fonction ajouterAbsence avec les valeurs bindées dans formData      
            });
           
        console.log($scope.formData); 
        $mdDialog.hide();
        $route.reload();
    };
    
    $scope.formSolde = {};
        $scope.formSolde.soldeConges;
	$scope.formSolde.soldesQun;
	$scope.formSolde.soldesQdeux;
        
    
// Fonction de validation et l'envoi des données d'un solde    
      
    $scope.validerSolde = function() {
		
        Absence.AddSolde($scope.formSolde, function() {
            //va appeler ta fonction ajouterAbsence avec les valeurs bindées dans formData
        });
		
         console.log($scope.formSolde); 
         $mdDialog.hide();
         
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






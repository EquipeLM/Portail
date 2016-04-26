'use strict';


angular
    .module('portail.controllers')
    .controller('AbsencesCtrl',['$scope', '$http', 'Absence', '$mdDialog', '$mdMedia', '$resource', function ($scope, $http, Absence, $mdDialog, $mdMedia, $resource) {



$scope.uiConfig = {
        calendar:{
        height: 550,
        editable: true,
        
        weekends: true,
        header:{
          left: 'prev',
          center: 'title',
          right: 'next'
        },
        
        
      }
    }
    
   
   $scope.events = [];
            
            Absence.get({id: "LSO"},function(data){
            	
                console.log("ok");  
               data.listEvent.forEach(function(evt){
                       console.log("passe");
                       $scope.events.push(
                       {id: evt.id,
                       text: evt.text,
                       start: evt.dateDebut,
                       end: evt.dateFin,
                       color: '#f2f2f2'
                       });
                   });
                console.log("ok2");     
            		
            	
            });
                    
   

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
		
		console.log(data[0]);
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
		
		$scope.colours = ['#80a1b7','#d8d8d8'];
                $scope.colours1 = ['#87c1de','#d8d8d8'];
                $scope.colours2 = ['#9ae6f1','#d8d8d8'];
                
                
                
                
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
        
        };
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
    
   
      $scope.hide = function() {
        
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






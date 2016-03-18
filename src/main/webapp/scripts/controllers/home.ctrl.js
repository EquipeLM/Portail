'use strict';

/* Controllers */

angular
    .module('portail.controllers')
    .controller('HomeCtrl', ['$scope', '$http', 'Absence', '$mdDialog', '$mdMedia', function ($scope, $http, Absence, $mdDialog, $mdMedia) {
    
        
    $scope.status = '  ';
    $scope.customFullscreen = $mdMedia('xs') || $mdMedia('sm');
    
    
    
    
    
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
        $mdDialog.valider();
        
        $scope.formData = {
         
          "dateFin" : $scope.DateFin,
          "datePremierJour" : $scope.DateDebut,
          "idTypeAbsence" : $scope.typeAbs,
          "typeJournee" : $scope.typeJournee,
          "nombreJours" : $scope.nbJours,
          //solde = $scope.solde
          
        } 
            var response = $http.post('submit', formData);
                response.success(function(data, status, headers, config) {
                    //donnees
                });
            response.error(function(data, status, headers, config) {
                    alert( "Exception details: " + JSON.stringify({data: data}));
                });

                
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


    
   
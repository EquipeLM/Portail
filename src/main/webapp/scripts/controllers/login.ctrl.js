'use strict';


angular
    .module('portail.controllers')
    .controller('LoginCtrl', ['$scope', '$http', '$mdDialog', '$mdMedia', '$resource', '$timeout', 'Login', '$location', '$window', function ($scope, $http, $mdDialog, $mdMedia, $resource, $timeoutk, Login, $location, $window) {
            
    $scope.formLogin = {};
    $scope.formLogin.trigramme;
    $scope.formLogin.groupinfra;
    
    $scope.connexion = function() {
    console.log($scope.formLogin);                        
     $scope.logins = [];
                
    Login.login(function(data){
        data.listLogin.forEach(function(evt){
            $scope.logins.push(
                {tri: evt.trigramme,
                groupinfra: evt.groupinfra,
                })
            if(angular.equals($scope.formLogin.trigramme, evt.trigramme)&&angular.equals($scope.formLogin.groupinfra, evt.groupinfra)){
                $window.location = '/portail/#/home';
                Login.connect($scope.formLogin, function() {});
            }
            });
        });  
    }
        
        
        
        }]);
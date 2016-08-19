'use strict';


angular
    .module('portail.controllers')
    .controller('LoginCtrl', ['$scope', '$http', '$mdDialog', '$mdMedia', '$resource', '$timeout', 'Login', function ($scope, $http, $mdDialog, $mdMedia, $resource, $timeoutk, Login) {
            
    $scope.formLogin = {};
    $scope.formLogin.trigramme;
    $scope.formLogin.groupinfra;
    
    $scope.connexion = function() {
                            
                Login.connect($scope.formLogin, function() {});
                console.log($scope.formLogin); 
            };
        
        
        
        }]);
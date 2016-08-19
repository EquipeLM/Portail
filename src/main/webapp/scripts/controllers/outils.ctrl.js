'use strict';

/* Controllers */
// Directive pour pouvoir utilisé l'option de zoom

angular
    .module('portail.controllers')
    .controller('OutilsCtrl', ['$scope', '$http', function ($scope, $http) {
        $scope.modesGestion = {};
        $http.get('model/data.json')
            .success(function (res) {
                $scope.produits = res.listeCodes; 
                $scope.modesGestion = {
                    "label" : res.modeGestion,
                    "value" : [false, false, false, false]
                };
            });
        $scope.codes = [];
        $scope.majListe = function () {
            $scope.codes = $scope.produits[$scope.selected];
        };
        $scope.selected = "";
    
        $scope.zoomModel1 = {
            thumbBd4 : 'styles/images/xsmall/BD4Epargne-1.png',
            smallBd4 : 'styles/images/small/BD4Epargne-1.png',
            largeBd4 : 'styles/images/large/BD4Epargne-1.png',
            thumbBd1 : 'styles/images/xsmall/bd1Bd2-1.png',
            smallBd1 : 'styles/images/small/bd1Bd2-1.png',
            largeBd1 : 'styles/images/large/bd1Bd2-1.png'
        };
    }]);
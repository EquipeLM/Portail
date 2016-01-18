'use strict';

/* Controllers */

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
    }]);

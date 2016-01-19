'use strict';

angular.module('portail.controllers', []);
angular
    .module('portail', ['ngRoute', 'mobile-angular-ui', 'ui.checkbox', 'portail.controllers'])
    .config(function ($routeProvider) {
        $routeProvider.
            when('/outils', {
                templateUrl: './views/outils/outils.html',
                controller: 'OutilsCtrl'
            }).
            when('/viewPdf', {
                templateUrl: './views/outils/viewPdf.html',
                controller: 'OutilsCtrl'
            }).
             otherwise({
                redirectTo: '/outils'
            });
    });

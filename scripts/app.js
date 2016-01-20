'use strict';

angular.module('portail.controllers', []);
angular
    .module('portail',  ['ngRoute', 'mobile-angular-ui', 'ui.checkbox','ui.calendar', 'ui.bootstrap', 'portail.controllers'])
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
            when('/mesAbsences', {
                templateUrl: './views/mesAbsences.html',
                controller: 'AbsencesCtrl'
            }).
             otherwise({
                redirectTo: '/outils'
            });
    });

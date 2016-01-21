'use strict';

angular.module('portail.controllers', ['ui.calendar', 'ui.bootstrap']);
angular
    .module('portail',  ['ngRoute', 'mobile-angular-ui', 'ui.checkbox', 'ui.calendar', 'ui.bootstrap', 'portail.controllers'])
    .config(function ($routeProvider) {
        $routeProvider.
             when('/home', {
                templateUrl: './views/home.html',
            }).
            when('/genRequete', {
                templateUrl: './views/outils/genRequete.html',
                controller: 'OutilsCtrl'
            }).
            when('/viewPdf', {
                templateUrl: './views/outils/viewPdf.html',
                controller: 'OutilsCtrl'
            }).
			when('/outilsHome', {
                templateUrl: './views/outils/outilsHome.html',
                controller: 'OutilsCtrl'
            }).
			when('/mesAbsences', {
                templateUrl: './views/mesAbsences.html',
                controller: 'AbsencesCtrl'
            }).
            otherwise({
                redirectTo: '/outilsHome'
            });
    });

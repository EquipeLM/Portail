'use strict';

angular.module('portail.controllers', []);
angular
    .module('portail', ['ngRoute', 'mobile-angular-ui', 'ui.checkbox', 'portail.controllers'])
    .config(function ($routeProvider) {
        $routeProvider.
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
            when('/test', {
                    templateUrl: './views/testCalendar.html',
                    controller: 'testCtrl'
            }).
			when('/mesAbsences', {
                templateUrl: './views/mesAbsences.html',
                controller: 'AbsencesCtrl'
            }).
            otherwise({
                redirectTo: '/outilsHome'
            });
    });

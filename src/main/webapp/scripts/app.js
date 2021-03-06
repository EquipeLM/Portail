'use strict';

angular.module('portail.services', ['ngResource']);
angular.module('portail.controllers', ['ui.calendar', 'ui.bootstrap', 'ngMaterial', 'daypilot']);
angular
    .module('portail',  ['ngRoute', 'mobile-angular-ui', 'ui.checkbox', 'ui.calendar', 'chart.js', 'daypilot', 'ui.bootstrap', 'portail.controllers', 'portail.services'])
    .config(function ($routeProvider) {
        $routeProvider.
            when('/home', {
            	templateUrl: './views/home.html',
            	controller: 'HomeCtrl'
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
                        when('/planning', {
                templateUrl: './views/planning.html',
                controller: 'PlanningCtrl'
            }).
                        when('/teamAbsences', {
                templateUrl: './views/team-mesAbsences.html',
                controller: 'TeamCtrl'
            }).
                    when('/taches', {
                templateUrl: './views/taches.html',
                controller: 'TachesCtrl'
            }).
                    when('/tachesEquipe', {
                templateUrl: './views/tachesEquipe.html',
                controller: 'TeamCtrl'
            }).
                    when('/planning', {
                templateUrl: './views/planning.html',
                controller: 'PlanningCtrl'
            }).
                    when('/login', {
                templateUrl: './views/login.html',
                controller: 'LoginCtrl'
            }).
                    when('/loginError', {
                templateUrl: './views/LoginError.html',
                controller: 'LoginCtrl'
            }).
                    when('/statistique', {
                templateUrl: './views/statistique.html',
                controller: 'TeamCtrl'
            }).
                    
            otherwise({
                redirectTo: '/login'
            });
    });

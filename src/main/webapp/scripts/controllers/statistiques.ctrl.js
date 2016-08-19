angular
        .module('portail.controllers')
        .controller('StatistiquesCtrl', function($scope, $http, $timeout, $filter, Statistique) {
            
    $scope.labels = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
    $scope.series = ['Series A', 'Series B', 'Series C'];
    $scope.options = {responsive: true, maintainAspectRatio: false, borderWidth: 0.1};
    $scope.colours = ['#616161', '#9ae6f1', '#d8d8d8'];

  $scope.data = [
    [55, 59,20, 21, 56, 55, 40],
    [28, 48, 40, 19, 36, 27, 50],
    [25, 39, 20, 21, 56, 55, 40]
  ];
});
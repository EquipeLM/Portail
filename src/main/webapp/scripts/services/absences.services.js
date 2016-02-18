angular
	.module('portail.services')
	.factory('Absence', function($resource) {
		return $resource('api/absences/:id'); 
	});
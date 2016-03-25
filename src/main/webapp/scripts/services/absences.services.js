angular
	.module('portail.services')
	.factory('Absence', function($resource) {
		return $resource('api/absences/:id'); 
	})
        
        .factory('EquipeAbsence', function($resource) {
		return $resource('api/equipeAbsences/:id'); 
	});
angular
	.module('portail.services')
	.factory('Absence', function($resource) {
		return $resource('api/absences/:id', 
				{id: '@id'},
				{
					getByEquipe : {
						method: 'GET',
						url:'api/absences/equipe/:id',
						isArray: true
					}
				}
		); 
	});
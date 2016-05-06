angular
	.module('portail.services')
	.factory('Absence', function($resource) {
		return $resource('api/absences/:id', 
				{id: '@id'},
				{
					getByEquipe : {
						method: 'GET',
						param : {
							id: '@id',
							month: '@month'
						},
						url:'api/absences/equipe/:id/mois/:month',
						isArray: true
					},
                                        
				}
		); 
	});
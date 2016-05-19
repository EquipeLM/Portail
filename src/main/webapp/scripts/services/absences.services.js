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
                                        getJourFerie : {
						method: 'GET',
                                                param : {},
						
						url:'api/absences/absence/jourFerie',
						isArray: false
					},
                                        updateSolde : {
						method: 'POST',
                                                param : {},
						
						url:'api/absences/absence/Updatesolde',
						isArray: false
					}
                                        
				}
		); 
	});
angular
	.module('portail.services')
	.factory('Absence', function($resource) {
		return $resource('api/absences/:id', 
				{id: '@id'},
				{
					getByEquipe : {
						method: 'GET',
						param : {
							
							month: '@month'
						},
						url:'api/absences/equipe/mois/:month',
						isArray: true
					},
                                        
                                        getJourFerie : {
						method: 'GET',
                                                param : {},
						
						url:'api/absences/absence/jourFerie',
						isArray: false
					},
                                        AddSolde : {
						method: 'POST',
                                                param : {},
						
						url:'api/absences/absence/AddSolde',
						isArray: false
					},
                                       
                                        
				}
		); 
	});
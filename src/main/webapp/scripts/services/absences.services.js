angular
	.module('portail.services')
	.factory('Absence', function($resource) {
		return $resource('api/absences/:id', 
				{id: '@id'},
				{        show : {
						method: 'GET',
						param : {
							
						},
						url:'api/absences/user',
						isArray: false
					},
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
                                        getCard : {
						method: 'GET',
                                                param : {},
						
						url:'api/absences/absence/valueCard',
						isArray: true
					},
                                        
                                        
                                        
                                        AddSolde : {
						method: 'POST',
                                                param : {},
						
						url:'api/absences/absence/AddSolde',
						isArray: false
					},
                                        addAbsence : {
						method: 'POST',
                                                param : {},
						
						url:'api/absences/absence/addAbsence',
						isArray: false
					},
                                       
                                        
				}
		); 
	});
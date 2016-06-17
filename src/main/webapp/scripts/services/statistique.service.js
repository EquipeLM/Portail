angular
	.module('portail.services')
	.factory('Statistique', function($resource) {
		return $resource('api/statistiques/:id', 
				{id: '@id'},
				{
					getDemandeStats : {
						method: 'GET',
						param : {
														
						},
						url:'api/statistiques/statistique/demandeStats',
						isArray: true
					}
                                    });
                            });
                            
                            

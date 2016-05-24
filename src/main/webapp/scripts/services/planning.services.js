angular
	.module('portail.services')
	.factory('Planning', function($resource) {
		return $resource('api/plannings/:id', 
				{id: '@id'},
				{
					getByEquipe : {
						method: 'GET',
						param : {
							tag: '@tag'
							
						},
						url:'api/plannings/planning/equipe/:tag',
						isArray: true
					}
                                });
        });
                                
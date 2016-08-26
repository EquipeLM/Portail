angular
	.module('portail.services')
	.factory('Planning', function($resource) {
		return $resource('api/plannings/:id', 
				{id: '@id'},
				{
					getByEquipe : {
						method: 'GET',
						param : {
							
							
						},
						url:'api/plannings/planning/equipe',
						isArray: true
					},
                                        getForfaitModal : {
						method: 'GET',
						param : {
	
						},
						url:'api/plannings/planning/forfaitModal',
						isArray: false
					},
                                        getTypeModal : {
						method: 'GET',
						param : {
	
						},
						url:'api/plannings/planning/typeDm',
						isArray: false
					},
                                        addDemande : {
						method: 'POST',
                                                param : {},
						
						url:'api/plannings/planning/ajoutDm',
						isArray: false
					},
                                        addPlan : {
                                                method : 'POST',
                                                param : {},
                                                url:'api/plannings/planning/ajoutPlan',
                                                isArray: false
                                        }
                                        
                                        
                                });
        });
                                
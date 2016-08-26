angular
	.module('portail.services')
	.factory('Tache', function($resource) {
		return $resource('api/taches/:id', 
				{id: '@id'},
				{
					getByEquipe : {
						method: 'GET',
						param : {
							
							
						},
						url:'api/taches/tache/equipe',
						isArray: false
					},
                                        getDemandeLibelle : {
						method: 'GET',
						param : {
							
							
						},
						url:'api/taches/tache/demande/libelle',
						isArray: false
					},
                                        getComs : {
						method: 'GET',
						param : {
							
							
						},
						url:'api/taches/tache/afficher/coms',
						isArray: false
					},
                                        
                                        getTypeActiviteLibelle : {
						method: 'GET',
                                                param : {},
						
						url:'api/taches/tache/typeActivite/libelle',
						isArray: false
					},
                                        getRessourceTri : {
						method: 'GET',
                                                param : {
                                                       
                                                },
						
						url:'api/taches/tache/ressource/tri',
						isArray: false
					},
                                        addConsoEnd : {
						method: 'POST',
                                                param : {},
						
						url:'api/taches/tache/ajout/consoEnd',
						isArray: false
					},
                                        addConsoJour : {
						method: 'POST',
                                                param : {},
						
						url:'api/taches/tache/ajout/consoJour',
						isArray: false
					},
                                        addTache : {
						method: 'POST',
                                                param : {},
						
						url:'api/taches/tache/ajout/tache',
						isArray: false
					},
                                        addComs : {
						method: 'POST',
                                                param : {},
						
						url:'api/taches/tache/ajout/coms',
						isArray: false
					},
                                        
                                        
				}
		); 
	});
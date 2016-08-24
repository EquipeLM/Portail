angular
	.module('portail.services')
	.factory('Login', function($resource) {
		return $resource('api/absences/:id', 
				{id: '@id'},
				{
					connect : {
						method: 'POST',
						param : {},
						url:'api/absences/login',
						isArray: false
					},
                                        login : {
						method: 'GET',
						param : {},
						url:'api/incoherences/loginValue',
						isArray: false
					}
                                    }
                                            
                                            
                                            
                                    )
                        });
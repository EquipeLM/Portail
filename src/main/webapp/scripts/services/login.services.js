angular
	.module('portail.services')
	.factory('Login', function($resource) {
		return $resource('api/login/:id', 
				{id: '@id'},
				{
					connect : {
						method: 'POST',
						param : {},
						url:'api/login/infosConnexion',
						isArray: false
					},
                                        login : {
						method: 'GET',
						param : {},
						url:'api/login/loginValue',
						isArray: false
					},
                                        loginTest : {
                                                method: 'GET',
                                                param : {},
                                                url:'api/login/test',
                                                isArray: false

                                        }
                                    }
                                            
                                            
                                            
                                    )
                        });
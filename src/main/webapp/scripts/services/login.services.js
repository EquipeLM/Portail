angular
	.module('portail.services')
	.factory('Login', function($resource) {
		return $resource('api/absences/:id', 
				{id: '@id'},
				{
					connect : {
						method: 'POST',
						param : {},
						url:'api/incoherences/incoherence/connect',
						isArray: false
					}
                                    }
                                    )
                        });
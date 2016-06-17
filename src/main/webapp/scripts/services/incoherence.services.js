angular
	.module('portail.services')
	.factory('Incoherence', function($resource) {
		return $resource('api/incoherences/:id', 
				{id: '@id'});
                            });

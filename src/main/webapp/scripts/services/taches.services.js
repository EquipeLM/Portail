angular
	.module('portail.services')
	.factory('Tache', function($resource) {
            return $resource('api/taches/:id',
                                {id: '@id'})
           
});
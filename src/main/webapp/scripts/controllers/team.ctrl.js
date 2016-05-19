
angular
        .module('portail.controllers')
        .controller('TeamCtrl', function($scope, $http, $timeout,$filter , Absence, Tache) {
    
            $scope.schedulerConfig = {
                scale: "Day",
                days: 365,
                startDate: new DayPilot.Date().firstDayOfMonth(),
                timeHeaders: [
                    { groupBy: "Month" },
                    { groupBy: "Cell", format: "dd/MM" }
                ],
                eventResizeHandling : "Disabled",
                eventMoveHandling : "Disabled",
                locale : "fr-fr",
                cellBackColorNonBusiness : "#000000",
                eventEndSpec : "Date",
            };            
           
            
            $scope.schedulerConfig.resources = [];
            $scope.events = [];
            var orderBy = $filter('orderBy');
            Absence.getByEquipe({id:'CNP', month:new DayPilot.Date().getMonth()},function(data){
            	data.forEach(function(elt){
            		$scope.schedulerConfig.resources.push({ id : elt.trigramme, name : elt.prenom + " " + elt.nom, name2 : elt.nom});
            		elt.listEvent.forEach(function(evt){
            			$scope.events.push(
            			{id: evt.id,
            		    text: evt.text,
            		    start: evt.dateDebut,
            		    end: evt.dateFin,
            		    resource: elt.trigramme});
            		});
            		
            	})
            	$scope.order = function(predicate) {
            		$scope.predicate = predicate;
            		$scope.reverse = false;
            		$scope.schedulerConfig.resources = orderBy($scope.schedulerConfig.resources, predicate, $scope.reverse);
            	};
            	$scope.order('name2');

            });
            
            var comptDelais = 0;
            var comptAvance = 0;
            var comptRetard = 0;
            var comptTermine = 0;
            $scope.taches = [];
            $scope.tacheRetards = [];
            $scope.tacheAvances = [];
            $scope.tacheTermines = [];
         
                var test = Tache.getByEquipe({tag: "CNP"},function(data) {
                    data.listTache.forEach(function(evt){
                        if(evt.libelleDmDelais !== null){
                            comptDelais++;
                        $scope.taches.push(
                            {id: evt.id, 
                             dm: evt.libelleDmDelais,
                             ot: evt.libelleOT,
                             type: evt.libelleTypeOT,
                             date : evt.date,
                             charge: evt.chargePrevue,
                             restant : evt.chargeRestante,
                             ressource : evt.trigramme}
                        );
                        }else if(evt.libelleDmRetard !== null){
                            comptRetard++;
                        $scope.tacheRetards.push(
                            {id: evt.id, 
                             dm: evt.libelleDmRetard,
                             ot: evt.libelleOT,
                             type: evt.libelleTypeOT,
                             date : evt.date,
                             charge: evt.chargePrevue,
                             restant : evt.chargeRestante,
                             ressource : evt.trigramme
                         }
                        )
                        }
                        else if(evt.libelleDmAvance !== null){
                            comptAvance++;
                        $scope.tacheAvances.push(
                            {id: evt.id, 
                             dm: evt.libelleDmAvance,
                             ot: evt.libelleOT,
                             type: evt.libelleTypeOT,
                             date : evt.date,
                             charge: evt.chargePrevue,
                             restant : evt.chargeRestante,
                             ressource : evt.trigramme}
                        )
                        }
                        
                        /*else if(evt.libelleDmTermine !== null){
                            comptTermine++;
                        $scope.tacheTermines.push(
                            {id: evt.id, 
                             dm: evt.libelleDmTermine,
                             ot: evt.libelleOT,
                             type: evt.libelleTypeOT,
                             date : evt.date,
                             charge: evt.chargePrevue,
                             ressource : evt.trigramme}
                        )
                        }*/
                        
                    });
                    
                   var totalDelais =  comptAvance + comptRetard;
                   var totalRetard =  comptAvance + comptDelais;
                   var totalAvance =  comptDelais + comptRetard;
                   
                   $scope.delais = comptDelais;
                   $scope.retard = comptRetard;
                   $scope.avance = comptAvance;
                   $scope.termine = comptTermine;
                   
                   $scope.labelDelais = ["Delais", "Autres"];
                   $scope.dataDelais = [comptDelais, totalDelais];
                   $scope.options = {responsive: true, percentageInnerCutout: 70};
                   $scope.coloursDelais = ['#929292','#d8d8d8'];
                
                   $scope.labelRetard = ["Retard", "Autres"];
                   $scope.dataRetard = [comptRetard, totalRetard];
                   $scope.options = {responsive: true, percentageInnerCutout: 70};
                   $scope.coloursRetard = ['#dd5e60','#d8d8d8'];

                   $scope.labelAvance = ["Avance", "Autres"];
                   $scope.dataAvance = [comptAvance, totalAvance];
                   $scope.options = {responsive: true, percentageInnerCutout: 70};
                   $scope.coloursAvance = ['#72d3a9','#d8d8d8']; 
                   
                   $scope.labelTermine = ["Termine", ""];
                   $scope.dataTermine = [comptTermine, "0"];
                   $scope.options = {responsive: true, percentageInnerCutout: 70};
                   $scope.coloursTermine = ['#d8d8d8','#d8d8d8']; 
                
                });
  });

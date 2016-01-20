'use strict';


var calendarAbsences = angular.module('portail.controllers', ['ui.calendar', 'ui.bootstrap']);

calendarAbsences.controller('AbsencesCtrl',
   function($scope, $compile, $timeout, uiCalendarConfig) {


     $scope.eventSource = {
             url: "http://calendar.google.com/calendar/ical/fr.french%23holiday%40group.v.calendar.google.com/public/basic.ics",
             className: 'gcal-event',           // an option!
             currentTimezone: 'local' // an option!
     };

    /* remove event */
    $scope.remove = function(index) {
      $scope.events.splice(index,1);
    };
    /* Change View */

    $scope.renderCalender = function(calendar) {
      $timeout(function() {
        if(uiCalendarConfig.calendars[calendar]){
          uiCalendarConfig.calendars[calendar].fullCalendar('render');
        }
      });
    };
     /* Render Tooltip */
    $scope.eventRender = function( event, element, view ) {
        element.attr({'tooltip': event.title,
                      'tooltip-append-to-body': true});
        $compile(element)($scope);
    };


    /* config object */
    $scope.uiConfig = {
      calendar:{
        unselectAuto: false,
        selectable: true,
        selectHelper: true,
        weekNumbers: true,
        editable: true,
        header:{
          left: 'prev',
          center: 'title',
          right: 'next'
        },
        select: function(start, end, allDay) {
                start=moment(start).format('YYYY-MM-DD');
                end=moment(end).format('YYYY-MM-DD');
                var mywhen = start + ' au ' + end;
              


             },
        eventClick: $scope.alertOnEventClick,
        eventDrop: $scope.alertOnDrop,
        eventResize: $scope.alertOnResize,
        eventRender: $scope.eventRender
      }
    };

    $scope.uiConfig.calendar.dayNames = ["Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"];
    $scope.uiConfig.calendar.dayNamesShort = ["Dim", "Lun", "Mar", "Mer", "Jeu", "Ven", "Sam"];


    /* event sources array*/
    $scope.eventSources = [$scope.events, $scope.eventSource, $scope.eventsF];
    $scope.eventSources2 = [$scope.calEventsExt, $scope.eventsF, $scope.events];

    $scope.submitButton.on('click', function(e){
    	e.preventDefault();
		  doSubmit();
    });

    function doSubmit(){
	    function diffdate(d1,d2,u){
			     var div=1
			        switch(u){
		 		        case 's': div=1000;
		 			 		  break;
			 	        case 'm': div=1000*60
						 	  break;
			 	        case 'h': div=1000*60*60
							  break;
				        case 'd': div=1000*60*60*24
							  break;
			        }

		       var Diff = d2.getTime() - d1.getTime();
		       return Math.ceil((Diff/div))
		}

    // -------------------- journée complète : pas de fréquence -----------------------------  //


    if(($scope.conge.is(':checked')) && ($scope.journee.is(':checked')) && ($scope.pas_frequence.is(':checked'))){
        var titre = "Congés";
        var color = "rgba(1,66,110,0.5)";

        alert(nb_conge-nb_days+" pas de fréquence");
    }

    else if (($scope.rttQ1.is(':checked')) && ($scope.journee.is(':checked')) && ($scope.pas_frequence.is(':checked'))){
    	var titre = "RTT Q1";
    	var color = "rgba(14,130,188,0.5)";

    	alert(nb_rttQ1-nb_days+" pas de fréquence");
    }
    else if (($scope.rttQ2.is(':checked')) && ($scope.journee.is(':checked')) && ($scope.pas_frequence.is(':checked'))){
    	var titre = "RTT Q2";
    	var color = "rgba(52,204,227,0.5)";

    	alert(nb_rttQ2-nb_days+" pas de fréquence");
    }
    else if (($scope.autre_conge.is(':checked')) && ($scope.journee.is(':checked')) && ($scope.pas_frequence.is(':checked'))){
    	var titre = "Autres";
    	var color = "rgba(121,158,169,0.54)";

    	alert(nb_autre-nb_days+" pas de fréquence");
    };
};

});

$(document).ready(function() {
	

// ------ option de Fullcalendar avec l'entête, la sélection ... ------ //


$('#calendar').fullCalendar({
    weekNumbers: true,   
    header: {
		left:  'prev' ,
		center: 'title',
		right: 'next'
	},
    unselectAuto: false,
    selectable: true,
    selectHelper: true,
	select: function(start, end, allDay) {
          start=moment(start).format('YYYY-MM-DD'); 
          end=moment(end).format('YYYY-MM-DD'); 
          var mywhen = start + ' au ' + end;
          $('#createEventModal #apptStartTime').val(start);
          $('#createEventModal #apptEndTime').val(end);
          $('#createEventModal #apptAllDay').val(allDay);
          $('#createEventModal #when').text(mywhen);
          $('#createEventModal').modal('show');
          
         
       },
    viewRender: function() {
    	$("[data-date=2015-11-01]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2015-11-11]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2015-12-25]").css("color", "rgba(45, 121, 208)");
    	
    	$("[data-date=2016-01-01]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2016-03-28]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2016-05-01]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2016-05-05]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2016-05-08]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2016-05-16]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2016-07-14]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2016-08-15]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2016-11-01]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2016-11-11]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2016-12-25]").css("color", "rgba(45, 121, 208)");
    	
    	$("[data-date=2017-01-01]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2017-04-15]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2017-05-01]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2017-05-08]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2017-05-25]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2017-06-04]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2017-07-14]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2017-08-15]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2017-11-01]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2017-11-11]").css("color", "rgba(45, 121, 208)");
    	$("[data-date=2017-12-25]").css("color", "rgba(45, 121, 208)");
    	
    	$("[data-date=2018-01-01]").css("color", "#rgba(45, 121, 208)");
    	$("[data-date=2018-04-02]").css("color", "#rgba(45, 121, 208)");
    	$("[data-date=2018-05-01]").css("color", "#rgba(45, 121, 208)");
    	$("[data-date=2018-05-08]").css("color", "#rgba(45, 121, 208)");
    	$("[data-date=2018-05-10]").css("color", "#rgba(45, 121, 208)");
    	$("[data-date=2018-05-21]").css("color", "#rgba(45, 121, 208)");
    	$("[data-date=2018-07-14]").css("color", "#rgba(45, 121, 208)");
    	$("[data-date=2018-08-15]").css("color", "#rgba(45, 121, 208)");
    	$("[data-date=2018-11-01]").css("color", "#rgba(45, 121, 208)");
    	$("[data-date=2018-11-11]").css("color", "#rgba(45, 121, 208)");
    	$("[data-date=2018-12-25]").css("color", "#rgba(45, 121, 208)");
    	
},
    eventClick: function (event, start, end){

        
         start=moment(start).format('YYYY-MM-DD'); 
         end=moment(end).format('YYYY-MM-DD'); 
         $('#modalTitle').html(event.title);
         $('#modalBody').html(event.description);
         $('#fullCalModal').modal();
         $('#createEventModal1 #apptStartTime').val(start);
         $('#createEventModal1 #apptEndTime').val(end);
         $('#createEventModal1 #when1').text(mywhen);
     
          var mywhen = start + ' au ' + end;
         $("#datePicker").datepicker({ setDate: moment(start).format('YYYY-MM-DD') });
         $("#datePickerend").datepicker({ minDate: 0 });

         //$('#datePicker').datepicker("setDate", start);
         //$('#datePickerend').datepicker("setDate", end);
       

     },
   
    editable:true,

    /*eventResize: function (event, delta, revertFunc, jsEvent, ui, view) {
        alert(event.title + ' end is now ' + event.end.format());
    },  */
    
     eventDrop: function (event, delta, revertFunc) {
            if (!confirm(event.title + " deplacé " + event.start.format() + ".\nEtes vous sur de ce changement?")) {
                revertFunc();
            }
        },

     eventResize: function (event, delta, revertFunc) {
            if (!confirm(event.title + "la fin est maintenant le " + (event.end.format()) + ".\n\nEtes vous d'accord?")) {
                revertFunc();
            } else {
                alert("La date a été changé " + event.end.format());
            }
        },
        
     
     
     /*eventClick: function(calEvent, jsEvent, view)
        {
            var r=confirm("Delete " + calEvent.title);
            if (r===true)
              {
                  $('#calendar').fullCalendar('removeEvents', calEvent._id);
              }
        },*/
});


// ------ Bouton Valider la demande de congé ------ //


  $('#submitButton').on('click', function(e){
    	e.preventDefault();
		doSubmit();
  });
  
  /*$('#submitButton1').on('click', function(e){
    	// probleme de validation
	
  });*/
  

// ------ fonction qui permet de calculé le nombre de jours qu'il y a entre deux dates ------ //


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
		
    $("#createEventModal").modal('hide');
    var date1 = new Date ($('#apptStartTime').val());
    var date2 = new Date($('#apptEndTime').val());
 	var nb_days=diffdate(date1,date2,'d');
 	
 	
	
// ------ alert par rapport à la popup demandant le type de congé voulût, avec le nombre jours sélectionnés ------ //



    // -------------------- journée complète : pas de fréquence -----------------------------  //
    
    
    if(($('#conge').is(':checked')) && ($('#journee').is(':checked')) && ($('#pas_frequence').is(':checked'))){
        var titre = "Congés";
        var color = "rgba(1,66,110,0.5)";
        
        alert(nb_conge-nb_days+" pas de fréquence");
    }
    
    else if (($('#rttQ1').is(':checked')) && ($('#journee').is(':checked')) && ($('#pas_frequence').is(':checked'))){
    	var titre = "RTT Q1";
    	var color = "rgba(14,130,188,0.5)";
    	
    	alert(nb_rttQ1-nb_days+" pas de fréquence");
    }
    else if (($('#rttQ2').is(':checked')) && ($('#journee').is(':checked')) && ($('#pas_frequence').is(':checked'))){
    	var titre = "RTT Q2";
    	var color = "rgba(52,204,227,0.5)";
    	
    	alert(nb_rttQ2-nb_days+" pas de fréquence");
    }
    else if (($('#autre_conge').is(':checked')) && ($('#journee').is(':checked')) && ($('#pas_frequence').is(':checked'))){
    	var titre = "Autres";
    	var color = "rgba(121,158,169,0.54)";
    	
    	alert(nb_autre-nb_days+" pas de fréquence");
    }
    
    
   // -------------------- journée complète : fréquence hebdomadaire  -----------------------------  //  
   
   
   
   if(($('#conge').is(':checked')) && ($('#journee').is(':checked')) && ($('#hebdo').is(':checked'))){
        var titre = "Congés";
        var color = "rgba(1,66,110,0.5)";
        
        alert(nb_conge-nb_days+" fréquence hebdomadaire");
    }
    
    else if (($('#rttQ1').is(':checked')) && ($('#journee').is(':checked')) && ($('#hebdo').is(':checked'))){
    	var titre = "RTT Q1";
    	var color = "rgba(14,130,188,0.5)";
    	
    	alert(nb_rttQ1-nb_days+" fréquence hebdo");
    }
    else if (($('#rttQ2').is(':checked')) && ($('#journee').is(':checked')) && ($('#hebdo').is(':checked'))){
    	var titre = "RTT Q2";
    	var color = "rgba(52,204,227,0.5)";
    	
    	alert(nb_rttQ2-nb_days+" fréquence hebdo");
    }
    else if (($('#autre_conge').is(':checked')) && ($('#journee').is(':checked')) && ($('#hebdo').is(':checked'))){
    	var titre = "Autres";
    	var color = "rgba(121,158,169,0.54)";
    	
    	alert(nb_autre-nb_days+" fréquence hebdo");
    }
   
   
   
   // -------------------- journée complète : fréquence mensuelle  -----------------------------  //  
   
   
   
   if(($('#conge').is(':checked')) && ($('#journee').is(':checked')) && ($('#mensuelle').is(':checked'))){
        var titre = "Congés";
        var color = "rgba(1,66,110,0.5)";
        
        alert(nb_conge-nb_days+" fréquence mensuelle");
    }
    
    else if (($('#rttQ1').is(':checked')) && ($('#journee').is(':checked')) && ($('#mensuelle').is(':checked'))){
    	var titre = "RTT Q1";
    	var color = "rgba(14,130,188,0.5)";
    	
    	alert(nb_rttQ1-nb_days+" fréquence mensuelle");
    }
    else if (($('#rttQ2').is(':checked')) && ($('#journee').is(':checked')) && ($('#mensuelle').is(':checked'))){
    	var titre = "RTT Q2";
    	var color = "rgba(52,204,227,0.5)";
    	
    	alert(nb_rttQ2-nb_days+" fréquence mensuelle");
    }
    else if (($('#autre_conge').is(':checked')) && ($('#journee').is(':checked')) && ($('#mensuelle').is(':checked'))){
    	var titre = "Autres";
    	var color = "rgba(121,158,169,0.54)";
    	
    	alert(nb_autre-nb_days+" fréquence mensuelle");
    }
    
   
   // --------------------  Demi journée : matin : pas de frequence  ----------------------- // 
   
   
    
    else if (($('#matin').is(':checked')) && ($('#conge').is(':checked')) && ($('#pas_frequence').is(':checked'))) {
    	var titre = "matin";
    	var color = "rgba(1,66,110,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_conge-(nb_days*0.5)+" pas de fréquence");
    }
    else if (($('#matin').is(':checked')) && ($('#rttQ1').is(':checked')) && ($('#pas_frequence').is(':checked'))) {
    	var titre = "matin";
    	var color = "rgba(14,130,188,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_rttQ1-(nb_days*0.5)+" pas de fréquence");
    }
    else if (($('#matin').is(':checked')) && ($('#rttQ2').is(':checked')) && ($('#pas_frequence').is(':checked'))) {
    	var titre = "matin";
    	var color = "rgba(52,204,227,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_rttQ2-(nb_days*0.5)+" pas de fréquence");
    }
    else if (($('#matin').is(':checked')) && ($('#autre_conge').is(':checked')) && ($('#pas_frequence').is(':checked'))) {
    	var titre = "matin";
    	var color = "rgba(121,158,169,0.54)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_autre-(nb_days*0.5)+" pas de fréquence");
    }
    
     // --------------------  Demi journée : matin : fréquence hebdo  ----------------------- // 
   
   
    
    else if (($('#matin').is(':checked')) && ($('#conge').is(':checked')) && ($('#hebdo').is(':checked'))) {
    	var titre = "matin";
    	var color = "rgba(1,66,110,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_conge-(nb_days*0.5)+" fréquence hebdo");
    }
    else if (($('#matin').is(':checked')) && ($('#rttQ1').is(':checked')) && ($('#hebdo').is(':checked'))) {
    	var titre = "matin";
    	var color = "rgba(14,130,188,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_rttQ1-(nb_days*0.5)+" fréquence hebdo");
    }
    else if (($('#matin').is(':checked')) && ($('#rttQ2').is(':checked')) && ($('#hebdo').is(':checked'))) {
    	var titre = "matin";
    	var color = "rgba(52,204,227,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_rttQ2-(nb_days*0.5)+" fréquence hebdo");
    }
    else if (($('#matin').is(':checked')) && ($('#autre_conge').is(':checked')) && ($('#hebdo').is(':checked'))) {
    	var titre = "matin";
    	var color = "rgba(121,158,169,0.54)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_autre-(nb_days*0.5)+" fréquence hebdo");
    }
    
    
    // --------------------  Demi journée : matin : fréquence mensuelle  ----------------------- // 
   
   
    
    else if (($('#matin').is(':checked')) && ($('#conge').is(':checked')) && ($('#mensuelle').is(':checked'))) {
    	var titre = "matin";
    	var color = "rgba(1,66,110,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_conge-(nb_days*0.5)+" fréquence mensuelle");
    }
    else if (($('#matin').is(':checked')) && ($('#rttQ1').is(':checked')) && ($('#mensuelle').is(':checked'))) {
    	var titre = "matin";
    	var color = "rgba(14,130,188,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_rttQ1-(nb_days*0.5)+" fréquence mensuelle");
    }
    else if (($('#matin').is(':checked')) && ($('#rttQ2').is(':checked')) && ($('#mensuelle').is(':checked'))) {
    	var titre = "matin";
    	var color = "rgba(52,204,227,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_rttQ2-(nb_days*0.5)+" fréquence mensuelle");
    }
    else if (($('#matin').is(':checked')) && ($('#autre_conge').is(':checked')) && ($('#mensuelle').is(':checked'))) {
    	var titre = "matin";
    	var color = "rgba(121,158,169,0.54)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_autre-(nb_days*0.5)+" fréquence mensuelle");
    }
    
    
    
    // ----------------------  Demi journée : apres-midi : pas de fréquence  --------------------------- //
    
    
    
    else if (($('#apres_midi').is(':checked')) && ($('#conge').is(':checked'))  && ($('#pas_frequence').is(':checked'))) {
    	var titre = "après-midi";
    	var color = "rgba(1,66,110,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_conge-(nb_days*0.5)+" pas de fréquence");
    }
    else if (($('#apres_midi').is(':checked')) && ($('#rttQ1').is(':checked'))  && ($('#pas_frequence').is(':checked'))) {
    	var titre = "après-midi";
    	var color = "rgba(14,130,188,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_rttQ1-(nb_days*0.5)+" pas de fréquence");
    }
    else if (($('#apres-midi').is(':checked')) && ($('#rttQ2').is(':checked'))  && ($('#pas_frequence').is(':checked'))) {
    	var titre = "après-midi";
    	var color = "rgba(52,204,227,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_rttQ2-(nb_days*0.5)+" pas de fréquence");
    }
    else if (($('#apres-midi').is(':checked')) && ($('#autre_conge').is(':checked'))  && ($('#pas_frequence').is(':checked'))) {
    	var titre = "après-midi";
    	var color = "rgba(121,158,169,0.54)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_autre-(nb_days*0.5)+" pas de fréquence");
    }



 // ----------------------  Demi journée : apres-midi : fréquence hebdo  --------------------------- //
 
 
    
    else if (($('#apres_midi').is(':checked')) && ($('#conge').is(':checked'))  && ($('#hebdo').is(':checked'))) {
    	var titre = "après-midi";
    	var color = "rgba(1,66,110,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_conge-(nb_days*0.5)+" fréquence hebdo");
    }
    else if (($('#apres_midi').is(':checked')) && ($('#rttQ1').is(':checked'))  && ($('#hebdo').is(':checked'))) {
    	var titre = "après-midi";
    	var color = "rgba(14,130,188,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_rttQ1-(nb_days*0.5)+" fréquence hebdo");
    }
    else if (($('#apres-midi').is(':checked')) && ($('#rttQ2').is(':checked'))  && ($('#hebdo').is(':checked'))) {
    	var titre = "après-midi";
    	var color = "rgba(52,204,227,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_rttQ2-(nb_days*0.5)+" fréquence hebdo");
    }
    else if (($('#apres-midi').is(':checked')) && ($('#autre_conge').is(':checked'))  && ($('#hebdo').is(':checked'))) {
    	var titre = "après-midi";
    	var color = "rgba(121,158,169,0.54)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_autre-(nb_days*0.5)+" fréquence hebdo");
    }
    
    
    // ----------------------  Demi journée : apres-midi : fréquence mensuelle  --------------------------- //
    
    
    
    else if (($('#apres_midi').is(':checked')) && ($('#conge').is(':checked'))  && ($('#mensuelle').is(':checked'))) {
    	var titre = "après-midi";
    	var color = "rgba(1,66,110,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_conge-(nb_days*0.5)+" fréquence mensuelle");
    }
    else if (($('#apres_midi').is(':checked')) && ($('#rttQ1').is(':checked'))  && ($('#mensuelle').is(':checked'))) {
    	var titre = "après-midi";
    	var color = "rgba(14,130,188,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_rttQ1-(nb_days*0.5)+" fréquence mensuelle");
    }
    else if (($('#apres-midi').is(':checked')) && ($('#rttQ2').is(':checked'))  && ($('#mensuelle').is(':checked'))) {
    	var titre = "après-midi";
    	var color = "rgba(52,204,227,0.5)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_rttQ2-(nb_days*0.5)+" fréquence mensuelle");
    }
    else if (($('#apres-midi').is(':checked')) && ($('#autre_conge').is(':checked'))  && ($('#mensuelle').is(':checked'))) {
    	var titre = "après-midi";
    	var color = "rgba(121,158,169,0.54)";
    	var qte = 0.5;
    	alert(nb_days*0.5);
    	alert(nb_autre-(nb_days*0.5)+" fréquence mensuelle");
    }



// ------ Fonction qui permet de coloré et de nommer la sélection de congés ------ //



    $("#calendar").fullCalendar('renderEvent',
        {
        	
            backgroundColor: color,
            borderColor: color,
            title: titre,
            start: new Date($('#apptStartTime').val()),
            end: new Date($('#apptEndTime').val()),
            allDay: ($('#apptAllDay').val() == "true"),
        },
        true);
    
    
        


  }  
  
  
  
  

// ------ Id de la personne connectée ------ //


    var nom_id= "Laura Souchu";
    document.getElementById("nom_personne").innerHTML = nom_id;
    
    
// --------  variables tableau récapitulatif ------------ //


	var id_nbConge = 30; // connexion à la base qui permettra de savoir le nb de congé par rapport à l'id
	var nb_congePris = 32;
    var nb_conge = id_nbConge - nb_congePris;
			
	var id_nbRttQ1 = 10;
	var nb_rttQ1Pris = 3;
	var nb_rttQ1 = id_nbRttQ1 - nb_rttQ1Pris;
			
	var id_nbRttQ2 = 10;
	var nb_rttQ2Pris = 1;
	var nb_rttQ2 = id_nbRttQ2 - nb_rttQ2Pris;
			
	var id_nbAutre = 0;
	var nb_autrePris = 1;
	var nb_autre = id_nbAutre - nb_autrePris ;
			
	var id_nbTotal = id_nbConge + id_nbRttQ1 + id_nbRttQ2 + id_nbAutre;
	var nb_totalPris = nb_congePris + nb_rttQ1Pris + nb_rttQ2Pris + nb_autrePris;
	var nb_total = id_nbTotal - nb_totalPris;

	
// --------- Affichage de chaque variable dans le tableau --------- //

	
	window.onload = function(){
	    
		// 1ere ligne du tableau pour les congés 
		document.getElementById("conge_aPrendre").innerHTML = id_nbConge;
		document.getElementById("conge_pris").innerHTML = nb_congePris;
		document.getElementById("conge_restant").innerHTML = nb_conge;
		
		// 2eme ligne du tableau pour les RTT Q1
		document.getElementById("rttQ1_aPrendre").innerHTML = id_nbRttQ1;
		document.getElementById("rttQ1_pris").innerHTML = nb_rttQ1Pris;
		document.getElementById("rttQ1_restant").innerHTML = nb_rttQ1;
		
		// 3eme ligne du tableau pour les RTT Q2
		document.getElementById("rttQ2_aPrendre").innerHTML = id_nbRttQ2;
		document.getElementById("rttQ2_pris").innerHTML = nb_rttQ2Pris;
		document.getElementById("rttQ2_restant").innerHTML = nb_rttQ2;
		
		// 4eme ligne du tableau pour les Autres
		document.getElementById("autre_aPrendre").innerHTML = id_nbAutre;
		document.getElementById("autre_pris").innerHTML = nb_autrePris;
		document.getElementById("autre_restant").innerHTML = nb_autre;
		
		// 5eme ligne du tableau pour le total
		document.getElementById("total_aPrendre").innerHTML = id_nbTotal;
		document.getElementById("total_pris").innerHTML = nb_totalPris;
		document.getElementById("total_restant").innerHTML = nb_total;
	
	
        var Doughnut1 = document.getElementById("conges").getContext("2d");
		var Doughnut2 = document.getElementById("rtt_q1").getContext("2d");
		var Doughnut3 = document.getElementById("rtt_q2").getContext("2d");
			
		var nb_conge_graph = nb_conge;
		var nb_rttQ1_graph = nb_rttQ1;
		var nb_rttQ2_graph = nb_rttQ2;
		
			
// ----- Pour les valeurs négatives ----- //

	
		if (nb_conge_graph<0){
			nb_conge_graph=0;
		}else if(nb_rttQ1_graph<0){
			nb_rttQ1_graph=0;
		}else if(nb_rttQ2_graph<0){
			nb_rttQ2_graph=0;
		}
			
	
		var conges = [
			{ value: nb_congePris,
			    color:"#C00000"
			},
			{ value : nb_conge_graph,
			    color : "#f2f2f2"
			}
		];
			
	    var rtt_q1 = [
			{ value: nb_rttQ1Pris,
			    color:"#C00000"
			},
			{ value : nb_rttQ1_graph,
			    color : "#f2f2f2"
			}
		];
			
		var rtt_q2 = [
			{ value: nb_rttQ2Pris,
			    color:"#C00000"
			  },
			{ value : nb_rttQ2_graph,
			    color : "#f2f2f2"
			  }
		];
	
	
		var doughnut1 = new Chart(Doughnut1).Doughnut(conges, {
		    percentageInnerCutout : 70
		});
			
		var doughnut2 = new Chart(Doughnut2).Doughnut(rtt_q1, {
			percentageInnerCutout : 70
		});
			
	    var doughnut3 = new Chart(Doughnut3).Doughnut(rtt_q2, {
			percentageInnerCutout : 70
		});
			
	};
	
	

});
let fechaAgen;


let tutor_hora_inicio;
let tutor_hora_fin;

var id_agendamiento;

const obtenerCalendario = async () => {
            
    let respuesta;
    

    var pagina = window.location.href.toString();

    var id = pagina.split("=");

    id_agendamiento = id[1];

    await fetch('obtenerFechas?' + new URLSearchParams({ id : id[1] }).toString()).then(function (response) {
        return response.text();
    }).then(function (data) {
        console.log(data);
        respuesta = data.split(",");
    }).catch(function (err) {
        console.warn('Something went wrong.', err);
    });
    
    tutor_hora_inicio = respuesta[0];
    
    tutor_hora_fin = respuesta[1]; 
    
    var fecha_inicio_tutor = respuesta[2];

    
    var fecha_fin_tutor = respuesta[3];
    
   

    var inicio = moment();

    

    $('#fecha-dispo').daterangepicker({
        "singleDatePicker": true,
        "minDate": fecha_inicio_tutor,
        "maxDate": fecha_fin_tutor
        
    }, function(start, end, label) {
        fechaAgen = start.format("YYYY-MM-DD");

    });

    $('#hora-agen').append('Tutor disponible desde ' + tutor_hora_inicio + ' hasta ' + tutor_hora_fin);   
            
            
            
        
};


$(obtenerCalendario());

$(document).ready(function(){
    
    $('#errores').empty();
    
    $('#mandarAgen').click( function(){ 
        let horaDef = $("#hora-def").val();
        let datos = $("#datos-adicionales").val()

        console.log(horaDef);
        
        if(horaDef == ""){
            $('#errores').append("<p class='error'>Debe agendar la hora</p>");
        }
        

        if(fechaAgen != null && horaDef != ""){

             enviarAgen();

        }


    });
    
    
    
});


function enviarAgen(){
    
    
    var valores = {
        fechaAgen : fechaAgen,
        horaFin : $("#hora-def").val(),
        id: id_agendamiento,
        datosAdicionales : $("#datos-adicionales").val()
        
    }
    
        
        
    $.ajax({
        url: "http://localhost:8080/agregarAgendamiento",
        type: "POST",
        data: valores,
        cache: false,
        timeout: 600000,
        encode: true,
        success: function () {

            location.replace("http://localhost:8080/mis_tutorias");
            


        },
        error: function(error){
            
            
            

            $('#errores').html("<p class='error'>" + error.responseText + "</p>");

        }
        //processData: false,
        //contentType: false,

    });

}     
        
        

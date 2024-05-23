let fechaInicio;
let fechaFin;


var id_agendamiento;

const obtenerCalendario = async () => {
            
    let fecha;

    var pagina = window.location.href.toString();

    var id = pagina.split("=");

    id_agendamiento = id[1];

    await fetch('consultarFechaLimite?' + new URLSearchParams({ id : id[1] }).toString()).then(function (response) {
        return response.text();
    }).then(function (data) {
        console.log(data);
        fecha = data;
    }).catch(function (err) {
        console.warn('Something went wrong.', err);
    });

    var inicio = moment();

    console.log(fecha);

    $('#fecha-dispo').daterangepicker({
        "timePicker": true,
        "minDate": inicio,
        "maxDate": fecha
        
    }, function(start, end, label) {
        fechaInicio = start.format("YYYY-MM-DD");
        fechaFin = end.format("YYYY-MM-DD");

    });

            
            
            
            
        
};


$(obtenerCalendario());

$(document).ready(function(){
    
    
    
    $('#mandarAgen').click( function(){ 
        let horaInicio = $("#hora-inicio").val();
        let horaFin = $("#hora-fin").val();

        console.log(horaInicio);

        if(fechaInicio != null && fechaFin != null && horaInicio != "" && horaFin != "" ){

             enviarAgen();

        }


    });
    
    
    
});









function enviarAgen(){
    console.log(fechaInicio);
    
    var valores = {
        fechaInicio : fechaInicio,
        fechaFin : fechaFin,
        horaInicio: $("#hora-inicio").val(),
        horaFin : $("#hora-fin").val(),
        id: id_agendamiento
        
    }
    
        
        
    $.ajax({
        url: "http://localhost:8080/agregarAgendamientoHorario",
        type: "POST",
        data: valores,
        cache: false,
        timeout: 600000,
        encode: true,
        success: function () {

            location.replace("http://localhost:8080/tutorias_asignadas");
            


        },
        error: function(error){
            
            
            

            fetch('agendamientoHorario?' + new URLSearchParams({ id : id_agendamiento }).toString()).then(function (response) {
                   return response.text();
               }).then(function (html) {
                   $('#errores').html(error.responseText);
               }).catch(function (err) {
                   console.warn('Something went wrong.', err);
               });

        }
        //processData: false,
        //contentType: false,

    });

}     
        
        
        
        
        
        
        

        
   
    
    
    
    
    






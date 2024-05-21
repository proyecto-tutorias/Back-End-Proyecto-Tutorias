$(document).ready(
        
        function() {
            listaSemestre();
        
        }
        
);




function listaSemestre() {


    var valores = {
        idCarrera: $("#carreras option:selected").val()
    }
    $.ajax({
        url: "http://localhost:8080/obtenerCarrera",
        type: "POST",
        data: valores,
        cache: false,
        timeout: 600000,
        encode: true,
        success: function () {
            fetch('listaSemestre').then(function (response) {
                return response.text();
            }).then(function (html) {
                console.log(html);
                $('#semestre').remove();
                $('#semestre-lista').append(html);
            }).catch(function (err) {
                console.warn('Something went wrong.', err);
            });
        }
        //processData: false,
        //contentType: false,

    });




}



function obtenerSemestre() {

    var carrera

    var valores = {
        semestre: $("#semestre option:selected").val()
    }
    $.ajax({
        url: "http://localhost:8080/obtenerSemestre",
        type: "POST",
        data: valores,
        cache: false,
        timeout: 600000,
        encode: true
       
        //processData: false,
        //contentType: false,

    });


}












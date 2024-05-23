
function mandarModif() {
    
    var pagina = window.location.href.toString();

    var id = pagina.split("=");

    id_usuario = id[1];

    

    var valores = {
        semestre: $("#semestre option:selected").val(),
        rango: $("#rangos option:selected").val(),
        carrera: $("#carreras option:selected").val(),
        id: id_usuario
    }
    $.ajax({
        url: "http://localhost:8080/modUsuario",
        type: "POST",
        data: valores,
        cache: false,
        timeout: 600000,
        encode: true,
        success: function () {
            location.replace("http://localhost:8080/lista_usuarios");
        }
        //processData: false,
        //contentType: false,

    });


}

function agregarTutor(){
    
    var pagina = window.location.href.toString();

    var id = pagina.split("=");

    id_usuario = id[1];
    
    
    var valores = {
        id: id_usuario
    }
    $.ajax({
        url: "http://localhost:8080/agregarTutor",
        type: "POST",
        data: valores,
        cache: false,
        timeout: 600000,
        encode: true,
        success: function () {
            window.location.reload();
        }
        //processData: false,
        //contentType: false,

    });

    
    
    
    
}
function deshacerTutor(){
    
    var pagina = window.location.href.toString();

    var id = pagina.split("=");

    id_usuario = id[1];
    
    
    var valores = {
        id: id_usuario
    }
    $.ajax({
        url: "http://localhost:8080/desactivarTutor",
        type: "POST",
        data: valores,
        cache: false,
        timeout: 600000,
        encode: true,
        success: function () {
            window.location.reload();
        }
        //processData: false,
        //contentType: false,

    });

    
    
    
    
}




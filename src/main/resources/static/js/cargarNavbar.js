

function cargarNav(){
    
    fetch('navbar').then(function (response) {
        return response.text();
    }).then(function (data) {
        $('#navbar').html(data);
    }).catch(function (err) {
        console.warn('Something went wrong.', err);
    });
    
    
}

$(cargarNav());

function desactivarTutoria(id){
    
   
    
    var valores = {
        id: id
    }
    $.ajax({
        url: "http://localhost:8080/desactivarTutoria",
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
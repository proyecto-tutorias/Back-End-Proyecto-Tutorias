function desacTuto(id) {
    
  

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



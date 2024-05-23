

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
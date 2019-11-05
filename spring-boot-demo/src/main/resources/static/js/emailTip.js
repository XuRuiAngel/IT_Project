function emailTip() {
    $.ajax({
        type:"GET",
        url:"/tipEmail",
        data:{},
        dataType:"text",
        async:false,
        success:function(data) {

        }
    })
}

function deleteReservation() {
    $.ajax({
        type:"GET",
        url:"/deleteReservation",
        data:{},
        dataType:"text",
        async:false,
        success:function(data) {

        }
    })
}

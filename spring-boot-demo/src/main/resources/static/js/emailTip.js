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
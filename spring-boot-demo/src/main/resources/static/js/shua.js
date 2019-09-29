function searchBook() {

    var key=$('#choose').val();
    var text=$('#keyboard').val();
	
        $.ajax({
            async: false,
            type: "GET",
            url:"/searchBook?key="+key+"&text="+text,
            data:{},
            dataType: "text",
            success: function (data) {
                alert(key);
                alert(data);
            }

        })
}


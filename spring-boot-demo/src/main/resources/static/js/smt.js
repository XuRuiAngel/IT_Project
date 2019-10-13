$("#btn").click(function(){
	var y=$("#iform").serialize();
console.log(y);
	
        $.ajax({
            async: false,
            type: "POST",
            url:'${pageContext.request.contextPath}/link/apply',
            contentType : "application/x-www-form-urlencoded; charset=utf-8",
            data:$("#iform").serialize(),
            dataType: "text",			

        })
});


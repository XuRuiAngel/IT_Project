function getCookie(cookieName) {
    //获取所有的cookie "psw=1234we; rememberme=true; user=Annie"
    var totalCookie = document.cookie;
    //获取参数所在的位置
    var cookieStartAt = totalCookie.indexOf(cookieName + "=");
    //判断参数是否存在 不存在直接返回
    if (cookieStartAt == -1) {
        return;
    }
    //获取参数值的开始位置
    var valueStartAt = totalCookie.indexOf("=", cookieStartAt) + 1;
    //以;来获取参数值的结束位置
    var valueEndAt = totalCookie.indexOf(";", cookieStartAt);
    //如果没有;则是最后一位
    if (valueEndAt == -1) {
        valueEndAt = totalCookie.length;
    }
    //截取参数值的字符串
    var cookieValue = unescape(totalCookie.substring(valueStartAt, valueEndAt));
    return cookieValue;
}


function searchInformation() {
	// var key=$('#id').val();
    //var ide=request.QueryString("idea");
    var tele=getCookie("rtele");
        $.ajax({
            async: false,
            type: "GET",
            url:"getReadByTele?tele="+tele,
            // data:{},
            dataType: "JSON",
            success: function (data) {
                // var result=JSON.stringify(data);
                var result=data;
                //var b=eval("("+a+")");

               //var result=a.result;

            //用一个变量来存储json中的数据
              //  for (i = 0; i < result.length; i++) { //用for循环遍历数组将数据存入html变量中

    var id=result.id;
    var username=result.username;
    var balance=result.balance;
    var e_mail=result.e_mail;
    var tele=result.tele;
    var registerdate=result.regitherdate;
    document.getElementById("userid").value=id;
    document.getElementById("id").value=id;
	document.getElementById("username").value=username;
	document.getElementById("balance").value=balance;
	document.getElementById("e_mail").value=e_mail;
	document.getElementById("tele").value=tele;
	document.getElementById("registerdate").value=registerdate;
                }

		})
}


 
   
function ReadCookie(cookieName)
{
    var theCookie=""+document.cookie;
    var ind=theCookie.indexOf(cookieName);
    if(ind==-1||cookieName=="")return"";
    var ind1=theCookie.indexOf(';',ind);
    if(ind1==-1) ind1=theCookie.length;
    return unescape(theCookie.substring(ind+cookieName.length+1,ind1));
}
function searchInformation() {
	// var key=$('#id').val();
    //var ide=request.QueryString("idea");
    var tele=ReadCookie("userids");
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


 
   
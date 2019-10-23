// JavaScript Document
// function ReadCookie(cookieName)
// {
//     var theCookie=""+document.cookie;
//     var ind=theCookie.indexOf(cookieName);
//     if(ind==-1||cookieName=="")return"";
//     var ind1=theCookie.indexOf(';',ind);
//     if(ind1==-1) ind1=theCookie.length;
//     return unescape(theCookie.substring(ind+cookieName.length+1,ind1));
// }
var id;
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

            id=result.id;
        }

    })
}

function viewHistory() {
    $.ajax({
        async: false,
        type: "GET",
        // data:{},
        url:"/getRecordByUserId?userId="+id,
        dataType: "JSON",
        success: function (data) {
            var a=JSON.stringify(data);
            var b=eval("("+a+")");
            var result=b.result;
            //var b=eval("("+a+")");
            //var result=b.result;
            //用一个变量来存储json中的数据
            for (i = 0; i < result.length; i++) { //用for循环遍历数组将数据存入html变量中
                //var id=result[i].BookId;
                //var id=result[i].BookId;

               // var id=result[i].bookId;
                //var len=length(id);
                //for(var j=0;j<5-len;j++)
                //{
                    //id="0"+id;
               // }
                var recordId=result[i].recordId;
                var userId=result[i].userId;
                var bookid=result[i].bookId;
                var borrowTime=result[i].borrowTime;
                var returnTime=result[i].returnTime;
                var fine=result[i].fine;
                if(fine==-1) fine="not return";
                var html = "\t<th>"+recordId+"</th>\n" +
                    "\t\t\t<th>"+userId+"</th>\n" +
                    "\t\t\t<th>"+bookid+"</th>\n" +
                    "\t\t\t<th>"+borrowTime+"</th>\n" +
                    "\t\t\t<th>"+returnTime+"</th>\n" +
                    "\t\t\t<th>"+fine+"</th>";
                document.getElementById("tbody").innerHTML =document.getElementById("tbody").innerHTML+ html;
            }

        }

    })
}
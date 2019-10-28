function viewDeletionHistory() {
    $.ajax({
        async: false,
        type: "GET",
        // data:{},
        url:"/getDeletionRecord",
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
                var userId=result[i].userId;
                var bookid=result[i].bookId;
                var borrowTime=result[i].time;
                var fine=result[i].reason;
                var html =
                    "\t<th>"+userId+"</th>\n" +
                    "\t\t\t<th>"+bookid+"</th>\n" +
                    "\t\t\t<th>"+borrowTime+"</th>\n" +
                    "\t\t\t<th>"+fine+"</th>";
                document.getElementById("tbody").innerHTML =document.getElementById("tbody").innerHTML+ html;
            }

        }

    })
}
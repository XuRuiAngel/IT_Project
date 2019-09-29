function myFunction(){
        $.ajax({
            async: false,
            type: "GET",
            url:"getnews",
            contentType : "application/x-www-form-urlencoded; charset=utf-8",
            dataType: "json",	
		          success: function (data) {
            var i;
            var html='';//用一个变量来存储json中的数据

            for (i = 0; i < data.length; i++) { //用for循环遍历数组将数据存入html变量中
                html += `<tr>
                            <td>${data[i].newsId}</td>
                            <td>${data[i].title}</td>
                            <td>${data[i].content}</td>
                            </tr>`;
            }
            document.getElementById("newsbody").innerHTML += html;
        },
        error: function () {
            //请求失败之后做的事情
        }
        })
};



// JavaScript Document
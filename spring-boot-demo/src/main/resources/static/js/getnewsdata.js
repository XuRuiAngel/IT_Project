function myFunction(){
        $.ajax({
            async: false,
            type: "GET",
            url:"/getNews",
            data:{},
            contentType : "application/x-www-form-urlencoded; charset=utf-8",
            dataType: "JSON",
		          success: function (data) {
            //     alert(data);
            // var i;
            // var html='';//用一个变量来存储json中的数据
            //
            // for (i = 0; i < data.length; i++) { //用for循环遍历数组将数据存入html变量中
            //     html += `<tr>
            //
            //                 <td>${data[i].title}</td>
            //                 <td>${data[i].content}</td>
            //                 </tr>`;
            // }
            // document.getElementById("box").innerHTML += html;
                      var i;
                      var a=JSON.stringify(data);
                      var b=eval("("+a+")");

                      var result=b.result;

                      //用一个变量来存储json中的数据
                      for (i = 0; i < result.length; i++) { //用for循环遍历数组将数据存入html变量中
                          var tit=result[i].title;
                          var cont=result[i].content;

                          var html = "\t<th>"+tit+"</th>\n" +
                              "\t\t\t<th>"+cont+"</th>\n" ;
                          document.getElementById("box").innerHTML =document.getElementById("box").innerHTML+ html;
                      }

                  },
        error: function () {
            //请求失败之后做的事情
        }
        })
};



// JavaScript Document
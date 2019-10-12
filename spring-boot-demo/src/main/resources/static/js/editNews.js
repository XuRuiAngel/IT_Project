(function () {
    $.ajax({
        //url: "index.json",//向本地的json文件发送请求
        type: "get",
         url:"/getNews",
        data:{},
        contentType : "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "JSON",
        success: function (data) {
            var a=JSON.stringify(data);
            var b=eval("("+a+")");
            var result=b.result;
            // pager.init(1);
            // pager.setLayout('show_tbody', data, 100, function () {
                $('#show_tbody').html('');
            for (var i = 0; i < result.length; i++) {
                if (result[i]) {
                        $('#show_tbody').append('<tr><td>' + result[i].newsId + '</td>' + '<td>'+ result[i].title+ '</td>' + '<td>'+result[i].content + '</td>'+'<td>'+'<a href="#" class="edit">edit</a>  <a href="#" class="del">delete</a>'+'</td></tr>');
                    }
                }

            // });
        },
        error: function () {
            //请求失败之后做的事情
        }
    })
})();

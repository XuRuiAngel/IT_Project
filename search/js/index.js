(function () {
    $.ajax({
        url: "content.json",//向本地的json文件发送请求
        type: "GET",
        success: function (data) {
            pager.init(1);
            pager.setLayout('pagerDiv', data, 100, function () {
                $('#tbody').html('');
                for (var i = pager.start() - 1; i < pager.end(); i++) {
                    if (data[i]) {
                        $('#tbody').append('<tr><td>' + data[i].BookId + '</td>' + '<td>'+ data[i].ISBN+ '</td>' + '<td>'+data[i].Price + '</td>'+ '<td>'+data[i].Location + '</td>'+  '<td>'+data[i].BookName + '</td>'+  '</td>'+data[i].Author + '</td>'+ '<td>'+data[i].Press + '</td>'+'<td>'+data[i].Author + '</td>'+'<td>'+data[i].Description + '</td>'+'<td>'+data[i].PublishYear + '</td>'+'<td>'+data[i].TextLanguage + '</td>'+'<td>'+data[i].CopyNumbers +'</td></tr>');
                    }
                }
            });
        },
        error: function () {
            //请求失败之后做的事情
        }
    })
})();


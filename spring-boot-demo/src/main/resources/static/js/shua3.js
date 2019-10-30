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
function searchBook() {

    var key=$('#choose').val();
    var text=$('#keyboard').val();

    $.ajax({
        async: false,
        type: "GET",
        url:"/searchBook?key="+key+"&text="+text,
        data:{},
        dataType: "JSON",
        success: function (data) {
            $("#tbody").html("");
            var i;
            var a=JSON.stringify(data);
            var b=eval("("+a+")");

            var result=b.result;

            //用一个变量来存储json中的数据
            for (i = 0; i < result.length; i++) { //用for循环遍历数组将数据存入html变量中


                var id=result[i].bookId;
                var len=length(id);
                for(var j=0;j<9-len;j++)
                {
                    id="0"+id;
                }

                var isbn=result[i].ISBN;
                var pri=result[i].price;
                var loa=result[i].location;
                var bn=result[i].bookname;
                var aut=result[i].author;
                var pre=result[i].press;
                var des=result[i].description;
                var pub=result[i].publishYear;
                var tex=result[i].textLanguage;
                var cop=result[i].copyNumbers;

                var sta="edit";
                var sta1="del";

                if(cop==0||cop==1||cop==2){
                    var html = "\t<th>" + id + "</th>\n" +
                        "\t\t\t<th>" + isbn + "</th>\n" +
                        "\t\t\t<th>" + pri + "</th>\n" +
                        "\t\t\t<th>" + loa + "</th>\n" +
                        "\t\t\t<th>" + bn + "</th>\n" +
                        "\t\t\t<th>" + aut + "</th>\n"
                        // + "\t\t\t<th>"+pre+"</th>\n"
                        + "\t\t\t<th>" + des + "</th>\n" +
                        // "\t\t\t<th>"+pub+"</th>\n" +
                        // "\t\t\t<th>"+tex+"</th>\n" +

                        "\t\t\t<th><a href ='#'><input id=edit class='edit' type='button'style='color:white;height:30px;border-bottom-left-radius:0.5px;background-color:#734e55;font-size:15px'value=" + sta + "><input id=del class='del' type='button'style='color:white;height:30px;border-bottom-left-radius:0.5px;background-color:#734e55;font-size:15px'value=" + sta1 + "></a></th>";

                    document.getElementById("tbody").innerHTML =document.getElementById("tbody").innerHTML+ html;
                }

            }

        }

    })
}

function length(str){
    var i = 0;
    while(str[i] !== undefined){
        i++;
    }
    return i;
}

$('#tbody').on('click','.del', function () {
    msgbox1(1);
    trIndex = $('.del', '#tbody').index($(this));
    addEnter = false;
    var bookId = parseInt($(this).parents().children("th:eq(0)").text());
    var $tr = $(this).parents('tr');
    var userId=getCookie("tele");


    $('#commit1').click(function () {
        var deletionreason=blank($("#Reason").val());
        $.ajax({
            type: "post",
            url : "/deleteBook?bookId="+bookId+"&userId="+userId+"&reason="+deletionreason,
            success: function() {
                //成功后直接移除当前行

                $tr.remove();
            },
            error: function() {
            }
        });
    })


})

$('#tbody').on('click','.edit', function () {
    msgbox(1);
    $.ajax({
        type:"GET",
        url:"/getBookLocation",
        data:{},
        dataType:"JSON",
        async:false,
        success:function(data) {
            var unitObj1=document.getElementById("bookLocation"); //页面上的<html:select>元素
            var a=JSON.stringify(data);
            var b=eval("("+a+")");
            var result=b.result;
            for(var i=0;i<result.length;i++){
                var btname1="floor"+result[i].FloorNo+"shelf"+result[i].ShelfNo;
                unitObj1.options.add(new Option(btname1,btname1));
            }
        }
    })
    trIndex = $('.edit', '#tbody').index($(this));
    addEnter = false;
    var bookId = $(this).parents().children("th:eq(0)").text();


    $('#commit').click(function () {
        editbook(bookId);}
    )

    // $(this).parents('tr').remove();
})
function msgbox(n){
    document.getElementById('inputbox').style.display=n?'block':'none';     /* 点击按钮打开/关闭 对话框 */
}
function msgbox1(n){
    document.getElementById('inputbox1').style.display=n?'block':'none';     /* 点击按钮打开/关闭 对话框 */
}
function editbook(bookId) {


    var bd=$("#bD").val();

    var bl=$("#bookLocation option:selected").val();


    $.ajax({
        type: "post",
        url: "/changeBook?bookId="+bookId+"&description="+bd+"&location="+bl,
        success: function(data) {            //成功后直接移除当前行
            window.location.reload();
        },
        error: function() {
        }
    });

};
function blank(a)
{
    if(a==null){
        return "/";
    }
    else {
        return a;
    }
}
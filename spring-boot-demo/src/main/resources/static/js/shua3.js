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
    trIndex = $('.del', '#tbody').index($(this));
    addEnter = false;
    var bookId = $(this).parents().children("th:eq(0)").text();
    var $tr = $(this).parents('tr');
    $.ajax({
        type: "post",
        url: "/deleteBook?bookId="+bookId,
        success: function(data) {            //成功后直接移除当前行
            $tr.remove();
        },
        error: function() {
        }
    });
    // $(this).parents('tr').remove();
})

$('#tbody').on('click','.edit', function () {
    msgbox(1);
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
  function editbook(bookId) {


    var bd=$("#bD").val();

    var bl=$("#floor option:selected").val()+$("#Shelf option:selected").val();


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
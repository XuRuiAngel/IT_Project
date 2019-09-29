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
                    for(var j=0;j<8-len;j++)
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
                   var html = "\t<th>"+id+"</th>\n" +
                        "\t\t\t<th>"+isbn+"</th>\n" +
                        "\t\t\t<th>"+pri+"</th>\n" +
                        "\t\t\t<th>"+loa+"</th>\n" +
                        "\t\t\t<th>"+bn+"</th>\n" +
                        "\t\t\t<th>"+aut+"</th>\n"
                       // + "\t\t\t<th>"+pre+"</th>\n"
                       + "\t\t\t<th>"+des+"</th>\n" +
                        // "\t\t\t<th>"+pub+"</th>\n" +
                        // "\t\t\t<th>"+tex+"</th>\n" +
                        "\t\t\t<th>"+cop+"</th>";
                    document.getElementById("tbody").innerHTML =document.getElementById("tbody").innerHTML+ html;
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
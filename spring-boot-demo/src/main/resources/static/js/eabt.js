function getBts(){

     $.ajax({
             type:"GET",
             url:"/getBookCatagory",
             data:{},
             dataType:"JSON",
             async:false,
             success:function(data) {

                var a=JSON.stringify(data);
                var b=eval("("+a+")");
                var result=b.result;
                 for(var i=0;i<result.length;i++){
                     var btname=result[i].Typename;
                     var id=result[i].categoryID;
                     var html=           " <tr >\n"+
                                             " <td>"+btname+"</td>\n"+
                                             " <td>"+id+"</td>\n"+
                                          "    <td>\n"+
                                               "   <a id='"+id+" ' onclick='getRid(this.id)' href='#' class='del'>Delete</a>\n"+
											   " </td>\n"+
                                        "  </tr>\n";
                                         document.getElementById("show_tbody").innerHTML = document.getElementById("show_tbody").innerHTML + html;
                 }
             }
         })
}

    function  getRid(id) {

        $.ajax({
            type:"POST",
            url:"/deleteBookCatagory?ID="+id,
            data:{},
            dataType:"String",
            async:false,
            success:function(msg) {
                alert(msg);
            }
        })
        window.location.reload();
    }

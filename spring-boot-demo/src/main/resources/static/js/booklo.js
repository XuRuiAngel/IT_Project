function getBookLocation(){

     $.ajax({
             type:"GET",
             url:"/getBookLocation",
             data:{},
             dataType:"JSON",
             async:false,
             success:function(data) {

                var a=JSON.stringify(data);
                var b=eval("("+a+")");
                var result=b.result;
                 for(var i=0;i<result.length;i++){
                     var locationID=result[i].locationID;
                     var FloorNo=result[i].FloorNo;
					 var ShelvNo=result[i].ShelfNo;
                     var html=           " <tr >\n"+
                                             " <td>"+locationID+"</td>\n"+
                                             " <td>"+FloorNo+"</td>\n"+
						 					" <td>"+ShelvNo+"</td>\n"+
                                          "    <td>\n"+
                                               "   <a id='"+locationID+"' onclick='getRid1(this.id)' href='#' class='del'>Delete</a>\n"+
											   " </td>\n"+
                                        "  </tr>\n";
                                         document.getElementById("show_tbody").innerHTML = document.getElementById("show_tbody").innerHTML + html;
                 }
             }
         })
}

    function  getRid1(id) {

        $.ajax({
            type:"POST",
            url:"/deleteBookLocation?ID="+id,
            data:{},
            dataType:"int",
            async:false,
            success:function(msg) {
                alert(msg);
            }
        })
        window.location.reload();
    }

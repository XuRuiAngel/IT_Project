function searchRecord(){
 var readerId=$('#readerId').val();
     $.ajax({
             type:"GET",
             url:"/getRecordByUserId?userId="+readerId,
             data:{},
             dataType:"JSON",
             async:false,
             success:function(data) {
 document.getElementById("show_tbody").innerHTML="";
                var a=JSON.stringify(data);
                var b=eval("("+a+")");
                var result=b.result;

                 for(var i=0;i<result.length;i++){
                     var recordId=result[i].recordId;
                     var userId=result[i].userId;
                     var BookID=result[i].bookId;
                     var Time=result[i].borrowTime;
                     var Fine=result[i].fine;
                    if(Fine!=-1) continue;
                     var html=           " <tr  >\n"+
                                             " <td>"+recordId+"</td>\n"+
                                             " <td>"+userId+"</td>\n"+
                                          "  <td>"+BookID+"</td>\n"+
                                            "  <td>"+Time+"</td>\n"+
                                          "    <td>\n"+
                                               "   <button id='"+recordId+"'  onclick='returnBook(this.id)' >Return</button>\n"+
                                             " </td>\n"+
                                        "  </tr>\n";

                                     document.getElementById("show_tbody").innerHTML = document.getElementById("show_tbody").innerHTML + html;
                 }
             }
         })
}

function returnBook(recordId){


    $.ajax({
        type:"POST",
        url:"/returnBook?recordId="+recordId,
        data:{},
        dataType:"text",
        async:false,
        success:function(msg) {

        window.location.href="ReturnBook";
          alert(msg);
        }
    })


}

function  getid(id) {

}

function getRecord(){

     $.ajax({
             type:"GET",
             url:"/getRecord",
             data:{},
             dataType:"JSON",
             async:false,
             success:function(data) {
 document.getElementById("show_tbody").innerHTML="";
                var a=JSON.stringify(data);
                var b=eval("("+a+")");
                var result=b.result;

                 for(var i=0;i<result.length;i++){
                     var recordId=result[i].recordId;
                     var userId=result[i].userId;
                     var BookID=result[i].bookId;
                     var Time=result[i].borrowTime;
                     var Fine=result[i].fine;
                         if(Fine!=-1) continue;
                     var html=           " <tr  >\n"+
                                             " <td>"+recordId+"</td>\n"+
                                             " <td>"+userId+"</td>\n"+
                                          "  <td>"+BookID+"</td>\n"+
                                            "  <td>"+Time+"</td>\n"+
                                          "    <td>\n"+
                                               "   <button id='"+recordId+"'  onclick='returnBook(this.id)' >Return</button>\n"+
                                             " </td>\n"+
                                        "  </tr>\n";

                                     document.getElementById("show_tbody").innerHTML = document.getElementById("show_tbody").innerHTML + html;
                 }
             }
         })
}
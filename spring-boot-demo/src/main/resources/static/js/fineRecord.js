function getFineRecord(){

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
                     var readerId=result[i].userId;
                     var BookID=result[i].bookId;
                     var returnTime=result[i].returnTime;
                     var Fine=result[i].fine;
                     if(result[i].flag==1)
                     {  var state="Paid"; }
                    else
                     {  var state="Not paid"; }
                    if(Fine<=0) continue;
                     var html=           " <tr  >\n"+
                                             " <td>"+readerId+"</td>\n"+
                                          "  <td>"+BookID+"</td>\n"+
                                           "  <td>"+returnTime+"</td>\n"+
                                           "  <td>"+Fine+"</td>\n"+
                                            "  <td>"+state+"</td>\n"+

                                 " </td>\n"+
                                        "  </tr>\n";

                                     document.getElementById("show_tbody").innerHTML = document.getElementById("show_tbody").innerHTML + html;
                 }
             }
         })
}



function PaidRecord(){

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
                     var readerId=result[i].userId;
                     var BookID=result[i].bookId;
                     var returnTime=result[i].returnTime;
                     var Fine=result[i].fine;
                     var Flag=result[i].flag;
                     if(result[i].flag=1)
                     {  var state="Paid"; }
                    else
                     {  var state="Not paid"; }
                     if(Flag!=1||Fine<=0) continue;
                     var html=           " <tr  >\n"+
                                             " <td>"+readerId+"</td>\n"+
                                             " <td>"+BookID+"</td>\n"+
                                          "  <td>"+returnTime+"</td>\n"+
                                            "  <td>"+Fine+"</td>\n"+
                                             "  <td>"+state+"</td>\n"+

                                        "  </tr>\n";

                                     document.getElementById("show_tbody").innerHTML = document.getElementById("show_tbody").innerHTML + html;
                 }
             }
         })
}


function NotPaidRecord(){

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
                  var readerId=result[i].userId;
                  var BookID=result[i].bookId;
                  var returnTime=result[i].returnTime;
                  var Fine=result[i].fine;
                  var Flag=result[i].flag;
                  if(result[i].flag==1)
                  {  var state="Paid"; }
                  else
                  {  var state="Not paid"; }
                    if(Flag!=0||Fine<=0) continue;


                     var html=           " <tr  >\n"+
                                             " <td>"+readerId+"</td>\n"+
                                             " <td>"+BookID+"</td>\n"+
                                          "  <td>"+returnTime+"</td>\n"+
                                            "  <td>"+Fine+"</td>\n"+
                                            "  <td>"+state+"</td>\n"+
                                          "    <td>\n"+
                                               "   <button id='"+recordId+"'  onclick='pay(this.id)' >Pay</button>\n"+
                                             " </td>\n"+
                                        "  </tr>\n";

                                     document.getElementById("show_tbody").innerHTML = document.getElementById("show_tbody").innerHTML + html;
                 }
             }
         })
}
function pay(recordId){


    $.ajax({
        type:"POST",
        url:"/payFine?recordId="+recordId,
        data:{},
        dataType:"text",
        async:false,
        success:function(msg) {

          alert(msg);
        window.location.href="fineRecord";

        }
    })


}











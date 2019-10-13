function getLibrarians(){

     $.ajax({
             type:"GET",
             url:"/getLibrarians",
             data:{},
             dataType:"JSON",
             async:false,
             success:function(data) {

                var a=JSON.stringify(data);
                var b=eval("("+a+")");
                var result=b.result;

                 for(var i=0;i<result.length;i++){
                     var username=result[i].username;
                     var id=result[i].id;
                     var tele=result[i].tele;
                     var e_mail=result[i].e_mail;
                     var html=           " <tr id='"+id+"' onclick='getid(this.id)'>\n"+
                                             " <td>"+username+"</td>\n"+
                                             " <td>"+id+"</td>\n"+
                                          "    <td>"+tele+"</td>\n"+
                                            "  <td>"+e_mail+"</td>\n"+
                                          "    <td>\n"+
                                               "   <a href='#' class='edit'>Edit</a>\n"+
                                                 " <a href='#' class='del'>Delete</a>\n"+
                                             " </td>\n"+
                                        "  </tr>\n";
                                         document.getElementById("show_tbody").innerHTML = document.getElementById("show_tbody").innerHTML + html;
                 }
             }
         })
}

function getReaders(){

    $.ajax({
        type:"GET",
        url:"/getReaders",
        data:{},
        dataType:"JSON",
        async:false,
        success:function(data) {

            var a=JSON.stringify(data);
            var b=eval("("+a+")");
            var result=b.result;

            for(var i=0;i<result.length;i++){
                var username=result[i].username;
                var id=result[i].id;
                var tele=result[i].tele;
                var e_mail=result[i].e_mail;
                var html=           " <tr id='"+id+"' onclick='getRid(this.id)'>\n"+
                    " <td>"+username+"</td>\n"+
                    " <td>"+id+"</td>\n"+
                    "    <td>"+tele+"</td>\n"+
                    "  <td>"+e_mail+"</td>\n"+
                    "    <td>\n"+
                    "   <a href='#' class='edit'>Edit</a>\n"+
                    " <a href='#' class='del'>Delete</a>\n"+
                    " </td>\n"+
                    "  </tr>\n";
                document.getElementById("show_tbody").innerHTML = document.getElementById("show_tbody").innerHTML + html;
            }
        }
    })
}

function editLibrarians(){
    var username=$('#username').val();
    var id=$('#id').val();
    var tele=$('#tele').val();
    var e_mail=$('#e_mail').val();
    $.ajax({
        type:"POST",
        url:"/editLibrarians?username="+username+"&id="+id+"&tele="+tele+"&e_mail="+e_mail,
        data:{},
        dataType:"String",
        async:false,
        success:function(msg) {
          alert(msg);
        }
    })


}

function editReaders(){
    var username=$('#username').val();
    var id=$('#id').val();
    var tele=$('#tele').val();
    var e_mail=$('#e_mail').val();
    $.ajax({
        type:"POST",
        url:"/editLibrarians?username="+username+"&id="+id+"&tele="+tele+"&e_mail="+e_mail,
        data:{},
        dataType:"String",
        async:false,
        success:function(msg) {
            alert(msg);
        }
    })


}

function  getid(id) {

    $.ajax({
        type:"POST",
        url:"/deleteLibrarians?id="+id,
        data:{},
        dataType:"String",
        async:false,
        success:function(msg) {
          alert(msg);
        }
    })
}

function  getRid(id) {

    $.ajax({
        type:"POST",
        url:"/deleteLibrarians?id="+id,
        data:{},
        dataType:"String",
        async:false,
        success:function(msg) {
            alert(msg);
        }
    })
}

//function registerR(tel, username, email){
//    var username=$('#username').val();
  //  var tele=$('#tele').val();
    //var e_mail=$('#e_mail').val();
//    $.ajax({
//        type:"POST",
//        url:"/registLibrarian?username="+username+"&tele="+tele+"&e_mail="+e_mail,
//        async:false,
  //       data:{},
//        dataType:"String",
//        success:function(msg) {
//            if(msg=="success!")  {
//                alert(msg);
//            }
//            else  alert("msg");
//        }
//    })
//}
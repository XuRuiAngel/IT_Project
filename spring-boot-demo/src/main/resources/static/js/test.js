
function getVerify(){

    document.getElementById("imgVerify").src = "/getVerify?"+Math.floor(Math.random()*100);

}
function check() {
    var msg1="fail";

    var result=document.getElementById("verify_input").value;
    $.ajax({
        type:"POST",
        url:"/check?result="+result,
        data:{},
        datatype:"String",
        async:false,
        success:function(data) {
            msg1=data;
        }
    })
    return msg1;
}

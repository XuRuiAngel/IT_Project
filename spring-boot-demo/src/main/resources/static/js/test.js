
function getVerify(){

    document.getElementById("imgVerify").src = "/getVerify?"+Math.floor(Math.random()*100);

}
function check() {
    var result=document.getElementById("verify_input").value;
    $.ajax({
        type:"POST",
        url:"/check?result="+result,
        data:{},
        datatype:"String",
        success:function(data) {
            alert(data);
        }
    })
}

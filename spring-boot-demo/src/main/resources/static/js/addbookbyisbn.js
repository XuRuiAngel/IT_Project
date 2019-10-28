function addBookByISBN1(){
    var num=blank($("#cpn").val());
    var isbn=$("#ISBN").val();
    var bn=blank($("#bname").val());
    var ba=blank($("#bauthor").val());
    var bp1=blank($("#bpress").val());
    var bp=blank($("#bprice").val());
    var bl=$("#floor option:selected").val()+$("#Shelf option:selected").val();
    var b=$("#bookCategory option:selected").val();
    var a=0;
    tosu();
    for(var i=0;i<num;i++){
        $.ajax({
            async : false,
            type : "GET",
            url : "/insertBookWithoutISBN?ISBN="+isbn+"&price="+bp+"&location="+bl+"&bookname="+bn+"&author="+ba+"&press="+bp1+"&description="+"/"+"&publishYear="+"/"+"&textLanguage="+b+"&copyNumbers="+a,
            data :{},
            success : function(data) {

            },
            error : function(data) {

            }
        });
    }




}
function blank(a)
{
    if(a==null){
        return "/";
    }
    else {
        return a;
    }
}


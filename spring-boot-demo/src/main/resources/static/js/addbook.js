function addBook1(){
    var num=blank($("#cpn").val());
    var bn=blank($("#bname").val());
    var ba=blank($("#bauthor").val());
    var bp1=blank($("#bpress").val());
    var bp=blank($("#bprice").val());
    var bl=$("#bookLocation option:selected").val();
    var b=$("#bookCategory option:selected").val();
    var c="/";
    var d="/";
    var a=0;
    tosu();
    for(var i=0;i<num;i++){
        $.ajax({
            async : false,
            type : "GET",
            url : "/insertBookWithoutISBN?ISBN="+"/"+"&price="+bp+"&location="+bl+"&bookname="+bn+"&author="+ba+"&press="+bp1+"&description="+c+"&publishYear="+d+"&textLanguage="+b+"&copyNumbers="+a,
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

function getbt1() {

    $.ajax({
        type:"GET",
        url:"/getBookCatagory",
        data:{},
        dataType:"JSON",
        async:false,
        success:function(data) {
            var unitObj=document.getElementById("bookCategory"); //页面上的<html:select>元素
            var a=JSON.stringify(data);
            var b=eval("("+a+")");
            var result=b.result;
            for(var i=0;i<result.length;i++){
                var btname=result[i].Typename;
                unitObj.options.add(new Option(btname,btname));
            }
        }
    })
    $.ajax({
        type:"GET",
        url:"/getBookLocation",
        data:{},
        dataType:"JSON",
        async:false,
        success:function(data) {
            var unitObj1=document.getElementById("bookLocation"); //页面上的<html:select>元素
            var a=JSON.stringify(data);
            var b=eval("("+a+")");
            var result=b.result;
            for(var i=0;i<result.length;i++){
                var btname1="floor"+result[i].FloorNo+"shelf"+result[i].ShelfNo;
                unitObj1.options.add(new Option(btname1,btname1));
            }
        }
    })
}
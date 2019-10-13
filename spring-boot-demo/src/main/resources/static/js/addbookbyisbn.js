function addBookByISBN1(){
    var num=$("#cpn").val();
    for(var i=0;i<num;i++){
        addBookByISBN();
    }
    alert("success");
}
function addBookByISBN() {
	var isbn=$('#ISBN').val();
    var bn=$("#bname").val();
    var ba=$("#bauthor").val();
    var bp1=$("#bpress").val();
    var bp=$("#bprice").val();
    var bl=$("#floor option:selected").val()+$("#Shelf option:selected").val();

    $.ajax({
        async : false,
        type : "GET",
        url : "/insertBookWithISBN?ISBN="+isbn+"&price="+bp+"&location="+bl+"&bookname="+bn+"&author="+ba+"&press="+bp1,
        data : {},
        success : function(data) {
            alert("success");

        },
        error : function(data) {
            alert("/insertBookWithISBN?ISBN="+isbn+"&price="+bp+"&location="+bl+"&bookname="+bn+"&author="+ba+"&press="+bp1);
        }
    });
};
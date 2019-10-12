
function addBook() {
    var bn=$("#bname").val();
    var ba=$("#bauthor").val();
    var bp1=$("#bpress").val();
    var bp=$("#bprice").val();
    var bl=$("#bloc").val();

    $.ajax({
        async : false,
        type : "GET",
        url : "/insertBookWithoutISBN?price="+bp+"&location="+bl+"&bookname="+bn+"&author="+ba+"&press="+bp1,
        data :{},
        success : function(data) {
            alert("success");
        },
        error : function(data) {
                alert("fail");
        }
    });


};
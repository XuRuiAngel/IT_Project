function addBooktype() {
    var btn=$("#btname").val();
    var bti=$("#btypeid").val();
    
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
function lendBook() {
   
      var readerId=$('#name').val();
      var bookId =$('#email').val();

    $.ajax({
        async : false,
        type : "POST",
        url : "/borrowBook?bookId="+bookId+"&id="+readerId,
        data :{},
        success : function(data) {
            alert(data);
        },
        error : function(data) {
                alert("fail");
        }
    });


};
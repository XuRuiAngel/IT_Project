function lendBook() {
   
      var readerId=$('#name').val();
      var book1Id =$('#book1').val();
      var book2Id =$('#book2').val();
      var book3Id =$('#book3').val();

    $.ajax({
        async : false,
        type : "POST",
        url : "/borrowBook?bookId="+book1Id+"&id="+readerId,
        data :{},
        success : function(data) {
            alert(data);
        },
        error : function(data) {
            if(book1Id=="") ;
            else alert("fail");
        }
    });
    $.ajax({
        async : false,
        type : "POST",
        url : "/borrowBook?bookId="+book2Id+"&id="+readerId,
        data :{},
        success : function(data) {
            alert(data);
        },
        error : function(data) {
            if(book2Id=="") ;
            else alert("fail");
        }
    });
    $.ajax({
        async : false,
        type : "POST",
        url : "/borrowBook?bookId="+book3Id+"&id="+readerId,
        data :{},
        success : function(data) {
            alert(data);
        },
        error : function(data) {
            if(book3Id=="") ;
            else alert("fail");
        }
    });

};

function lendBook2() {

    var readerId=$('#name').val();
    var bookId =$('#book2').val();

    $.ajax({
        async : true,
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

function lendBook3() {

    var readerId=$('#name').val();
    var bookId =$('#book3').val();

    $.ajax({
        async : true,
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
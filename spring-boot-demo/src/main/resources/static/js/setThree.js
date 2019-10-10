function loadFine() {
    $.ajax({
        type:"GET",
        url:"/getFine",
        data:{},
        datatype:"double",
        async:false,
        success:function(data) {

            document.getElementById("a").value=data;
        }
    })
}

function setFine() {
    var fine=$('#a').val();
    $.ajax({
        type:"POST",
        url:"/setFine?fine="+fine,
        data:{},
        datatype:"String",
        async:false,
        success:function(data) {
            alert("success!");
            loadFine();
        }
    })
}

function loadPeriod() {
    $.ajax({
        type:"GET",
        url:"/getPeriod",
        data:{},
        datatype:"double",
        async:false,
        success:function(data) {

            document.getElementById("b").value=data;
        }
    })
}

function setPeriod() {
    var period=$('#b').val();
    $.ajax({
        type:"POST",
        url:"/setPeriod?period="+period,
        data:{},
        datatype:"String",
        async:false,
        success:function(data) {
            alert("success!");
            loadPeriod();
        }
    })
}
function loadDeposit() {
    $.ajax({
        type:"GET",
        url:"/getDeposit",
        data:{},
        datatype:"double",
        async:false,
        success:function(data) {

            document.getElementById("c").value=data;
        }
    })
}

function setDeposit() {
    var deposit=$('#c').val();
    $.ajax({
        type:"POST",
        url:"/setDeposit?deposit="+deposit,
        data:{},
        datatype:"String",
        async:false,
        success:function(data) {
            alert("success!");
            loadDeposit();
        }
    })
}
var id;
function getCookie(cookieName) {
    //获取所有的cookie "psw=1234we; rememberme=true; user=Annie"
    var totalCookie = document.cookie;
    //获取参数所在的位置
    var cookieStartAt = totalCookie.indexOf(cookieName + "=");
    //判断参数是否存在 不存在直接返回
    if (cookieStartAt == -1) {
        return;
    }
    //获取参数值的开始位置
    var valueStartAt = totalCookie.indexOf("=", cookieStartAt) + 1;
    //以;来获取参数值的结束位置
    var valueEndAt = totalCookie.indexOf(";", cookieStartAt);
    //如果没有;则是最后一位
    if (valueEndAt == -1) {
        valueEndAt = totalCookie.length;
    }
    //截取参数值的字符串
    var cookieValue = unescape(totalCookie.substring(valueStartAt, valueEndAt));
    return cookieValue;
}


function searchInformation() {
	// var key=$('#id').val();
    //var ide=request.QueryString("idea");
    var tele=getCookie("rtele");
        $.ajax({
            async: false,
            type: "GET",
            url:"getReadByTele?tele="+tele,
            // data:{},
            dataType: "JSON",
            success: function (data) {
                // var result=JSON.stringify(data);
                var result=data;
                //var b=eval("("+a+")");

               //var result=a.result;

            //用一个变量来存储json中的数据
              //  for (i = 0; i < result.length; i++) { //用for循环遍历数组将数据存入html变量中

    id=result.id;
    var username=result.username;
    var balance=result.balance;
    var e_mail=result.e_mail;
    var tele=result.tele;
    var registerdate=result.regitherdate;
    document.getElementById("userid").value=id;
    document.getElementById("id").value=id;
	document.getElementById("username").value=username;
	document.getElementById("balance").value=balance;
	document.getElementById("e_mail").value=e_mail;
	document.getElementById("tele").value=tele;
	document.getElementById("registerdate").value=registerdate;
                }

		})
}
//alert
$(function () {

    $('#add_btn').click(function () {
        methods.addHandle()
    })

    $('#back_btn').click(function () {
        $('#Ktext').val(' ');
        methods.resectList();
    })

    $('#renyuan').on('hide.bs.modal',function() {
        addEnter = true;
        $('#show_tbody tr').removeClass('has_case');
        $('#xztb input').val(' ');
        $('#xztb select').find('option:first').prop('selected', true)
    });

})

var addEnter = true,
    noRepeat = true,
    // jobArr = [],
    // phoneArr = [],
    tdStr = '',
    trIndex,
    hasNullMes = false,
    tarInp = $('#xztb input'),
    tarSel = $('#xztb select');

var methods = {

    addHandle: function (the_index) {
        var Name=$('.userName').val();
        var Email=$('.jobNum').val();
        hasNullMes = false;
        methods.checkMustMes();
        if (hasNullMes) {
            return;
        }
        if (addEnter) {
            //methods.checkRepeat();
            if (noRepeat) {
                $.ajax({
                    type: "post",
                    url: "/editInformation?username="+Name+"&id="+id+"&e_mail="+Email,
                    //url:"index.json",
                    success: function(index) {            //成功后添加该行
                        // methods.setStr();
                        // $('#show_tbody').append('<tr>' + tdStr + '</tr>');
                        // $('#renyuan').modal('hide');
                        // window.open("RLLogin")
                        window.location.reload();
                    },
                    error: function() {
                    }
                });
                methods.setStr();
                $('#show_tbody').append('<tr>' + tdStr + '</tr>');
                $('#renyuan').modal('hide');
            }
        }else{
            methods.setStr();
            $('#show_tbody tr').eq(trIndex).empty().append(tdStr);
            $('#renyuan').modal('hide');
        }
    },

    setStr: function () {

        tdStr = '';
        for (var a=0; a<tarInp.length; a++) {
            tdStr+= '<td>' + tarInp.eq(a).val() + '</td>'
        }
        for (var b=0; b<tarSel.length; b++) {
            tdStr+= '<td>' + tarSel.eq(b).val() + '</td>'
        }
    },
    resectList: function () {
        $('#show_tbody tr').show();
    },
    checkMustMes: function () {

        if ($('.jobNum').val().trim()==='') {
            bootbox.alert({
                title: "Warning",
                message: "Email shouldn't be empty",
                closeButton:false
            })
            hasNullMes = true;
            return
        }

    },
}


 
   
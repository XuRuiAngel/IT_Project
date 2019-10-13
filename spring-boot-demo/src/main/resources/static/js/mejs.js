$(function () {

    $('#add_btn').click(function () {
        methods.addHandle()
    })

    $('#show_tbody').on('click','.edit', function () {
        trIndex = $('.edit', '#show_tbody').index($(this));
        addEnter = false;
        $(this).parents('tr').addClass('has_case');
        methods.editHandle(trIndex);
    })

    $('#search_btn').click(function () {
        methods.seachName();
    })

    $('#back_btn').click(function () {
        $('#Ktext').val(' ');
        methods.resectList();
    })

    $('.del').click(function () {
        $(this).parents('tr').remove();
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
    jobArr = [],
    phoneArr = [],
    tdStr = '',
    trIndex,
    hasNullMes = false,
    tarInp = $('#xztb input'),
    tarSel = $('#xztb select');

var methods = {

    addHandle: function (the_index) {
        hasNullMes = false;
        methods.checkMustMes();
        if (hasNullMes) {
            return;
        }
        if (addEnter) {
            methods.checkRepeat();
            if (noRepeat) {
            var username=$('#username').val();
                var tele=$('#tele').val();
                var e_mail=$('#e_mail').val();
                $.ajax({
                    type:"POST",
                    url:"/registLibrarian?username="+username+"&tele="+tele+"&e_mail="+e_mail,
                    async:false,
                     data:{},
                    dataType:"JSON",
                    success:function(msg) {
                        if(msg=="success!")  {
                            alert(msg);
                        }
                        else  alert("msg");
                    }
                })
                methods.setStr();
                $('#show_tbody').append('<tr>' + tdStr + '</tr>');
                $('#renyuan').modal('hide');
                window.location.reload();
            }
        }else{
            methods.setStr();
//            $('#show_tbody tr').eq(trIndex).empty().append(tdStr);
//            $('#renyuan').modal('hide');
//                window.location.reload();
        }
    },
    editHandle: function (the_index) {

        var tar = $('#show_tbody tr').eq(the_index);
        var nowConArr = [];
        for (var i=0; i<tar.find('td').length-1;i++) {
            var a = tar.children('td').eq(i).html();
            nowConArr.push(a);
        }

        $('#renyuan').modal('show');

        for (var j=0;j<tarInp.length;j++) {
            tarInp.eq(j).val(nowConArr[j])
        }
        for (var p=0;p<tarSel.length;p++) {
            var the_p = p+tarInp.length;
            tarSel.eq(p).val(nowConArr[the_p]);
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
        tdStr+= '<td><a href="#" class="edit">Edit</a> <a href="#" class="del">Delete</a></td>';

    },
    seachName: function () {

        var a = $('#show_tbody tr');
        var nameVal = $('#Ktext').val().trim();
        var nameStr = '',
            nameArr = [];

        if (nameVal==='') {
            bootbox.alert({
                title: "Hints",
                message: "The search cannot be empty!",
                closeButton:false
            })
            return;
        }

        for (var c=0;c<a.length;c++) {
            var txt = $('td:first', a.eq(c)).html().trim();
            nameArr.push(txt);
        }

        a.hide();
        for (var i=0;i<nameArr.length;i++) {
            if (nameArr[i].indexOf(nameVal)>-1) {
                a.eq(i).show();
            }
        }
    },
    resectList: function () {
        $('#show_tbody tr').show();
    },
    checkMustMes: function () {

        if ($('.userName').val().trim()==='') {
            bootbox.alert({
                title: "Hints",
                message: "Librarian name is required, please fill in!",
                closeButton:false
            })
            hasNullMes = true;
            return
        }

        if ($('.phoneNum').val().trim()==='') {
            bootbox.alert({
                title: "Hints",
                message: "The mobile phone number is required, please fill in!",
                closeButton:false
            })
            hasNullMes = true;
            return
        }


    },
    checkRepeat: function () {

        jobArr = [], phoneArr = [];

        for (var i = 0; i<$('#show_tbody tr:not(".has_case")').length;i++) {
            var par = '#show_tbody tr:not(".has_case"):eq(' + i + ')';
            var a = $('td:eq(1)', par).html().trim(),
                b = $('td:eq(2)', par).html().trim();
            jobArr.push(a);
            phoneArr.push(b);
        }
        var jobNum = $('.jobNum').val().trim(),
            phoneNum = $('.phoneNum').val().trim();


        if (phoneArr.indexOf(phoneNum)>-1) {
            noRepeat = false;
            bootbox.alert({
                title: "Hints",
                message: "The phone number has been repeated. Please enter it again!",
                closeButton:false
            })
            return;
        }
        noRepeat = true;
    }
}
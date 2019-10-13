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

    $('#show_tbody').on('click','.del', function () {
        trIndex = $('.del', '#show_tbody').index($(this));
        addEnter = false;
        var newsId = $(this).parents('tr').children("td:eq(0)").text();
        var $tr = $(this).parents('tr');
        $.ajax({
            type: "post",
            url: "/deleteNews?newsId="+newsId,
            //url:"index.json",
            data:{},
            contentType : "application/x-www-form-urlencoded; charset=utf-8",
            dataType: "JSON",
            success: function(data) {            //閹存劕濮涢崥搴ｆ纯閹恒儳些闂勩倕缍嬮崜宥堫攽
                //$tr.remove();
            },
            error: function() {
            }
        });
        $tr.remove();
        // $(this).parents('tr').remove();
        methods.delHandleNews(trIndex);
    })

    $('#search_btn').click(function () {
        methods.seachName();
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
    jobArr = [],
    phoneArr = [],
    tdStr = '',
    trIndex,
    hasNullMes = false,
    tarInp = $('#xztb input'),
    tarSel = $('#xztb select');

var methods = {

    addHandle: function (the_index) {
        var newsId=$('.userName').val();
        var newsTitle=$('.jobNum').val();
        var newsContent=$('.phoneNum').val();
        hasNullMes = false;
        methods.checkMustMes();
        if (hasNullMes) {
            return;
        }
        if (addEnter) {
            //methods.checkRepeat();
            if (noRepeat) {
                $.ajax({
                    type: "get",
                    url: "/addNews?title="+newsTitle+"&content="+newsContent,
                    //url:"index.json",
                    // data:{},
                    // contentType : "application/x-www-form-urlencoded; charset=utf-8",
                    // dataType: "JSON",
                    success: function(index) {            //閹存劕濮涢崥搴㈠潑閸旂姾顕氱悰?
                        // methods.setStr();
                        // $('#show_tbody').append('<tr>' + tdStr + '</tr>');
                        // $('#renyuan').modal('hide');
                         window.location.reload();
                    },
                    error: function() {
                    }
                });
                // methods.setStr();
                // $('#show_tbody').append('<tr>' + tdStr + '</tr>');
                // $('#renyuan').modal('hide');
                // window.location.reload();
            }
        }else{
            methods.setStr();
            $('#show_tbody tr').eq(trIndex).empty().append(tdStr);
            $('#renyuan').modal('hide');
        }
    },

    delHandleNews: function(){
    },

    editHandle: function (the_index) {
        // var newsId=$('.userName').val();
        // var newsTitle=$('.jobNum').val();
        // var newsContent=$('.phoneNum').val();
        var tar = $('#show_tbody tr').eq(the_index);
        var nowConArr = [];
        // $.ajax({
        //     type: "POST",
        //     url: "/editNews?newsId="+newsId+"&title="+newsTitle+"&content="+newsContent,
        //     //url:"index.json",
        //     // data:{},
        //     // contentType : "application/x-www-form-urlencoded; charset=utf-8",
        //     // dataType: "JSON",
        //     success: function(index) {            //閹存劕濮涢崥搴㈠潑閸旂姾顕氱悰?
        //         // methods.setStr();
        //         // $('#show_tbody').append('<tr>' + tdStr + '</tr>');
        //         // $('#renyuan').modal('hide');
        //     },
        //     error: function() {
        //     }
        // });
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
        var newsId=$('.userName').val();
        var newsTitle=$('.jobNum').val();
        var newsContent=$('.phoneNum').val();
        tdStr = '';
        $.ajax({
            type: "POST",
            url: "/editNews?newsId="+newsId+"&title="+newsTitle+"&content="+newsContent,
            //url:"index.json",
            // data:{},
            // contentType : "application/x-www-form-urlencoded; charset=utf-8",
            // dataType: "JSON",
            success: function(index) {            //閹存劕濮涢崥搴㈠潑閸旂姾顕氱悰?
                // methods.setStr();
                // $('#show_tbody').append('<tr>' + tdStr + '</tr>');
                // $('#renyuan').modal('hide');
            },
            error: function() {
            }
        });
        for (var a=0; a<tarInp.length; a++) {
            tdStr+= '<td>' + tarInp.eq(a).val() + '</td>'
        }
        for (var b=0; b<tarSel.length; b++) {
            tdStr+= '<td>' + tarSel.eq(b).val() + '</td>'
        }
        tdStr+= '<td><a href="#" class="edit">edit</a> <a href="#" class="del">delete</a></td>';

    },
    seachName: function () {
        var a = $('#show_tbody tr');
        var nameVal = $('#Ktext').val().trim();
        var nameStr = '',
            nameArr = [];

        if (nameVal==='') {
            bootbox.alert({
                title: "Warning",
                message: "It shouldn't be empty",
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

        if ($('.jobNum').val().trim()==='') {
            bootbox.alert({
                title: "Warning",
                message: "NewsId shouldn't be empty",
                closeButton:false
            })
            hasNullMes = true;
            return
        }
        if ($('.phoneNum').val().trim()==='') {
            bootbox.alert({
                title: "Warning",
                message: "Title shouldn't be empty",
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

        if (jobArr.indexOf(jobNum)>-1) {
            noRepeat = false;
            bootbox.alert({
                title: "Warning",
                message: "NewsId is used",
                closeButton:false
            })
            return;
        }
        noRepeat = true;
    }
}
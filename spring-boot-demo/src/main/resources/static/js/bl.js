$(function () {

    $('#add_btn').click(function () {
        methods.addHandle()
    })



    $('#renyuan').on('hide.bs.modal',function() {
        addEnter = true;
        $('#show_tbody tr').removeClass('has_case');
        $('#xztb input').val(' ');
    });

})

var addEnter = true,
    noRepeat = true,
    jobArr = [],
    phoneArr = [],
    tdStr = '',
    trIndex,
    hasNullMes = false,
    tarInp = $('#xztb input')

var methods = {

    addHandle: function (the_index) {
        var FloorNo=parseInt($('#FloorNo').val());
		var ShelvNo=parseInt($('#ShelfNo').val());
        hasNullMes = false;
        methods.checkMustMes();
        if (hasNullMes) {
            return;
        }
        if (addEnter) {
            //methods.checkRepeat();
            if (noRepeat) {
            $.ajax({
                    type:"POST",
                    url:"/addBookLocation?FloorNo="+FloorNo+"&ShelfNo="+ShelvNo,
                    async:false,
                     data:{},
                    dataType:"JSON",
                    success:function(msg) {
                                if(msg=="success!")  {
                                    alert(msg);
                                }
                                else  alert("msg");
                                window.location.reload();
                            }
                })
                window.location.reload();
            }
        }else{
            methods.setStr();
            $('#show_tbody tr').eq(trIndex).empty().append(tdStr);
            $('#renyuan').modal('hide');
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

      },
      setStr: function () {

          tdStr = '';
          for (var a=0; a<tarInp.length; a++) {
              tdStr+= '<td>' + tarInp.eq(a).val() + '</td>'
          }
          tdStr+= '<td><a href="#" class="edit">Edit</a></td>';

      },

      checkMustMes: function () {

          if ($('.userName').val().trim()==='') {
              bootbox.alert({
                  title: "Hints",
                  message: "input is required, please fill in!",
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
          var phoneNum = $('.phoneNum').val().trim();
          noRepeat = true;
      }
  }
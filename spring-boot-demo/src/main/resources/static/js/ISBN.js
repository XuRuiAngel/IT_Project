$().ready(function(){
	$('#ISBN').focus();

	$('#ISBN').blur(function(){
	    var isbn=$('#ISBN').get(0).value;

    var url='https://api.jisuapi.com/isbn/query?appkey=35f0a6d2d4ac6f5d&isbn='+isbn;
  jQuery(document).ready(function(){
    $.ajax({
      type : "GET", //jquey是不支持post方式跨域的
      url : url, //跨域请求的URL
      dataType : "JSONP", //传递给请求处理程序，用以获得jsonp回调函数名的参数名(默认为:callback)
      success :  function(data){
        // var jsonData = JSON.parse(data);
        console.log("图书数据成功返回");
        console.log(data);
		        // return data
		document.getElementById('bname').value=data.result.title;
		document.getElementById('bauthor').value=data.result.author;
		document.getElementById('bpress').value=data.result.publisher;
		document.getElementById('bprice').value=data.result.price;

      } ,
      error:function (e) {
        
      }
    });
  });

})
})


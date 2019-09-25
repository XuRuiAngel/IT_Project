// JavaScript Document
//支持Enter键登录
		document.onkeydown = function(e){
			if($(".bac").length==0)
			{
				if(!e) e = window.event;
				if((e.keyCode || e.which) == 13){
					var obtnLogin=document.getElementById("submit_btn")
					obtnLogin.focus();
				}
			}
		}
		$(function(){
			//提交表单
			$('#submit_btn').click(function(){
				show_loading();
				var myReg = /^0?1[3|4|5|8][0-9]\d{8}$/; //电话号码正则
				var mypass=/^[\w\W]{6,16}$/;
				if($('#ID').val() == ''){
					show_err_msg('ID cannot be empty!');
					$('#ID').focus();
				}else if(!myReg.test($('#ID').val())){
					show_err_msg('Incorrect ID format!');
					$('#ID').focus();
				}else if($('#password').val() == ''){
					show_err_msg('Password cannot be empty!');
					$('#password').focus();
				}else if(!mypass.test($('#password').val())){
					show_err_msg('Incorrect ID format!');
				    $('#password').focus();
				}else{
					show_msg('Login successful','/');
				}
			});
		});
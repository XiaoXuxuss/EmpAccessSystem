<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="easyui/1.3.4/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyui/1.3.4/locale/easyui-lang-zh_CN.js"></script>
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" type="text/css" href="easyui/1.3.4/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="css/wu.css" />
<link rel="stylesheet" type="text/css" href="css/icon.css" />
</head>
<body>

	<h1>klasikal Login Form</h1>
	<div class="login-form">
	<div class="close"> </div>
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
		</div>
	<div class="clear"> </div>
	<div class="avtar">
		<img src="images/login/avtar.png" />
	</div>
	
	<form id="test" method="post">
		<input name="username" type="text" id="username"> <br>
		<input name="password" type="password" id="password"><br>
		
	</form>
	
	<div class="signin">
		<input type="button" value="Login" onclick="login()">
	</div>
	</div>
 	<div class="copy-rights">
		<p>Copyright &copy; 2015.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
	</div>
	
</body>

<script type="text/javascript">
	
	function login(){
		$.post("test.action",{
			username:$("#username").val(),
			password:$("#password").val()
		},function(data){
			if (data.status == 1) {
				/* $.messager.alert('信息提示', data.responseText, 'info'); */
				location.href="index.jsp";
			} else {
				$.messager.alert('信息提示', data.responseText, 'info');
			}
		},"json");
	}
	
</script>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script language="JavaScript" src="../js/jquery.js"></script>
<script >
	function on_submit(){
		if (form.username.value == ""){
			alert("用户名不能为空，请输入用户名！");
			form.username.focus();
			return false;
		}
		if (form.password.value == ""){
			alert("用户密码不能为空，请输入密码！");
			form.password.focus();
			return false;
		}
		if (form.againstpassword.value == ""){
			alert("用户确认密码不能为空，请输入密码！");
			form.againstpassword.focus();
			return false;
		}
		if (form.password.value != form.againstpassword.value){
			alert("密码与确认密码不同");
			form.password.focus();
			return false;
		}
	}
</script>

<html>
<head>
<title>注册界面</title>
</head>
<body>
	<center>
        <p style="color:red"><font size=5>注册界面</font> </p>
        <form name="form" method="post" action="RegisterServlet" onSubmit="return on_submit()">
			<table border="0">
				<tr>
                    <td>用户名：</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>密码：</td>
                	<td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td>确认密码：</td>
                    <td><input type="password" name="againstpassword">
                    </td>
                </tr>
                <tr>
                	<td>性别</td>
                	<td>
                	<input type="radio" name="sex" value="male" checked>男
                	<input type="radio" name="sex" value="female" checked>女
                	<input type="radio" name="sex" value="secrecy" checked>保密
                	</td>
                </tr>
            </table>
            <br>
                <input type="submit" value="确认注册" >
		</form>
		<br>
		<a href="login.jsp">返回登录界面</a>
    </center>
</body>
</html>
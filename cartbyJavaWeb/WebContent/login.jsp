<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript" src="../js/jquery.js"></script>
<title>登录窗口</title>
</head>
<body>
	<center>
        <p style="color:red"><font size=5>登录</font> </p>
            <form id="indexform" name="indexForm" action="LoginServlet" method="post">
                <table border="0">
                    <tr>
                        <td>用户名：</td>
                        <td><input type="text" name="username"></td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td><input type="password" name="password">
                        </td>
                    </tr>
                </table>
                <input type="submit" value="登录" >
            	<a href="register.jsp">注册</a>
            	<br>
            	<a href="main.jsp">返回主界面</a>
            </form>
    </center>
</body>
</html>
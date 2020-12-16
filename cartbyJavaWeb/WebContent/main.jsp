<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<!--导航栏-->
<div class="container-fluid">
    <nav class="navbar navbar-expand-sm bg-light navbar-light">
        <a class="navbar-brand" href="main.jsp"><img src="images/main_logo.png" title="商城首页" /></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="#" ><font size=5>商城 </font> <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="shoppingCar.jsp"><font size=5>购物车 </font></a>
                </li>
            </ul>
        </div>
    </nav>
</div>
<!--侧边栏-->
<div class="row pt-3">
	<div class="col-lg-2 pt-3">
		<div class="card" style="width:100%">       
			<ul class=" nav nav-pills list-group list-group-flush">
				<ul class="nav flex-column nav-pills" id="v-pills-tab" role="tablist">
					<li class=" list-group-item nav-item"><a class="nav-link"  href="food.jsp">美食</a></li>
			 		<li class=" list-group-item nav-item"><a class="nav-link"  href="cloth.jsp">服装</a></li>
					<li class=" list-group-item nav-item"><a class="nav-link"  href="equipment.jsp">电子设备</a></li>
				</ul>
			</ul>
		</div>
	</div>
	<!-- 商城首页 -->
	<div id="v-pills-main" class="container  tab-pane active">
		<p><font size=10>欢迎使用此商城</font></p>
		<% if(session.getAttribute("user") == null)	{
			out.print("<p><a href='login.jsp'>点击此处登录</a></p>");
			
		}%>
		  在线人数为:${applicationScope.count}
	</div>
</div>
</body>
<div> <%@ include file="footer.jsp"%> </div>
</html>
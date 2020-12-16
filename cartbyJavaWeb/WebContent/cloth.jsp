<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服装</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
$(document).ready(function () {
	 $("button").click(
		 function () {
           var commodityID = $(this).val();
           var dotemp = "add";
           $.ajax({
                url: "ShopCartServlet",
                type: "post",
                data: {"dotemp":dotemp,"commodityID": commodityID},
                success: function () {
                    alert("添加到购物车成功");
               },
               complete : function(xhr, status) {
                   //拦截器拦截没有权限跳转
                   // 通过xhr取得响应头
                   var REDIRECT = xhr.getResponseHeader("REDIRECT");
                   //如果响应头中包含 REDIRECT 则说明是拦截器返回的
                   if (REDIRECT == "REDIRECT")
                   {	
                   	alert("登录后才可以进行访问");
                       document.location.href = xhr.getResponseHeader("CONTENTPATH");
                   }
               }
           }); 
          }
      );
  });
</script>

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

<div class="row pt-3">
	<!--侧边栏-->
		<div class="col-lg-2 pt-3">
			<div class="card" style="width:100%">       
				<ul class=" nav nav-pills list-group list-group-flush">
					<ul class="nav flex-column nav-pills" id="v-pills-tab" role="tablist">
						<li class=" list-group-item nav-item"><a class="nav-link"  href="food.jsp">美食</a></li>
				 		<li class=" list-group-item nav-item"><a class="nav-link active"  href="cloth.jsp">服装</a></li>
						<li class=" list-group-item nav-item"><a class="nav-link"  href="equipment.jsp">电子设备</a></li>
					</ul>
				</ul>
			</div>
		</div>
	<!-- 服装-->
	<div id="v-pills-cloth" class="container  tab-pane active">
		<div class="col-lg-10">
			<div class="row">
				<div class="card col-lg-4" style="height:350px;">
					<img src="images/cloth01.jpg" class="card-img-top" width="75%" height="250px">
						<div class="card-body">
							<h5 class="card-title">上衣</h5>
						</div>
						<button type="button" value="cloth01" class=" btn btn-primary">加入购物车</button>
				</div>
				<div class="card col-lg-4" style="height:350px;">
					<img src="images/cloth02.jpg" class="card-img-top" width="75%" height="250px">
						<div class="card-body">
							<h5 class="card-title">下衣</h5>
						</div>
						<button type="button" value="cloth02" class=" btn btn-primary">加入购物车</button>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<div> <%@ include file="footer.jsp"%> </div>
</html>
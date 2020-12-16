<%@ page contentType="text/html;charset=UTF-8" language="java" 
import="com.xyz.util.ShoppingCartUtil" import="com.xyz.bean.ShopItems"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="css/bootstrap.min.css">
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
                <li class="nav-item ">
                    <a class="nav-link" href="food.jsp" ><font size=5>商城 </font></a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#"><font size=5>购物车 <span class="sr-only">(current)</span> </font></a>
                </li>
            </ul>
        </div>
    </nav>
</div>
<!--展示区-->
<table id="table" class="table table-hover">
    <thead>
    <tr>
        <th scope="col">商品名称</th>
        <th scope="col">商品ID</th>
        <th scope="col">购买数量</th>
        <th scope="col">商品单价</th>
        <th scope="col">所需价格</th>
        <th scope="col">操作</th>
    </tr>
    </thead>
    <tbody>  
 <%
 	double count=0;
	if(session.getAttribute("ShoppingCartUtil") == null){
		out.print("<font>购物车为空，快去添加商品吧</font>");
		}
	else{
		ShoppingCartUtil util=(ShoppingCartUtil) session.getAttribute("ShoppingCartUtil");
		Iterator<ShopItems> it=util.getShopItemsIt();
		 while(it.hasNext()){
	   	  	ShopItems s= it.next();
	   	  	String commodityName=s.getCommodity().getCommodityName();
	   	  	String commodityID=s.getCommodity().getCommodityID();
	   	 	double commodityPrice=s.getCommodity().getCommodityPrice();
	   	 	int commodityNum=s.getCommodityNum();
	   	 	double commodityCost=s.getCommodityCost();
	   	 	count=count+commodityCost;
			out.print("<tr>");
			out.print("<td>"+commodityName+"</td>");
			out.print("<td>"+commodityID+"</td>");
			out.print("<td>"); %>
			<button value="addition" class="btn btn-success">+</button>
	        <font  > <% out.print(commodityNum); %></font>
	        <button value="subtraction" class="btn btn-warning">-</button>
	        </td>
	        <%  
	            out.print("<td>"+commodityPrice+"</td>");
				out.print("<td>"+commodityCost+"</td>");
			%>
	        <td><button value="delete" class="btn btn-danger">删除</button></td>
	        </tr>
			<% } }%> 
    </tbody>
</table>
<div> 
 			<% if(session.getAttribute("ShoppingCartUtil") != null){ %>
 			<font size=5><%out.print("总计："+count+"元"); %></font>
 			<p></p>
     		<button value=clear class="btn btn-danger">清空购物车</button>
     		
     			<% } %>
</div>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
<script>
    $(document).ready(
        function () {
            $("button").click(
                function () {
                	var commodityID;
                	var commodityName;
                	var dotemp;
                    const that = this;
                    if($(this).val()==="addition")
                    {
                    	commodityID=$(this).parent().prev().text();
                    	dotemp = "add";
                    	 $.ajax({
                             url: "ShopCartServlet",
                             type: "post",
                             data: {"dotemp":dotemp,"commodityID": commodityID},
                             success: function () {
                            	 window.location.reload();
                            }
                        }); 
                    }
                    if($(this).val()==="subtraction")
                    {
                    	commodityID=$(this).parent().prev().text();
                    	commodityNum=parseInt($(this).prev().text());
                    	if(commodityNum-1<0){
                    		alert("购买数量不能小于0哦 ");
                    	}else {
                    		dotemp = "subtract";
	                    	 $.ajax({
	                             url: "ShopCartServlet",
	                             type: "post",
	                             data: {"dotemp":dotemp,"commodityID": commodityID},
	                             success: function () {
	                            	 window.location.reload();
	                            }
	                        }); 
	                    }
                    }
                    if($(this).val()==="delete")
                    {
                    	if(confirm("您确定要删除这件商品吗")){
                    		commodityID=$(this).parent().prev().prev().prev().prev().text();
                        	dotemp = "delete";
                        	$.ajax({
                                 url: "ShopCartServlet",
                                 type: "post",
                                 data: {"dotemp":dotemp,"commodityID": commodityID},
                                 success: function () {
                                	 window.location.reload();
                                	 alert("删除成功");
                                }
                            });
                    	}
                    }
                    if($(this).val()==="clear")
                    {
                    	if(confirm("您确定要清空购物车吗")){
                    		dotemp = "clear";
	                       	 $.ajax({
	                                url: "ShopCartServlet",
	                                type: "post",
	                                data: {"dotemp":dotemp},
	                                success: function () {
		                                window.location.reload();
		                               	alert("购物车已清空");
	                               }
	                           }); 
                    	}
                    }
                }
            );
        }
    );
</script>
</body>
<div>
<%@ include file="footer.jsp"%>
</div>
</html>
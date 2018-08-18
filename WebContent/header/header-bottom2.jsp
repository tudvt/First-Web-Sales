<%@page import="java.util.Map"%>
<%@page import="model.DanhMuc"%>
<%@page import="model.Cart"%>
<%@page import="model.Item"%>
<%@page import="dao.DanhMucDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		DanhMucDAO danhMucDAO = new DanhMucDAO();
	 Cart cart = (Cart) session.getAttribute("cart");
     if (cart == null) {
         cart = new Cart();
         session.setAttribute("cart", cart);
     }

 
	%>
	<div class="header-bottom">
		<div class="top-nav">
			<ul class="megamenu skyblue">
				<li class="active grid"><a href="index.jsp">Products</a>
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<ul>
										<%
											for (Map.Entry<String,DanhMuc> key : danhMucDAO.loadData().entrySet())  {
										%>

										<li><a href="store.jsp?danhmuc=<%= key.getValue().getMaDanhMuc()%>"><%= key.getValue().getTenDanhMuc()%></a></li>
					
								<%
											}
										%>
									</ul>
						</div>
					</div></li>
				<li><a class="pink" href="404.jsp">ideas</a></li>
				<li class="grid"><a href="#">Brands</a>
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li><a href="store.jsp">Long Sleeve T-Shirts</a></li>
										<li><a href="store.jsp">Loungewear</a></li>
									</ul>
								</div>
							</div>
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li><a href="store.jsp">Underwear & Socks</a></li>
										<li><a href="store.jsp">Vests</a></li>
									</ul>
								</div>
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>Popular Brands</h4>
									<ul>
										<li><a href="store.jsp">Ray-Ban</a></li>
										<li><a href="store.jsp">Wood Wood</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div></li>

				<li><a class="pink" href="gifts.jsp">gifts</a></li>
				<li class="grid"><a href="#">stores</a>
					<div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li><a href="store.jsp">Loungewear</a></li>
									</ul>
								</div>
							</div>
							<div class="col1">
								<div class="h_nav">
									<ul>
										<li><a href="store.jsp">Underwear & Socks</a></li>
										<li><a href="store.jsp">Vests</a></li>
									</ul>
								</div>
							</div>
							<div class="col1">
								<div class="h_nav">
									<h4>Popular Brands</h4>
									<ul>
										<li><a href="store.jsp">Wood Wood</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div></li>

			</ul>
		</div>
		<div class="cart icon1 sub-icon1">
			<h6>
					 <%for (Map.Entry<String, Item> list : cart.getCartItems().entrySet()) {%>
				Shopping Cart: <span class="item"> <%=cart.countItem()%> items</span> <span class="rate"><%=cart.total() %></span>
				<li><a href="#" class="round"> </a>
					<ul class="sub-icon1 list">
						<h3>Recently added items(<%=cart.countItem()%>)</h3>
						<div class="shopping_cart">
				
							<div class="cart_box">
								<div class="message">
									<div class="alert-close"></div>
									<div class="list_img">
										<img src="<%=list.getValue().getProduct().getHinhAnh() %>" class="img-responsive" alt="">
									</div>
									<div class="list_desc">
										<h4>
											<a href="CartServlet?command=remove&productID=<%=list.getValue().getProduct().getMaSanPham()%>">
											<%=list.getValue().getProduct().getTen()%></a>
										</h4>
	<%} %>
										<a href="#" class="offer">1 offer applied</a>
									</div>
									<div class="clearfix"></div>
								</div>
								
							</div>
						
							
						</div>
						<div class="check_button">
							<a href="cart.jsp">View Cart</a>
						</div>
						<div class="clearfix"></div>
					
					</ul></li>
			</h6>

		</div>
		<div class="clearfix"></div>
	</div>
</body>
</html>
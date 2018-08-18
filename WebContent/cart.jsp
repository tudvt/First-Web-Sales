<%@page import="java.util.Map"%>
<%@page import="model.DanhMuc"%>
<%@page import="model.Cart"%>
<%@page import="model.Item"%>
<%@page import="dao.DanhMucDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Mihstore A Ecommerce Category Flat Bootstarp Resposive Website Template | Cart :: w3layouts</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Mihstore Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='http://fonts.googleapis.com/css?family=Cabin:400,500,600,700' rel='stylesheet' type='text/css'>
<!--//fonts-->
<!--//slider-script-->
<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>
<script>$(document).ready(function(c) {
	$('.alert-close1').on('click', function(c){
		$('.message1').fadeOut('slow', function(c){
	  		$('.message1').remove();
		});
	});	  
});
</script>
<script>$(document).ready(function(c) {
	$('.alert-close2').on('click', function(c){
		$('.message2').fadeOut('slow', function(c){
	  		$('.message2').remove();
		});
	});	  
});
</script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>
				<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>		

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
<!--header-->
	<div class="container">
		<!-- header-top -->
		<jsp:include page="header/header-top.jsp"></jsp:include>
		<!-- header-top -->
		<!-- header-bottom -->
		<jsp:include page="header/header-bottom.jsp"></jsp:include>
		<!-- header-bottom -->
		<div class="page">
			<h6><a href="#">Page Title</a><b>|</b>Page description The quick, brown <span class="for">fox jumps over a lazy dog. DJs flock by when TV ax quiz prog.</span></h6>
		</div>
		<div class="content">
		<div class="check-out">
    	    <h4 class="title">Here is shopping cart</h4>
    	    
    	    							 <%for (Map.Entry<String, Item> list : cart.getCartItems().entrySet()) {%>
    	    		
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
    	    <p class="cart-out">You have <%=cart.countItem()%> items in your shopping cart.<br>Click<a href="index.jsp"> here</a> to continue shopping</p>
    	</div>

		</div>
		<!---->
		<footer>
			<jsp:include page="footer/footerlevel1.jsp"></jsp:include>
		</footer> 
	</div>

	<!---->
</body>
</html>
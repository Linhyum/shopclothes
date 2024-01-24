<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Detail</title>
<link rel="stylesheet" href="./Css/detail.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
</head>
<body>

	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="index"> <img width="100"
				height="40" alt="" src="img/logo.png">
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index">Trang chủ</a></li>


				</ul>

				<c:if test="${session != null}">
					<p style="margin-left: 10px; margin-bottom: 0">
						${session.username}</p>
					<button class="btn btn-primary"
						style="margin-left: 10px; margin-right: 10px"">
						<a style="text-decoration: none; color: white" href="logout">Đăng
							xuất</a>
					</button>
				</c:if>

				<c:if test="${session == null}">
					<button class="btn btn-primary"
						style="margin-left: 10px; margin-right: 10px">
						<a style="text-decoration: none; color: white"
							href="/ShopClothes/login.jsp">Đăng nhập</a>
					</button>
				</c:if>
				<div style="position: relative;">
					<a href="cart.jsp"><img src="./img/cart.png"
						style="width: 30px; height: 30px" /> <c:set var="count"
							value="${0}" /> <c:forEach items="${cart.items}" var="item">
							<c:set var="count" value="${count + 1}" />
						</c:forEach> <span
						style="position: absolute; top: -9px; right: -8px; z-index: 10; background: red; color: white; border-radius: 50%; width: 20px; height: 20px; display: flex; align-items: center; justify-content: center;">${count }</span></a>
				</div>
			</div>
		</div>
	</nav>
	<!-- End Navbar -->
	<div class="container">
		<div class="product-details">
			<div class="product-image">
				<!-- Hiển thị ảnh sản phẩm -->
				<img src=${product.imagepro } alt="Product Image">
			</div>
			<div class="product-info">
				<!-- Hiển thị thông tin chi tiết sản phẩm -->
				<h2>${product.namepro}</h2>
				<h5>${product.description}</h5>
				<h5>${product.title}</h5>
				<p class="card-text" style="color: red">
					Giá:
					<fmt:formatNumber type="number" value="${product.pricepro}"
						pattern="###,###đ" />
				</p>

				<p>Số lượng : ${product.quantity}</p>


				<!-- Form để thêm sản phẩm vào giỏ hàng -->

				<!-- Nút Mua Hàng -->

				<form action="cart" method="post">
					<input type="hidden" name="productCode"
						value="<c:out value='${product.id}'/>"> <input
						class="product__cart-add btn btn-primary" type="submit"
						value="Thêm vào giỏ hàng">
				</form>

			</div>
		</div>
		<div class="fb-comments" data-href="detail.jsp?getidpro=${product.id}"
			data-width="1100" data-numposts="5"></div>
	</div>
	<!-- Footer -->
	<footer class="py-3 my-4">
		<ul class="nav justify-content-center border-bottom pb-3 mb-3">
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">Trag chủ</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">Quy định giao hàng</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">Quy định trả hàng</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">Liên hệ</a></li>
			<li class="nav-item"><a href="#"
				class="nav-link px-2 text-muted">Blogs</a></li>
		</ul>
		<p class="text-center text-muted">© 2003 Nguyễn Đăng Tài, Inc</p>
	</footer>
	<!-- End footer -->
	<div id="fb-root"></div>
	<script async defer crossorigin="anonymous"
		src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v19.0&appId=382086551239656"
		nonce="3zk1JdCd"></script>
</body>
</html>
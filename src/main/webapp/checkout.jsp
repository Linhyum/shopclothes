<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Checkout Form</title>
<link rel="stylesheet" href="./Css/checkout.css">
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
					<div style="display: flex; align-items: center; gap: 10px">
						<p style="margin-left: 10px; margin-bottom: 0">
							${session.username}</p>
						<button class="btn btn-primary"
							style="margin-left: 10px; margin-right: 10px"">
							<a style="text-decoration: none; color: white" href="logout">Đăng
								xuất</a>
						</button>
					</div>
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

	<div class="container mt-5">

		<h2 class="mb-4">Thông Tin Thanh Toán</h2>

		<form action="checkout" method="post">
			<c:forEach var="item" items="${cart.items}">
				<input type="hidden" name="idproduct" value="${item.product.id}">
				<c:set var="sumprice" value="${sumprice + item.total}" />
				<c:set var="sumquantity" value="${sumquantity + item.quantity}" />
			</c:forEach>
			<input type="hidden" name="sumprice" value="${sumprice}"> <input
				type="hidden" name="sumquantity" value="${sumquantity}">

			<div class="form-group">
				<label for="ten">Tên:</label> <input required="required" type="text"
					class="form-control" name="name" id="ten"
					placeholder="Nhập tên của bạn">
			</div>
			<div class="form-group">
				<label for="diaChi">Địa Chỉ:</label> <input required="required"
					type="text" class="form-control" name="address" id="diaChi"
					placeholder="Nhập địa chỉ của bạn">
			</div>

			<div class="form-group">
				<label for="soDienThoai">Số Điện Thoại:</label> <input
					required="required" type="tel" class="form-control" name="phone"
					id="soDienThoai" placeholder="Nhập số điện thoại của bạn">
			</div>

			<button type="submit" class="btn btn-primary">Thanh Toán</button>
		</form>
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
</body>
</html>


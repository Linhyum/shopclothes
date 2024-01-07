<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
				<a href="/myorder.jsp"></a>
				<c:if test="${session != null}">
					<div style="display: flex; align-items: center;">
						<p style="margin-left: 10px; margin-bottom: 0">
							${session.username}</p>
						<button class="btn btn-primary"
							style="margin-left: 10px; margin-right: 10px">
							<a style="text-decoration: none; color: white" href="logout">Đăng
								xuất</a>
						</button>
					</div>
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
		<h1 style="margin-bottom: 20px">Thanh toán thành công!🎉</h1>
		<div style="display: flex; flex-direction: column; gap: 20px">
			<div style="display: flex; align-items: center; gap: 15px">
				<span>Tên khách hàng:</span> <b>${cus.name }</b>
			</div>
			<div style="display: flex; align-items: center; gap: 15px">
				<span>Địa chỉ:</span> <b>${cus.address }</b>
			</div>
			<div style="display: flex; align-items: center; gap: 15px">
				<span>Số điện thoại:</span> <b>${cus.phone }</b>
			</div>
			<div style="display: flex; align-items: center; gap: 15px">
				<span>Ngày mua:</span> <b>${cus.date }</b>
			</div>
			<hr/>
			<div>Danh sách sản phẩm đã mua:</div>
			<ol style="padding: 0;display: flex;flex-direction: column;gap:15px">
				<c:forEach items="${cus.listPro}" var="pro">
					<li style="display: flex; align-items: center; gap: 10px"><img
						alt="" src="${pro.imagepro}" width="80" height="80">
						<h5>${pro.namepro }</h5></li>
				</c:forEach>
			</ol>

		</div>
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
</body>
</html>
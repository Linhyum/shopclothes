<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Đăng nhập</title>
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
<style>
.red {
	color: red;
}
</style>



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


				<c:if test="${session == null}">
					<button class="btn btn-primary"
						style="margin-left: 10px; margin-right: 10px">
						<a style="text-decoration: none; color: white"
							href="/ShopClothes/login.jsp">Đăng nhập</a>
					</button>
				</c:if>
				<div style="position: relative;">
					<a href="cart.jsp"><img src="./img/cart.png"
						style="width: 30px; height: 30px" />
					<c:set var="count" value="${0}" /> <c:forEach
							items="${cart.items}" var="item">
							<c:set var="count" value="${count + 1}" />
						</c:forEach> <span
						style="position: absolute; top: -9px; right: -8px; z-index: 10; background: red; color: white; border-radius: 50%; width: 20px; height: 20px; display: flex; align-items: center; justify-content: center;">${count }</span></a>
				</div>
			</div>
		</div>
	</nav>
	<!-- End Navbar -->
	<main class="form-signin w-100 m-auto container">
		<form class="text-center" action="login" method="POST">
			<img class="mb-4" src="/img/logo/logo.png" alt="" width="72">
			<h1 class="h3 mb-3 fw-normal">ĐĂNG NHẬP</h1>

			<div class="text-center">
				<span class="red"><h5>${saithongtin}</h5></span>
			</div>
			<div class="form-floating">
				<input type="text" class="form-control" required="required"
					id="tenDangNhap" placeholder="Tên đăng nhập" name="username">
				<label for="tenDangNhap">Tên đăng nhập</label>
			</div>
			
				
			

			<div class="form-floating">
				<input type="password" required="required" class="form-control"
					id="matKhau" placeholder="Mật khẩu" name="password"> <label
					for="matKhau">Mật khẩu</label>
			</div>

		
			<button class="w-100 btn btn-lg btn-primary" type="submit">Đăng
				nhập</button>
			<a href="/ShopClothes/register.jsp">Đăng ký tài khoản mới</a>
			<br>
			<a href="/ShopClothes/forgotpassword.jsp">Quên mật khẩu</a>
			<p class="mt-5 mb-3 text-muted">&copy; 2017–2025</p>
		</form>
	</main>
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
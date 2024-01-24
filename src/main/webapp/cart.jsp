<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./Css/styles.css">
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
<title>Shopping Cart</title>
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

	<c:if test="${cart.items == null}">
		<div class="container"
			style="display: flex; flex-direction: column">
			<p class="mx-auto" style="font-size: 25px">Bạn chưa có sản phẩm nào trong giỏ hàng</p>
			<img class="mx-auto" style="width: 250px; height: 250px; object-fit: cover" alt=""
				src="https://assets.materialup.com/uploads/16e7d0ed-140b-4f86-9b7e-d9d1c04edb2b/preview.png" />
		</div>
	</c:if>

	<c:if test="${cart.items != null}">
		<table class="table table-striped container">
			<tbody>
				<tr>
					<th>Tên</th>
					<th>Ảnh</th>
					<th>Số lượng</th>
					<th>Giá</th>
					<th>Tổng</th>
					<th>Xoá</th>
				</tr>
				<!-- Giỏ hàng -->
				<!-- Loop through cart items -->
				<c:forEach var="item" items="${cart.items}">
					<tr>
						<td>${item.product.namepro}</td>
						<td><img src=${item.product.imagepro } alt="Product Image"></td>
						<td>
							<form action="cart" method="post">
								<input type="hidden" name="productCode"
									value="<c:out value='${item.product.id}'/>"> <input
									type="number" name="quantity"
									value="<c:out value='${item.quantity}'/>" id="quantity">
								<input type="submit" value="Update">
							</form>
						</td>
						<td class="card-text" style="color: red"><fmt:formatNumber
								type="number" value="${item.product.pricepro}"
								pattern="###,###đ" /></td>

						<td class="card-text" style="color: red"><fmt:formatNumber
								type="number" value="${item.getTotal()}" pattern="###,###đ" /></td>


						<td>
							<form action="cart" method="post">
								<input type="hidden" name="productCode"
									value="<c:out value='${item.product.id}'/>"> <input
									type="hidden" name="quantity" value="0"> <input
									type="submit" value="Xóa sản phẩm" class="btn btn-primary">
							</form> <c:set var="clear" value="${item.product.id}"></c:set>
						</td>
					</tr>
				</c:forEach>
				<!-- End loop -->

			</tbody>
		</table>
		<div class="container">

			<!-- Tổng giá của tất cả sản phẩm -->
			<div style="font-weight: bold; text-align: right;">
				<c:set var="tong" value="${0}" />
				<c:forEach items="${cart.items}" var="item">
					<c:set var="tong"
						value="${tong + item.quantity * item.product.pricepro}" />
				</c:forEach>
				<p style="color: red">
					Tổng tiền:
					<fmt:formatNumber type="number" value="${tong}" pattern="###,###đ" />
				</p>
			</div>
			<!-- Checkout button -->
			<c:if test="${session != null}">
				<div
					style="font-weight: bold; color: unset; background-color: unset;">
					<a class="btn btn-primary" href="/ShopClothes/checkout.jsp">Check
						Out</a>
				</div>
			</c:if>
			<c:if test="${session == null}">
				<div style="text-align: center;">
					<a class="btn btn-primary" href="/ShopClothes/login.jsp">Bạn
						cần đăng nhập để thanh toán</a>
				</div>
			</c:if>
		</div>
	</c:if>


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

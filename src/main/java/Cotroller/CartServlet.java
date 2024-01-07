package Cotroller;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Database.DaoMySql;
import Model.Cart;
import Model.LineItem;
import Model.Product;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		// Lấy thông tin về sản phẩm và số lượng từ request
		String productCode = request.getParameter("productCode");

		String quantityString = request.getParameter("quantity");
		// Lấy đối tượng Cart từ session (nếu không có, tạo mới)
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
		}

		// Xử lý số lượng sản phẩm và thêm hoặc xóa mục hàng tương ứng từ Cart
		int quantity;
		try {
			quantity = Integer.parseInt(quantityString);
		} catch (NumberFormatException nfe) {
			quantity = 1;
		}

		// Lấy thông tin sản phẩm từ cơ sở dữ liệu
		DaoMySql dao = new DaoMySql();
		Product product;
		try {
			product = dao.getProductid(productCode);
			LineItem lineItem = new LineItem();
			lineItem.setProduct(product);
			lineItem.setQuantity(quantity);

			// Thêm, xóa hoặc giảm số lượng mục hàng tùy thuộc vào giá trị của "quantity"
			if (quantity > 0) {
				cart.updateItem(lineItem);
			} else if (quantity == 0) {
				cart.removeItem(lineItem);
			} else if (quantity == -1) {
				quantity = 1;
			}

		} catch (ClassNotFoundException | SQLException e) {
			// Xử lý nếu có lỗi khi truy cập cơ sở dữ liệu
			e.printStackTrace();
		}

		// Lưu Cart vào session và cập nhật URL thành "cart.jsp"
		session.setAttribute("cart", cart);
		url = "cart.jsp";

		// Chuyển hướng request đến trang được xác định bởi URL
		request.getRequestDispatcher(url).forward(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}

package Cotroller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.DaoMySql;
import Model.Customer;
import Model.Product;
import Model.User;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DaoMySql dao = new DaoMySql();
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String sumprice = req.getParameter("sumprice");
		String sumquantity = req.getParameter("sumquantity");
		String[] idpro = req.getParameterValues("idproduct"); // lấy ra id sản phẩm
		List<Product> list = new ArrayList<>();
		for (int i = 0; i < idpro.length; i++) {
			Product newP = null;
			try {
				newP = dao.getProductid(idpro[i]);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.add(newP);//danh sách các sản phẩm đã mua
		}

		int convertedQuantity = Integer.parseInt(sumquantity); // fix here
		double convertedPrice = Double.parseDouble(sumprice);
		HttpSession ss = req.getSession();
		User user = (User) ss.getAttribute("session");
		int userid = user.getId();
		// lấy thời gian hiện tại
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String datetime = String.valueOf(dtf.format(now));
		Customer cus = new Customer();
		cus.setIduser(userid);
		cus.setDate(datetime);
		cus.setName(name);
		cus.setAddress(address);
		cus.setPhone(phone);
		cus.setListPro(list);
		req.setAttribute("cus", cus);
		try {
			dao.setlistProduct(cus);
			dao.billOrder(userid, convertedQuantity, convertedPrice, datetime);
			req.getRequestDispatcher("Success.jsp").forward(req, resp);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

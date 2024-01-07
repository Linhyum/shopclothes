package Cotroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.DaoMySql;
import Model.User;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		DaoMySql daomysql = new DaoMySql();
		User user;
		try {
			user = daomysql.loginUser(username,pass);
			if (user == null) {
				String mess = "Sai thông tin tài khoản hoặc mật khẩu";
				req.setAttribute("saithongtin", mess);
				getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
			} else {
				HttpSession session = req.getSession(true);
				session.setAttribute("session", user);
//				thiết lập thời gian (đơn vị là giây) mà một phiên (session) có thể không hoạt động trước khi bị hủy (invalidated). 
				session.setMaxInactiveInterval(3000);
				resp.sendRedirect("index");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

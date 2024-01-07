package Cotroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DaoMySql;
import Model.User;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String username = req.getParameter("username");
	String password = req.getParameter("password");
	String emailuser = req.getParameter("emailuser");
	String phoneuser = req.getParameter("phoneuser");
	DaoMySql daomysql = new DaoMySql();
	try {
		User user = daomysql.checkUSer(username);
		if (user == null) {
			daomysql.register(username, password, emailuser, phoneuser);
			resp.sendRedirect("index");
			req.setAttribute("error", "");
			
		} else {
			req.setAttribute("error", "Tài khoản đã tồn tại");
			resp.sendRedirect("/ShopClothes/register.jsp");
		}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
;
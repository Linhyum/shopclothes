package Cotroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DaoMySql;
import Model.Product;
@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String getidpro = req.getParameter("getidpro");
	DaoMySql daomysql = new DaoMySql();
	try {
		Product pro = daomysql.getProductid(getidpro);
		req.setAttribute("product", pro);
		req.getRequestDispatcher("detail.jsp").forward(req, resp);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}

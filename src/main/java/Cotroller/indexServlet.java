package Cotroller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DaoMySql;
import Model.Category;
import Model.Product;

@WebServlet("/index")
public class indexServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			DaoMySql daomysql = new DaoMySql();
			List<Category> listCategory = daomysql.AllCategory();
			req.setAttribute("listCategory", listCategory);
			List<Product> listProduct = daomysql.getAllProduct();
			req.setAttribute("productList", listProduct);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
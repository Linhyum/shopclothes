package Cotroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DaoMySql;
import Model.Category;
import Model.Product;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// hienr thị danh mục của sản phẩm
			String categoryid = req.getParameter("cateid");
			DaoMySql daomysql = new DaoMySql();
			List<Product> listProduct = daomysql.getListProductCategory(categoryid);
			List<Category> listCategory = daomysql.AllCategory();
			req.setAttribute("listCategory", listCategory);
			req.setAttribute("productList", listProduct);
			req.setAttribute("cateid", categoryid);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

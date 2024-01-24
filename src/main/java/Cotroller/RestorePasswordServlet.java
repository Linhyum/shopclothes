package Cotroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.AccountDAO;
import Model.User;

@WebServlet("/RestorePasswordServlet")
public class RestorePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("error", "");
		request.getRequestDispatcher("/restorepassword.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			AccountDAO dao = new AccountDAO();
			if (!User.validate(email, password)) {
				request.setAttribute("error", "Your password is invalid syntax.");
				request.getRequestDispatcher("/restorepassword.jsp").forward(request, response);
			} else {
				dao.updatePassword(email, password);
				request.setAttribute("success", "Restore password success.");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} catch (NamingException | SQLException | NullPointerException e) {
			request.setAttribute("error", "Your path is null.");
			request.getRequestDispatcher("/restorepassword.jsp").forward(request, response);
		}
	}
}
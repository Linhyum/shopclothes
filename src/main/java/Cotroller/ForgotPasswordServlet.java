package Cotroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.AccountDAO;



@WebServlet(urlPatterns= {"/ForgotPasswordServlet"})
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("error", "");
		request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			String email = request.getParameter("email");
			AccountDAO dao = new AccountDAO();
			if (!dao.exists(email)) {
				request.setAttribute("error", "Email does not exists.");
				request.getRequestDispatcher("/forgotpassword.jsp").forward(request, response);
			} else {
				String senderEmail = "doannhatlinh.ltp2021@gmail.com";
				String senderPassword = "dvexbralnvehhbaa"; //System.getenv("EMAIL_SENDER_PASSWORD")
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				props.put("mail.smtp.port", "587");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.starttls.enable", "true");
				Session mailSession = Session.getInstance(props, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(senderEmail, senderPassword);
					}
				});
				try {
					MimeMessage message = new MimeMessage(mailSession);
					message.addHeader("Content-Type", "text/plain; charset=UTF-8");
					message.setFrom(new InternetAddress(senderEmail));
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false));
					message.setSubject("Shop Clothes - Reset password!");
					message.setSentDate(new Date());
//					message.setReplyTo(InternetAddress.parse(senderEmail, false));
					String passwordLink = "http://127.0.0.1:8080" + request.getContextPath()
							+ "/RestorePasswordServlet?email=" + email;
					String emailContent = "Please access path below to restore password:\n" 
							+ passwordLink + "\n\nBest regards!";
					message.setText(emailContent, "UTF-8");					
					Transport.send(message);
					request.getRequestDispatcher("/mailsuccess.jsp").forward(request, response);
				} catch (AddressException e) {
					response.getWriter().println(e);
				} catch (MessagingException e) {
					response.getWriter().println(e);
				}
			}
		} catch (NamingException | SQLException e) {
			response.getWriter().println(e);
		}
	}
}
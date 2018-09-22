package de.lolturm.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.lolturm.message.MessageBean;
import de.lolturm.userid.Userid;
import de.lolturm.userid.UseridBean;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// -------------------BEANS---------------
		MessageBean messageBean = (MessageBean) request.getSession().getAttribute("messageBean");
		if (messageBean == null) {
			messageBean = new MessageBean();
			request.getSession().setAttribute("messageBean", messageBean);
		}
		// ----------------------------------------
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");
		String email = request.getParameter("email");
		String zumlogin = new Denullify().doString(request.getParameter("zumlogin"));
		String register = new Denullify().doString(request.getParameter("register"));
		String comeFrom = new Denullify().doString(request.getParameter("comeFrom"));

		if (zumlogin.equals("Zum Login")) {
			response.sendRedirect("/lolturm/LoginServlet?comeFrom=RegisterServlet");
		} else if (register.equals("Registrieren")) {

			boolean checkEmail, checkUsername, checkPassword;

			checkPassword = Userid.passwordConfirm(password, passwordConfirm);
			if (checkPassword == false) {
				messageBean.setSamePasswordMessage();
			}
			try {
				checkUsername = Userid.checkUsername(userid);
				if (checkUsername == true) {
					messageBean.setSameUseridMessage();
				}
			} catch (ClassNotFoundException | SQLException e1) {
				checkUsername = true;
				messageBean.setGeneralErrorMessage();
				e1.printStackTrace();
			}
			try {
				checkEmail = Userid.checkEmail(email);
				if (checkEmail == true) {
					messageBean.setSameEmailMessage();
				}
			} catch (ClassNotFoundException | SQLException e1) {
				checkEmail = true;
				messageBean.setGeneralErrorMessage();
				e1.printStackTrace();
			}

			UseridBean useridBean = new UseridBean();
			useridBean.setUsername(userid);
			useridBean.setPassword(password);
			useridBean.setEmail(email);

			try {
				if (!checkEmail && checkPassword && !checkUsername) {
					Userid.insert(useridBean);
					messageBean.setSuccessfullyInsertMessage();
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				messageBean.setGeneralErrorMessage();
			}

			response.sendRedirect("/lolturm/jsp/RegisterView.jsp");
		} else if (!comeFrom.equals("")) {
			messageBean.setEmptyMessage();
			response.sendRedirect("/lolturm/jsp/RegisterView.jsp");
		} else {
			response.sendRedirect("/lolturm/jsp/RegisterView.jsp");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

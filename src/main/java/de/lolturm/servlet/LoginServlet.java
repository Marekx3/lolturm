package de.lolturm.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.lolturm.html.ComeFromBean;
import de.lolturm.message.MessageBean;
import de.lolturm.userid.Userid;
import de.lolturm.userid.UseridBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
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
		
		UseridBean useridBean = (UseridBean) request.getSession().getAttribute("useridBean");
		if (useridBean == null) {
			useridBean = new UseridBean();
			request.getSession().setAttribute("useridBean", useridBean);
		}
		
		ComeFromBean comeFromBean = (ComeFromBean) request.getSession().getAttribute("comeFromBean");
		if (comeFromBean == null) {
			comeFromBean = new ComeFromBean();
			request.getSession().setAttribute("comeFromBean", comeFromBean);
		}
		// ----------------------------------------
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String login = new Denullify().doString(request.getParameter("login"));
		String zurReg = new Denullify().doString(request.getParameter("zurReg"));
		String comeFrom = new Denullify().doString(request.getParameter("comeFrom"));
		//-------------------Login Merker-------------
		if (!comeFrom.equals("")) {
			comeFromBean.setComeFrom(comeFrom);
		}
		comeFromBean.setCurrentSite("LoginServlet");
		//--------------------------------------------
		
		System.out.println("\"" + comeFromBean.getComeFrom() + "\"");
		
		if (login.equals("Login")) {
			
			boolean checkUsername, checkPassword;
			
			try {
				checkUsername = Userid.checkUsername(userid);
				if (checkUsername == true) {
					checkPassword = Userid.checkPassword(userid, password);
					if (checkPassword == true) {
						messageBean.setMessage("Erfolgreich Eingeloggt!");
						useridBean.setUsername(userid);
						useridBean.setId(Userid.getId(userid));
						System.out.println("\"" + comeFromBean.getComeFrom() + "\"");
						if (!comeFromBean.getComeFrom().equals("")) {
							response.sendRedirect("/" + comeFromBean.getComeFrom() + "?comeFrom=LoginServlet");
						} else {
							response.sendRedirect("/index.jsp");
						}
					} else {
						messageBean.setMessage("Falsches Password!");
						response.sendRedirect("/jsp/LoginView.jsp");
					}
				} else {
					messageBean.setMessage("Falscher Username!");
					response.sendRedirect("/jsp/LoginView.jsp");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				messageBean.setGeneralErrorMessage();
				response.sendRedirect("/jsp/LoginView.jsp");
			}
		
//			response.sendRedirect("/lolturm/jsp/LoginView.jsp");
		} else if (zurReg.equals("Zur Registrierung")) {
			response.sendRedirect("/jsp/RegisterView.jsp?comeFrom=LoginServlet");
		} else if (!comeFrom.equals("")) {
			messageBean.setEmptyMessage();
			response.sendRedirect("/jsp/LoginView.jsp");
		} else {
			response.sendRedirect("/jsp/LoginView.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

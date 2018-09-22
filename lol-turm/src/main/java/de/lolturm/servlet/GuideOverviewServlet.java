package de.lolturm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.lolturm.enumeration.PositionEnum;
import de.lolturm.html.ComeFromBean;
import de.lolturm.html.GuideOverviewBean;
import de.lolturm.html.PositionBean;

/**
 * Servlet implementation class GuideOverviewServlet
 */
@WebServlet("/GuideOverviewServlet")
public class GuideOverviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuideOverviewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// --------------------------BEANS----------------
		PositionBean positionBean = (PositionBean) request.getSession().getAttribute("positionBean");
		if (positionBean == null) {
			positionBean = new PositionBean();
			request.getSession().setAttribute("positionBean", positionBean);
		}
		GuideOverviewBean guideOverviewBean = (GuideOverviewBean) request.getSession().getAttribute("guideOverviewBean");
		if (guideOverviewBean == null) {
			guideOverviewBean = new GuideOverviewBean();
			request.getSession().setAttribute("guideOverviewBean", guideOverviewBean);
		}
		ComeFromBean comeFromBean = (ComeFromBean) request.getSession().getAttribute("comeFromBean");
		if (comeFromBean == null) {
			comeFromBean = new ComeFromBean();
			request.getSession().setAttribute("comeFromBean", comeFromBean);
		}
		//------------------------------------------------
		String comeFrom = new Denullify().doString(request.getParameter("comeFrom"));
		String login = new Denullify().doString(request.getParameter("login"));
		//-------------------Login Merker-------------
		if (!comeFrom.equals("")) {
			comeFromBean.setComeFrom(comeFrom);
		}
		comeFromBean.setCurrentSite("GuideOverviewServlet");
		//--------------------------------------------
		
		if (login.equals("Login")) {
			response.sendRedirect("/lolturm/LoginServlet?comeFrom=GuideOverviewServlet");
		} else if (comeFrom.equals("LoginServlet")) {
			response.sendRedirect("/lolturm/jsp/GuideOverview.jsp");
		} else if(!comeFrom.equals("")) {
			if(!positionBean.getChampion().equals("9999999") && !positionBean.getPosition().equals(PositionEnum.Null)) {
				guideOverviewBean.setChampion(positionBean.getChampion());
				guideOverviewBean.setPosition(positionBean.getPosition());
			}
			response.sendRedirect("/lolturm/jsp/GuideOverview.jsp");
		} else {
			response.sendRedirect("/lolturm/IndexServlet?comeFrom=GuideOverviewServlet");
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

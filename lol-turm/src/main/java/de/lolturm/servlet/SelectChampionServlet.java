package de.lolturm.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.lolturm.champion.ChampionBean;
import de.lolturm.champion.Champions;
import de.lolturm.enumeration.PositionEnum;
import de.lolturm.html.ComeFromBean;
import de.lolturm.html.PositionBean;
import de.lolturm.html.SelectChampionBean;

/**
 * Servlet implementation class SelectChampionServlet
 */
@WebServlet("/SelectChampionServlet")
public class SelectChampionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectChampionServlet() {
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
		SelectChampionBean selectChampionBean = (SelectChampionBean) request.getSession().getAttribute("selectChampionBean");
		if (selectChampionBean == null) {
			selectChampionBean = new SelectChampionBean();
			request.getSession().setAttribute("selectChampionBean", selectChampionBean);
		}
		ComeFromBean comeFromBean = (ComeFromBean) request.getSession().getAttribute("comeFromBean");
		if (comeFromBean == null) {
			comeFromBean = new ComeFromBean();
			request.getSession().setAttribute("comeFromBean", comeFromBean);
		}
		// ---------------------------------------------
		String comeFrom = new Denullify().doString(request.getParameter("comeFrom"));
		String championString = new Denullify().doInt(request.getParameter("champion"));
		String login = new Denullify().doString(request.getParameter("login"));
		//-------------------Login Merker-------------
		if (!comeFrom.equals("")) {
			comeFromBean.setComeFrom(comeFrom);
		}
		comeFromBean.setCurrentSite("SelectChampionServlet");
		//--------------------------------------------
		
		if (positionBean.getPosition().equals(PositionEnum.Null)) {
			selectChampionBean.setPosition(positionBean.getPosition());
			response.sendRedirect("/lolturm/jsp/SelectChampion.jsp");
		} else if (!championString.equals("9999999")) {
			try {
				
				ChampionBean champion = Champions.get(Integer.parseInt(championString));
				positionBean.setChampion(champion);
				response.sendRedirect("/lolturm/GuideOverviewServlet?comeFrom=SelectChampionBean");
				
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		} else if(login.equals("Login")) {
			response.sendRedirect("/lolturm/LoginServlet?comeFrom=SelectChampionServlet");
		} else if (!comeFrom.equals("")) {
			if (!positionBean.getPosition().equals(PositionEnum.Null)) {
				selectChampionBean.setPosition(positionBean.getPosition());
			}
			response.sendRedirect("/lolturm/jsp/SelectChampion.jsp");
		} else {
			response.sendRedirect("/lolturm/IndexServlet?comeFrom=SelectChampionServlet");
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

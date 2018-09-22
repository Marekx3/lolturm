package de.lolturm.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.lolturm.enumeration.PositionEnum;
import de.lolturm.html.ComeFromBean;
import de.lolturm.html.PositionBean;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//--------------------------BEANS----------------
		PositionBean positionBean = (PositionBean) request.getSession().getAttribute("positionBean");
		if (positionBean == null) {
			positionBean = new PositionBean();
			request.getSession().setAttribute("positionBean", positionBean);
		}
		ComeFromBean comeFromBean = (ComeFromBean) request.getSession().getAttribute("comeFromBean");
		if (comeFromBean == null) {
			comeFromBean = new ComeFromBean();
			request.getSession().setAttribute("comeFromBean", comeFromBean);
		}
		//---------------------------------------------
		
		PositionEnum position = new Denullify().doPositionEnum(PositionEnum.getByPosition(request.getParameter("position")));
		String comeFrom = new Denullify().doString(request.getParameter("comeFrom"));
		String login = new Denullify().doString(request.getParameter("login"));
		String index = new Denullify().doString(request.getParameter("index"));
		
		//-------------------Login Merker-------------
		if (!comeFrom.equals("")) {
			comeFromBean.setComeFrom(comeFrom);
		}
		comeFromBean.setCurrentSite("IndexServlet");
		//--------------------------------------------
		
		if (!position.equals(PositionEnum.Null)) {
			positionBean.setPosition(position);
			response.sendRedirect("/lolturm/SelectChampionServlet?comeFrom=IndexServlet");
		} else if (login.equals("Login")) {
			positionBean.setPosition(PositionEnum.Null);
			response.sendRedirect("/lolturm/LoginServlet?comeFrom=IndexServlet");
		} else if (index.equals("index")) {
			positionBean.setPosition(PositionEnum.Null);
			response.sendRedirect("/lolturm/index.jsp");
		} else if (!comeFrom.equals("")) {
			positionBean.setPosition(PositionEnum.Null);
			response.sendRedirect("/lolturm/index.jsp");
		} else {
			positionBean.setPosition(PositionEnum.Null);
			response.sendRedirect("/lolturm/index.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

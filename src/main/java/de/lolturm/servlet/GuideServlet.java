package de.lolturm.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.lolturm.guide.GuideBean;
import de.lolturm.guide.Guides;
import de.lolturm.html.ComeFromBean;
import de.lolturm.userid.UseridBean;

/**
 * Servlet implementation class GuideServlet
 */
@WebServlet("/GuideServlet")
public class GuideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuideServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//--------------------------BEANS----------------
		GuideBean guideBean = (GuideBean) request.getSession().getAttribute("guideBean");
		if (guideBean == null) {
			guideBean = new GuideBean();
			request.getSession().setAttribute("guideBean", guideBean);
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
		//---------------------------------------------
		
		String guide = new Denullify().doInt(request.getParameter("guide"));
		String comeFrom = new Denullify().doString(request.getParameter("comeFrom"));
		String bewertung = new Denullify().doString(request.getParameter("bewertung"));
		String login = new Denullify().doString(request.getParameter("login"));
		String aendern = new Denullify().doString(request.getParameter("aendern"));

		
		//-------------------Login Merker-------------
		if (!comeFrom.equals("")) {
			comeFromBean.setComeFrom(comeFrom);
		}
		comeFromBean.setCurrentSite("GuideServlet");
		//--------------------------------------------
		
		String username = new Denullify().doString(useridBean.getUsername());
		
		if(!guide.equals("9999999")) {
			try {
				GuideBean guides = Guides.getGuide(guide);
				
				guideBean.setId(guides.getId());
				guideBean.setGuideName(guides.getGuideName());
				guideBean.setDate(guides.getDate());
				guideBean.setChampion(guides.getChampion());
				guideBean.setUser(guides.getUser());
				guideBean.setPosition(guides.getPosition());
				guideBean.setSkillOrder(guides.getSkillOrder());
				guideBean.setSkillOrderDesc(guides.getSkillOrderDesc());
				guideBean.setRunes(guides.getRunes());
				guideBean.setRunesDesc(guides.getRunesDesc());
				guideBean.setBewertung(guides.getBewertung());
				guideBean.setItemSet(guides.getItemSet());
				guideBean.setItemSetDesc(guides.getItemSetDesc());
				guideBean.setPatch(guides.getPatch());
				
				response.sendRedirect("/jsp/Guide.jsp");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				response.sendRedirect("/IndexServlet?comeFrom=GuideServlet");
			}
		} else if (bewertung.equals("up")) {
			if(!username.equals("")) {
				Guides.setGuideBean(guideBean);
				Guides.setUseridBean(useridBean);
				try {
					boolean checkAlreadyBewertet = Guides.checkAlreadyBewertet();
					if(!checkAlreadyBewertet) {
						Guides.setUpBewertung();
						guideBean.setBewertung(guideBean.getBewertung() + 1);
					} else {
						Integer wert = Guides.getBewertet();
						if (wert == 1) {

						} else {
							Guides.setUpBewertung();
							guideBean.setBewertung(guideBean.getBewertung() + 1);
						}
					}
					response.sendRedirect("/jsp/Guide.jsp");
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
					response.sendRedirect("/IndexServlet?comeFrom=GuideServlet");
				}
			} else {
				response.sendRedirect("/LoginServlet?comeFrom=GuideServlet");
			}
		} else if (bewertung.equals("down")) {
			if(!username.equals("")) {
				try {
					boolean checkAlreadyBewertet = Guides.checkAlreadyBewertet();
					if(!checkAlreadyBewertet) {
						Guides.setDownBewertung();
						guideBean.setBewertung(guideBean.getBewertung() - 1);
					}  else {
						Integer wert = Guides.getBewertet();
						if (wert == -1) {

						} else {
							Guides.setDownBewertung();
							guideBean.setBewertung(guideBean.getBewertung() - 1);
						}
					}
					response.sendRedirect("/jsp/Guide.jsp");
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
					response.sendRedirect("/IndexServlet?comeFrom=GuideServlet");
				}
			} else {
				response.sendRedirect("/LoginServlet?comeFrom=GuideServlet");
			}
		} else if (aendern.equals("Aendern")) {
			response.sendRedirect("/NewGuideServlet?comeFrom=GuideServlet");
		} else if (comeFrom.equals("LoginServlet")) {
			response.sendRedirect("/jsp/Guide.jsp");
		} else if(login.equals("Login")) {
			response.sendRedirect("/LoginServlet?comeFrom=GuideServlet");
		} else if (!comeFrom.equals("")) {
			response.sendRedirect("/IndexServlet?comeFrom=GuideServlet");
		} else {
			response.sendRedirect("/IndexServlet?comeFrom=GuideServlet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

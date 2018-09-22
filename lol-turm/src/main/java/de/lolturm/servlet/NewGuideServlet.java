package de.lolturm.servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import de.lolturm.champion.Champions;
import de.lolturm.enumeration.PositionEnum;
import de.lolturm.guide.GuideBean;
import de.lolturm.guide.Guides;
import de.lolturm.html.ComeFromBean;
import de.lolturm.itemset.ItemSetBean;
import de.lolturm.message.MessageBean;
import de.lolturm.rune.RuneBean;
import de.lolturm.skillorder.SkillOrderBean;
import de.lolturm.userid.UseridBean;

/**
 * Servlet implementation class NewGuideServlet
 */
@WebServlet("/NewGuideServlet")
public class NewGuideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewGuideServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//---------------------BEANS----------------
		UseridBean useridBean = (UseridBean) request.getSession().getAttribute("useridBean");
		if (useridBean == null) {
			useridBean = new UseridBean();
			request.getSession().setAttribute("useridBean", useridBean);
		}
		GuideBean guideBean = (GuideBean) request.getSession().getAttribute("guideBean");
		if (guideBean == null) {
			guideBean = new GuideBean();
			request.getSession().setAttribute("guideBean", guideBean);
		}
		ComeFromBean comeFromBean = (ComeFromBean) request.getSession().getAttribute("comeFromBean");
		if (comeFromBean == null) {
			comeFromBean = new ComeFromBean();
			request.getSession().setAttribute("comeFromBean", comeFromBean);
		}
		MessageBean messageBean = (MessageBean) request.getSession().getAttribute("messageBean");
		if (messageBean == null) {
			messageBean = new MessageBean();
			request.getSession().setAttribute("messageBean", messageBean);
		}
		//-------------------------------------------
		
		String guideName = request.getParameter("guideName");
		String champion = request.getParameter("champion");
		String position = request.getParameter("position");
		String slot1 = request.getParameter("slot1");
		String slot2 = request.getParameter("slot2");
		String slot3 = request.getParameter("slot3");
		String slot4 = request.getParameter("slot4");
		String slot5 = request.getParameter("slot5");
		String slot6 = request.getParameter("slot6");
		String slot7 = request.getParameter("slot7");
		String itemSetDesc = request.getParameter("itemSetDesc");
		String patch = request.getParameter("patch");
		String speichern = new Denullify().doString(request.getParameter("speichern"));
		String neu = new Denullify().doString(request.getParameter("neu"));
		String comeFrom = new Denullify().doString(request.getParameter("comeFrom"));
		
		String keystone = request.getParameter("keystone");
		String firstRune = request.getParameter("firstRune");
		String secondRune = request.getParameter("secondRune");
		String thirdRune = request.getParameter("thirdRune");
		String firstSecondTree = request.getParameter("firstSecondTree");
		String secondSecondTree = request.getParameter("secondSecondTree");
		String keystoneId = request.getParameter("keystoneId");
		String secondTreeId = request.getParameter("secondTreeId");
		String runesDesc = request.getParameter("runesDesc");
		
		String level1 = request.getParameter("level1");
		String level2 = request.getParameter("level2");
		String level3 = request.getParameter("level3");
		String level4 = request.getParameter("level4");
		String level5 = request.getParameter("level5");
		String level6 = request.getParameter("level6");
		String level7 = request.getParameter("level7");
		String level8 = request.getParameter("level8");
		String level9 = request.getParameter("level9");
		String level10 = request.getParameter("level10");
		String level11 = request.getParameter("level11");
		String level12 = request.getParameter("level12");
		String level13 = request.getParameter("level13");
		String level14 = request.getParameter("level14");
		String level15 = request.getParameter("level15");
		String level16 = request.getParameter("level16");
		String level17 = request.getParameter("level17");
		String level18 = request.getParameter("level18");

		String skillOrderDesc = request.getParameter("skillOrderDesc");
		
		//-------------------Login Merker-------------
		if (!comeFrom.equals("")) {
			comeFromBean.setComeFrom(comeFrom);
		}
		comeFromBean.setCurrentSite("GuideOverviewServlet");
		//--------------------------------------------

		
		if (speichern.equals("Speichern")) {
			try {
				guideBean.setGuideName(guideName);
				guideBean.setChampion(Champions.get(Integer.parseInt(champion)));
				guideBean.setPosition(PositionEnum.getByPosition(position));
				ItemSetBean itemSetBean = new ItemSetBean();
				String itemset = itemSetBean.getItemSetString(slot1, slot2, slot3, slot4, slot5, slot6, slot7);
				guideBean.setItemSet(itemSetBean.setItemSetArray(itemset));
				guideBean.setItemSetDesc(itemSetDesc);
				guideBean.setPatch(patch);
				
				RuneBean runeBean = new RuneBean();
				runeBean.getRunen().add(keystone);
				runeBean.getRunen().add(firstRune);
				runeBean.getRunen().add(secondRune);
				runeBean.getRunen().add(thirdRune);
				runeBean.getRunen().add(firstSecondTree);
				runeBean.getRunen().add(secondSecondTree);
				runeBean.getRunen().add(keystoneId);
				runeBean.getRunen().add(secondTreeId);

				guideBean.setRunes(runeBean);
				guideBean.setRunesDesc(runesDesc);
				guideBean.setUser(useridBean);
				
				SkillOrderBean skillOrderBean = new SkillOrderBean();
				skillOrderBean.getSkillOrder().add(level1);
				skillOrderBean.getSkillOrder().add(level2);
				skillOrderBean.getSkillOrder().add(level3);
				skillOrderBean.getSkillOrder().add(level4);
				skillOrderBean.getSkillOrder().add(level5);
				skillOrderBean.getSkillOrder().add(level6);
				skillOrderBean.getSkillOrder().add(level7);
				skillOrderBean.getSkillOrder().add(level8);
				skillOrderBean.getSkillOrder().add(level9);
				skillOrderBean.getSkillOrder().add(level10);
				skillOrderBean.getSkillOrder().add(level11);
				skillOrderBean.getSkillOrder().add(level12);
				skillOrderBean.getSkillOrder().add(level13);
				skillOrderBean.getSkillOrder().add(level14);
				skillOrderBean.getSkillOrder().add(level15);
				skillOrderBean.getSkillOrder().add(level16);
				skillOrderBean.getSkillOrder().add(level17);
				skillOrderBean.getSkillOrder().add(level18);

				guideBean.setSkillOrder(skillOrderBean);
				guideBean.setSkillOrderDesc(skillOrderDesc);
				
				if (useridBean.getId() == null) {
					response.sendRedirect("/lolturm/LoginServlet?comeFrom=NewGuideServlet");
				} else {
					Guides.setGuideBean(guideBean);
					Guides.setUseridBean(useridBean);
					if (!Guides.checkGuide()) {
						Integer id = Guides.insertGuide();
						messageBean.setSuccessfullySafedMessage();
						guideBean.setId(id);
						response.sendRedirect("/lolturm/jsp/NewGuide.jsp");
					} else {
						Guides.updateGuide();
						response.sendRedirect("/lolturm/jsp/NewGuide.jsp");
					}
				}
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		} else if (neu.equals("Neu")) {
			request.getSession().removeAttribute("guideBean");
			guideBean = (GuideBean) request.getSession().getAttribute("guideBean");
			if (guideBean == null) {
				guideBean = new GuideBean();
				request.getSession().setAttribute("guideBean", guideBean);
			}
			request.getSession().removeAttribute("useridBean");
			useridBean = (UseridBean) request.getSession().getAttribute("useridBean");
			if (useridBean == null) {
				useridBean = new UseridBean();
				request.getSession().setAttribute("useridBean", useridBean);
			}
			response.sendRedirect("/lolturm/jsp/NewGuide.jsp");
		} else if (comeFrom.equals("GuideServlet")) {
			response.sendRedirect("/lolturm/jsp/NewGuide.jsp");
		} else if (!comeFrom.equals("")) {
			response.sendRedirect("/lolturm/jsp/NewGuide.jsp");
		} else {
			guideBean = new GuideBean();
			response.sendRedirect("/lolturm/jsp/NewGuide.jsp");
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

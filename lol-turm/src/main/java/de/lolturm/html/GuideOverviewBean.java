package de.lolturm.html;

import java.util.ArrayList;

import de.lolturm.champion.ChampionBean;
import de.lolturm.enumeration.KeystoneEnum;
import de.lolturm.enumeration.PositionEnum;
import de.lolturm.guide.GuideBean;
import de.lolturm.guide.Guides;

public class GuideOverviewBean {
	
	private PositionEnum position;
	private ChampionBean champion;
	
	public GuideOverviewBean() {

	}
	
	public String getGuideOverviewHtml() {
		String html = "";
		
		Integer championid = this.champion.getId();
		
		try {
			ArrayList<GuideBean> guides = Guides.getGuide(championid, this.position.getPositon());
			
			for (GuideBean guide : guides) {
				
				html += "<div class='item'>\n";
				html += "<div class='patch'>" + guide.getPatch() + "</div>\n";
				html += "<div class='picture'>\n";
				html +=	"<img src='http://ddragon.leagueoflegends.com/cdn/6.24.1/img/champion/" + guide.getChampion().getName() + ".png' />\n";
				html +=	"</div>\n";
				html +=	"<div class='position'>\n";
				html +=	"<img src='/lolturm/images/icons/" + guide.getPosition() + ".png' />\n";
				html +=	"</div>\n";
				html +=	"<div class='keystone'>\n";
				html +=	"<img src='/lolturm/images/runes/" + KeystoneEnum.getById(Integer.parseInt(guide.getRunes().getKeystoneId())).getEnglischText() + ".png' />\n";
				html +=	"</div>\n";
				html +=	"<div class='secondtree'>\n";
				html +=	"	<img src='/lolturm/images/runes/" + KeystoneEnum.getById(Integer.parseInt(guide.getRunes().getSecondTreeId())).getEnglischText() + ".png' />\n";
				html +=	"</div>\n";
				html +=	"<div class='info'>\n";
				html +=	"<p>" + guide.getUser().getUsername() + "</p>\n";
				html +=	"<p>35</p>\n";
				html +=	"</div>\n";
				html +=	"<div class='itemset'>\n";
			
				for (Integer itemBean : guide.getItemSet().getItemSetArray()) {
					html += "<img src='http://ddragon.leagueoflegends.com/cdn/6.24.1/img/item/" + itemBean + ".png' />\n";
				}
			
				html +=	"</div>\n";
				html +=	"<div class='bewertung'>\n";
				html +=	"	<p>\n";
				html +=	"	Bewertung:\n";
				html +=	guide.getBewertung() + "</p>\n";
				html +=	"</div>\n";
				html +=	"<div class='button'>\n";
				html += "<a href='/lolturm/GuideServlet?guide=" + guide.getId() + "'>";
				html +=	"<button>Ganzer Guide!</button>\n";
				html += "</a>";
				html +=	"</div>\n";
				html +=	"</div>\n";

		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return html;
	}

	public PositionEnum getPosition() {
		return position;
	}

	public void setPosition(PositionEnum position) {
		this.position = position;
	}

	public ChampionBean getChampion() {
		return champion;
	}

	public void setChampion(ChampionBean champion) {
		this.champion = champion;
	}
}

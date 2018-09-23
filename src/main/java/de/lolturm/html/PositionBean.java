package de.lolturm.html;

import de.lolturm.champion.LTChampionBean;
import de.lolturm.enumeration.PositionEnum;

public class PositionBean {
	
	private PositionEnum position;
	private LTChampionBean champion;
	
	public PositionBean() {
		this.position = null;
		this.champion = null;
	}

	public String getPositionHtml() {
		String html = "";
		html += "<div class='container-fluid'>\n";
		html += "<div class='roles'>\n";
		html += "	<ul>\n";

		for (PositionEnum position : PositionEnum.values()) {

			html += "<li>\n";
			html += "	<a href='/IndexServlet?position="+ position +"'>\n";
			html += "		<img src='/images/icons/" + position + ".png' />\n";
			html += "	</a>\n";
			html += "</li>\n";

		}

		html += "		</ul>\n";
		html += "	</div>\n";
		html += "	<!--\n";
		html += "	<div class='newsguides'>\n";
		html += "		<a href='jsp/SelectChampion.jsp'>asd</a>\n";
		html += "	</div>\n";
		html += "-->\n";
		html += "</div>\n";
		return html;
	}

	public PositionEnum getPosition() {
		return position;
	}

	public void setPosition(PositionEnum position) {
		this.position = position;
	}

	public LTChampionBean getChampion() {
		return champion;
	}

	public void setChampion(LTChampionBean champion) {
		this.champion = champion;
	}
}

package de.lolturm.html;

import java.sql.SQLException;
import java.util.ArrayList;

import de.lolturm.champion.ChampionBean;
import de.lolturm.champion.Champions;
import de.lolturm.enumeration.PositionEnum;

public class SelectChampionBean {
	
	private PositionEnum position;
	
	public SelectChampionBean() {

	}
	
	public String getSelectChampionHtml() throws ClassNotFoundException, SQLException {
		String html = "";
		
		ArrayList<ChampionBean> champions = Champions.allChampions(position + "");
			
		for (ChampionBean champion : champions) {
		
		html += "<a href='/lolturm/SelectChampionServlet?champion="+champion.getId()+"&position="+ this.position +"'>\n";
		html += "<img alt='"+champion.getName()+"' class='champions' src='http://ddragon.leagueoflegends.com/cdn/6.24.1/img/champion/"+champion.getKey()+".png'>\n";
		html += "</a>\n";
		
		}
		return html;
	}

	public PositionEnum getPosition() {
		return position;
	}

	public void setPosition(PositionEnum position) {
		this.position = position;
	}
}

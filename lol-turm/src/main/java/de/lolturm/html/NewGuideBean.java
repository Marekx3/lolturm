package de.lolturm.html;

import java.sql.SQLException;

import de.lolturm.champion.ChampionBean;
import de.lolturm.champion.Champions;
import de.lolturm.enumeration.DominationEnum;
import de.lolturm.enumeration.InspirationEnum;
import de.lolturm.enumeration.KeystoneEnum;
import de.lolturm.enumeration.PositionEnum;
import de.lolturm.enumeration.PrecisionEmun;
import de.lolturm.enumeration.ResolveEnum;
import de.lolturm.enumeration.SorceryEnum;
import de.lolturm.guide.GuideBean;
import de.lolturm.itemset.ItemBean;
import de.lolturm.itemset.Items;

public class NewGuideBean {
	
	private GuideBean guideBean;
	
	public NewGuideBean() {

	}
	
	public GuideBean getGuideBean() {
		return guideBean;
	}

	public void setGuideBean(GuideBean guideBean) {
		this.guideBean = guideBean;
	}
	
	public String getChampionsSelectHtml() throws ClassNotFoundException, SQLException {
		String html = "";
		
		html += "<select name='champion'>\n";

		for (ChampionBean championBean : Champions.allChampions()) {
			if (championBean.getName().equals(guideBean.getChampion().getName())) {
				html += "<option selected value='" + championBean.getId() + "'> "+ championBean.getName() + "</option>\n";
			} else {
				html += "<option value='" + championBean.getId() + "'> "+ championBean.getName() + "</option>\n";
			}
		}
		
		html += "</select>\n";
		
		
		return html;
	}
	
	public String getPositionSelectHtml() {
		String html = "";
		
		html += "<select name='position'>\n";
		
		for (PositionEnum position : PositionEnum.values()) {
			if (position.getPositon().equals(guideBean.getPosition().getPositon())) {
				html += "<option selected value='" + position + "'> "+ position + "</option>\n";
			} else {
				html += "<option value='" + position + "'> "+ position + "</option>\n";
			}
			
		}
		
		html += "</select>\n";
		
		return html;
	}
	
	public String getFullBuildHtml() throws ClassNotFoundException, SQLException {
		String html = "";
		
		for (int i = 1; i <= 6; i++) {
			html += "<select name='slot"+ i +"'>\n";
			for (ItemBean itemBean : Items.getAllFiveOnFiveItems()) {
				if (itemBean.getId().equals(guideBean.getId())) {
					html += "<option selected value='" + itemBean.getId() + "'> "+itemBean.getName() + "</option>\n";
				} else {
					html += "<option value='" + itemBean.getId() + "'> "+itemBean.getName() + "</option>\n";
				}
			}
			html += "</select>\n";
		}
		html += "<select name='slot7'>\n";
		for (ItemBean itemBean : Items.getAllTrinketItems()) {
			html += "<option selected value='" + itemBean.getId() + "'> "+itemBean.getName() + "</option>\n";
		}
		html += "</select>\n";

		return html;
	}
	
	public String getPatchHtml() {
		String html = "";
		
		html += "<select name='patch'>\n";
		html += "<option value='7.24'>7.24</option>\n";
		html += "</select>\n";

		return html;
	}
	
	public String getRunenHtml() {
		String html = "";

		html += "<div id='runesSelect'>\n";
		html += "<div id='keystoneTree'>\n";
		html += "<div id='keystone'>\n";
				
					for (KeystoneEnum keystone : KeystoneEnum.values()) {
				
				html += "<button type='button' id='" + keystone.getEnglischText() + "Keystone'>" + keystone.getEnglischText() + "</button>\n";
				
					}
				
				html += "</div>\n";
				html += "<div id='keystoneSelect'>\n";
				html += "<div id='precisionSelect'>\n";
				 for (PrecisionEmun precision : PrecisionEmun.values()) { 
				html += "<button type='button' id='" + precision.getFirstRune().getIdName() + "'>\n";
				html += "<img src='/lolturm/images/icons/rune/" + precision.getFirstRune().getIdName() + ".png' />\n";
				html += "</button>\n";
				html += "<button type='button' id='" + precision.getSecondRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + precision.getSecondRune().getIdName() + ".png' /></button>\n";
				html += "<button type='button' id='" + precision.getThirdRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + precision.getThirdRune().getIdName() + ".png' /></button>\n";
				html += "<br />\n";
				 } 
				html += "</div>\n";
				html += "<div id='dominationSelect'>\n";
				 for (DominationEnum domination : DominationEnum.values()) { 
				html += "<button type='button' id='" + domination.getFirstRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + domination.getFirstRune().getIdName() + ".png' /></button>\n";
				html += "<button type='button' id='" + domination.getSecondRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + domination.getSecondRune().getIdName() + ".png' /></button>\n";
				html += "<button type='button' id='" + domination.getThirdRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + domination.getThirdRune().getIdName() + ".png' /></button>\n";
				html += "<br />\n";
				} 
				html += "</div>\n";
				html += "<div id='sorcerySelect'>\n";
				 for (SorceryEnum sorcery : SorceryEnum.values()) { 
				html += "<button type='button' id='" + sorcery.getFirstRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + sorcery.getFirstRune().getIdName() + ".png' /></button>\n";
				html += "<button type='button' id='" + sorcery.getSecondRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + sorcery.getSecondRune().getIdName() + ".png' /></button>\n";
				html += "<button type='button' id='" + sorcery.getThirdRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + sorcery.getThirdRune().getIdName() + ".png' /></button>\n";
				html += "<br />\n";
				 } 
				html += "</div>\n";
				html += "<div id='resolveSelect'>\n";
				 for (ResolveEnum resolve : ResolveEnum.values()) { 
				html += "<button type='button' id='" + resolve.getFirstRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + resolve.getFirstRune().getIdName() + ".png' /></button>\n";
				html += "<button type='button' id='" + resolve.getSecondRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + resolve.getSecondRune().getIdName() + ".png' /></button>\n";
				html += "<button type='button' id='" + resolve.getThirdRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + resolve.getThirdRune().getIdName() + ".png' /></button>\n";
				html += "<br />\n";
				 } 
				html += "</div>\n";
				html += "<div id='inspirationSelect'>\n";
				for (InspirationEnum inspiration : InspirationEnum.values()) {
				html += "<button type='button' id='" + inspiration.getFirstRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + inspiration.getFirstRune().getIdName() + ".png' /></button>\n";
				html += "<button type='button' id='" + inspiration.getSecondRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + inspiration.getSecondRune().getIdName() + ".png' /></button>\n";
				html += "<button type='button' id='" + inspiration.getThirdRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + inspiration.getThirdRune().getIdName() + ".png' /></button>\n";
				html += "<br />\n";
				 } 
				html += "</div>\n";
				html += "</div>\n";
				html += "</div>\n";
				html += "<div id='secondTreeTree'>\n";
				html += "<div id='secondTree'>\n";
				
					for (KeystoneEnum keystone : KeystoneEnum.values()) {
				
				html += "<button type='button' id='" + keystone.getEnglischText() + "SecondTree'>" + keystone.getEnglischText() + "</button>\n";
				
					}
				
				html += "</div>\n";
				html += "<div id='secondTreeSelect'>\n";
				html += "<div id='precisionSecondTreeSelect'>\n";
				
				PrecisionEmun[] precision = PrecisionEmun.values();
				for (int i = 1; i < precision.length; i++) { 
				html += "<button type='button' class='" + precision[i].getFirstRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + precision[i].getFirstRune().getIdName() + ".png' /></button>\n";
				html += "<button type='button' class='" + precision[i].getSecondRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + precision[i].getSecondRune().getIdName() + ".png' /></button>\n";
				html += "<button type='button' class='" + precision[i].getThirdRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + precision[i].getThirdRune().getIdName() + ".png' /></button>\n";
				html += "<br />\n";
				 } 
				html += "</div>\n";
				html += "<div id='dominationSecondTreeSelect'>\n";
				
				DominationEnum[] domination = DominationEnum.values();
				for (int i = 1; i < domination.length; i++) { 
					html += "<button type='button' class='" + domination[i].getFirstRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + domination[i].getFirstRune().getIdName() + ".png' /></button>\n";
					html += "<button type='button' class='" + domination[i].getSecondRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + domination[i].getSecondRune().getIdName() + ".png' /></button>\n";
					html += "<button type='button' class='" + domination[i].getThirdRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + domination[i].getThirdRune().getIdName() + ".png' /></button>\n";
					html += "<br />\n";
				 } 
				html += "</div>\n";
				html += "<div id='sorcerySecondTreeSelect'>\n";
				
				SorceryEnum[] sorcery = SorceryEnum.values();
				for (int i = 1; i < sorcery.length; i++) { 
				html += "<button type='button' class='" + sorcery[i].getFirstRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + sorcery[i].getFirstRune().getIdName() + ".png' /></button>\n";
				html += "<button type='button' class='" + sorcery[i].getSecondRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + sorcery[i].getSecondRune().getIdName() + ".png' /></button>\n";
				html += "<button type='button' class='" + sorcery[i].getThirdRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + sorcery[i].getThirdRune().getIdName() + ".png' /></button>\n";
				html += "<br />\n";
				} 
				html += "</div>\n";
				html += "<div id='resolveSecondTreeSelect'>\n";
				
				ResolveEnum[] resolve = ResolveEnum.values();
				for (int i = 1; i < resolve.length; i++) {
				html += "<button type='button' class='" + resolve[i].getFirstRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + resolve[i].getFirstRune().getIdName() + ".png' /></button>\n";
				html += "<button type='button' class='" + resolve[i].getSecondRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + resolve[i].getSecondRune().getIdName() + ".png' /></button>\n";
				html += "<button type='button' class='" + resolve[i].getThirdRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + resolve[i].getThirdRune().getIdName() + ".png' /></button>\n";
				html += "<br />\n";
				 }
				html += "</div>\n";
				html += "<div id='inspirationSecondTreeSelect'>\n";
				
				InspirationEnum[] inspiration = InspirationEnum.values();
				for (int i = 1; i < inspiration.length; i++) {
				html += "<button type='button' class='" + inspiration[i].getFirstRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + inspiration[i].getFirstRune().getIdName() + ".png' /></button>\n";
				html += "<button type='button' class='" + inspiration[i].getSecondRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + inspiration[i].getSecondRune().getIdName() + ".png' /></button>\n";
				html += "<button type='button' class='" + inspiration[i].getThirdRune().getIdName() + "'><img src='/lolturm/images/icons/rune/" + inspiration[i].getThirdRune().getIdName() + ".png' /></button>\n";
				html += "<br />\n";
				 }
				html += "</div>\n";
				html += "</div>\n";
				html += "</div>\n";
				html += "</div>\n";
	
				html += "<div id='selected'>\n";
				if (guideBean.getRunes().getRunen().size() == 0) {
					html += "<input type='text' value='' name='keystone' id='keystone0Input'/>\n";
					html += "<input type='text' value='' name='firstRune' id='keystone1Input'/>\n";
					html += "<input type='text' value='' name='secondRune' id='keystone2Input'/>\n";
					html += "<input type='text' value='' name='thirdRune' id='keystone3Input'/>\n";
				
					html += "<input type='text' value='' name='firstSecondTree' id='firstSecondInput'/>\n";
					html += "<input type='text' value='' name='secondSecondTree' id='secondSecondInput'/>\n";
					
					html += "<input type='text' value='' name='keystoneId' id='keystoneId'/>\n";
					html += "<input type='text' value='' name='secondTreeId' id='secondTreeId'/>\n";

				} else {
					html += "<input type='text' value='" + guideBean.getRunes().getRunen().get(0) + "' name='keystone' id='keystone0Input'/>\n";
					html += "<input type='text' value='" + guideBean.getRunes().getRunen().get(1) + "' name='firstRune' id='keystone1Input'/>\n";
					html += "<input type='text' value='" + guideBean.getRunes().getRunen().get(2) + "' name='secondRune' id='keystone2Input'/>\n";
					html += "<input type='text' value='" + guideBean.getRunes().getRunen().get(3) + "' name='thirdRune' id='keystone3Input'/>\n";
			
					html += "<input type='text' value='" + guideBean.getRunes().getRunen().get(4) + "' name='firstSecondTree' id='firstSecondInput'/>\n";
					html += "<input type='text' value='" + guideBean.getRunes().getRunen().get(5) + "' name='secondSecondTree' id='secondSecondInput'/>\n";
				
					html += "<input type='text' value='" + guideBean.getRunes().getRunen().get(6) + "' name='keystoneId' id='keystoneId'/>\n";
					html += "<input type='text' value='" + guideBean.getRunes().getRunen().get(7) + "' name='secondTreeId' id='secondTreeId'/>\n";

				}
				html += "</div>\n";

				html += "<script type='text/javascript' src='/lolturm/js/runes.js'></script>\n";
		return html;
	}
	
	public String getSkillOrderHtml() {
		String html = "";
		
//		html += 	 "<script type='text/javascript' src='/lolturm/js/skillorder.js'></script>\n";

		
		int l = 1;
		int m = 1;
		
		html += "<table id='skillordertable'>\n";
			html += "<tr>\n";
				 for (int j = 0; j <= 18; j++) { 
					html += "<td>\n";
					html += j + "\n"; 
					html += "</td>\n";	
				 } 
			html += "</tr>\n";
	
		for (int i = 0; i < 4; i++) { 
			html += "<tr>\n";
			
			if (i == 0) { 
				html += "<td>\n";
					html += "Q\n";
				html += "</td>\n";
			 } else if (i == 1) { 
			html += "<td>\n";
			html += "W\n";
			html += "</td>\n";
			 } else if (i == 2) { 
			html += "<td>\n";
			html += "E\n";
			html += "</td>\n";
			 } else if (i == 3) { 
			html += "<td>\n";
			html += "R\n";
			html += "</td>\n";
			}
			for (int j = 1; j <= 18; j++) {
			html += "<td>\n";
				for (int k = 1; k <= j; k++) {
					 if (j == k) { 
						 html += "<p>\n";
						 html += "<input id='" + m + "' name='level" + j + "' value='" + l + "' type='radio'/>\n";
						 html += "<label class='" + m + "' for='" + m + "'></label>\n";
						 html += "</p>\n";
						 m++;
					 } 
				}
				html += "</td>\n";
			 } 
			html += "</tr>\n";
			l++;
		}
		html += "</table>\n";
		
//		html += 	 "<script type='text/javascript' src='/lolturm/js/skillorder.js'></script>\n";
		
		
		return html;
	}
}

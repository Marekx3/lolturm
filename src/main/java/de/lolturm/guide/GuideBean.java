package de.lolturm.guide;

import java.util.Date;

import de.lolturm.champion.LTChampionBean;
import de.lolturm.enumeration.KeystoneEnum;
import de.lolturm.enumeration.PositionEnum;
import de.lolturm.itemset.LTItemSetBean;
import de.lolturm.rune.RuneBean;
import de.lolturm.skillorder.SkillOrderBean;
import de.lolturm.userid.UseridBean;

public class GuideBean {
	private Integer id;
	private String guideName;
	private Date date;
	private LTChampionBean champion;
	private UseridBean user;
	private PositionEnum position;
	private SkillOrderBean skillOrder;
	private String skillOrderDesc;
	private RuneBean runes;
	private String runesDesc;
	private Integer bewertung;
	private LTItemSetBean itemSet;
	private String itemSetDesc;
	private String patch;

	public GuideBean() {
		super();
		this.id = 0;
		this.guideName = "";
		this.date = new Date();
		this.champion = new LTChampionBean();
		this.user = new UseridBean();
		this.position = PositionEnum.Null;
		this.skillOrder = new SkillOrderBean();
		this.skillOrderDesc = "";
		this.runes = new RuneBean();
		this.runesDesc = "";
		this.bewertung = 0;
		this.itemSet = new LTItemSetBean();
		this.itemSetDesc = "";
		this.patch = "";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGuideName() {
		return guideName;
	}

	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LTChampionBean getChampion() {
		return champion;
	}

	public void setChampion(LTChampionBean champion) {
		this.champion = champion;
	}

	public UseridBean getUser() {
		return user;
	}

	public void setUser(UseridBean user) {
		this.user = user;
	}

	public PositionEnum getPosition() {
		return position;
	}

	public void setPosition(PositionEnum position) {
		this.position = position;
	}

	public SkillOrderBean getSkillOrder() {
		return skillOrder;
	}

	public void setSkillOrder(SkillOrderBean skillOrder) {
		this.skillOrder = skillOrder;
	}

	public String getSkillOrderDesc() {
		return skillOrderDesc;
	}

	public void setSkillOrderDesc(String skillOrderDesc) {
		this.skillOrderDesc = skillOrderDesc;
	}

	public RuneBean getRunes() {
		return runes;
	}

	public void setRunes(RuneBean runes) {
		this.runes = runes;
	}

	public String getRunesDesc() {
		return runesDesc;
	}

	public void setRunesDesc(String runesDesc) {
		this.runesDesc = runesDesc;
	}

	public Integer getBewertung() {
		return bewertung;
	}

	public void setBewertung(Integer bewertung) {
		this.bewertung = bewertung;
	}

	public LTItemSetBean getItemSet() {
		return itemSet;
	}

	public void setItemSet(LTItemSetBean itemSet) {
		this.itemSet = itemSet;
	}

	public String getItemSetDesc() {
		return itemSetDesc;
	}

	public void setItemSetDesc(String itemSetDesc) {
		this.itemSetDesc = itemSetDesc;
	}

	public String getPatch() {
		return patch;
	}

	public void setPatch(String patch) {
		this.patch = patch;
	}

	public String getChampionImgHtml() {
		String html = "";

		html += "<img src='http://ddragon.leagueoflegends.com/cdn/6.24.1/img/champion/" + this.getChampion().getName()
				+ ".png' class='championicon'/>\n";

		return html;
	}

	public String getItemSetHtml() {
		String html = "";

		for (Integer integer : this.getItemSet().getItemSetArray()) {
			html += "<img src='http://ddragon.leagueoflegends.com/cdn/6.24.1/img/item/" + integer + ".png'>\n";
		}

		return html;
	}

	public String getUserHtml() {
		return this.getUser().getUsername();
	}

	public String getAenderButtonHtml(UseridBean useridBean) {
		String html = "";

		if (useridBean.getUsername() != null && useridBean.getUsername() != "") {
			if (useridBean.getUsername().equals(this.getUser().getUsername())) {
				html += "<a href='/GuideServlet?aendern=Aendern'\n";
				html += "<button>?ndern</button>\n";
				html += "</a>\n";
			} else {
				html += "";
			}
		}

		return html;
	}

	public String getRunenHtml() {
		String runeTooltipp = "\"runeTooltip\"";
		String tooltip = "onmouseenter='showDiv(" + runeTooltipp + ", event)' onmouseleave='hideDiv(" + runeTooltipp + ")' onmousemove='moveDiv(" + runeTooltipp + ", event)'";
		
		String html = "";
		html += "<div id='selectedRunes'>";
		
		html += "<div id='" + KeystoneEnum.getById(this.runes.getKeystoneId()) + "Tree' class='selectedFirstTree'>";
		for (String string : this.runes.getKeystoneRunenA()) {
			html += "<img src='/images/icons/rune/" + string + ".png'" + tooltip + ">\n";
		}
		html += "</div>";
		
		html += "<div id='" + KeystoneEnum.getById(this.runes.getSecondTreeId()) + "Tree' class='selectedSecondTree'>";
		for (String string : this.runes.getSecondTreeRunenA()) {
			html += "<img src='/images/icons/rune/" + string + ".png' " + tooltip + ">\n";
		}
		html += "</div>";
		html += "</div>";
		
		html += "<div id='runesDesc'>";
		html += "" + this.runesDesc;
		html += "</div>";


		return html;
	}
	
	public String getSkillOrderHtml() {
		String html = "";
		html += "<table>";
		
			for (int i = 0; i <= 4; i++) {
				html += "<tr>";
				for(String string : this.skillOrder.getSkillOrder()) {
					if (i == Integer.parseInt(string)) {
						html += "<td>"+string+"</td>";
					} else {
						html += "<td></td>";
					}
					
				}
				html += "</tr>";
			}
			html += "</table>";
			html += "<p>"+this.skillOrderDesc+"</p>";
		return html;
	}
}

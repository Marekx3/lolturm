package de.lolturm.html;

public class headerBean {
	
	private String userid;
	private String currentSite;

	public headerBean() {
		this.userid = "Login";
		this.currentSite = "IndexServlet";
	}

	public String getHeaderHtml() {
		String html = "";
		html += "<nav>\n";
		html += "	<div class='bar'>\n";
		html += "		<p class='guides'><a href='/lolturm/NewGuideServlet'>Guides</a></p>\n";
		html += "		<p class='login'><a href='/lolturm/" + this.currentSite + "?login=" + this.userid + "&comeFrom=" + this.currentSite + "'>" + this.userid + "</a></p>\n";
		
		
		html += "	</div>\n";
		html += "	<img src='/lolturm/images/logo/lol.png' /> <a href='/lolturm/IndexServlet?index=index'>\n";
		html += "	<img src='/lolturm/images/logo/logo.png' class='logo'/></a> <img src='/lolturm/images/logo/turm.png' />\n";
		html += "</nav>\n";
		return html;
	}
	
	public void setUserid(String userid) {
		if (userid == null) {
			this.userid = "Login";
		} else {
			this.userid = userid;
		}
	}

	public void setCurrentSite(String currentSite) {
		this.currentSite = currentSite;
	}
}

package de.lolturm.html;

public class HeaderBean {
	
	private String userid;
	private String currentSite;

	public HeaderBean() {
		this.userid = "Login";
		this.currentSite = "IndexServlet";
	}

	public String getHeaderHtml() {
		String html = "";
		html += "<nav>\n";
		html += "	<div class='bar'>\n";
		html += "		<p class='guides'><a href='/NewGuideServlet'>Guides</a></p>\n";
		html += "		<p class='login'><a href='/" + this.currentSite + "?login=" + this.userid + "&comeFrom=" + this.currentSite + "'>" + this.userid + "</a></p>\n";
		
		
		html += "	</div>\n";
		html += "	<img src='/images/logo/lol.png' /> <a href='/IndexServlet?index=index'>\n";
		html += "	<img src='/images/logo/logo.png' class='logo'/></a> <img src='/images/logo/turm.png' />\n";
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

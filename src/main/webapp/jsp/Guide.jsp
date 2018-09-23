<%@page import="de.lolturm.guide.GuideBean"%>
<%@page import="de.lolturm.userid.UseridBean"%>
<%@page import="de.lolturm.html.PositionBean"%>
<%@page import="de.lolturm.html.HeaderBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<jsp:useBean id="headBean" class="de.lolturm.html.HeadBean" scope="session"/>
<jsp:getProperty property="headHtml" name="headBean" />

	<script src='/js/tooltip.js'></script>

</head>
<body>
	<jsp:useBean id="headerBean" class="de.lolturm.html.HeaderBean" scope="session" />
	<jsp:useBean id="positionBean" class="de.lolturm.html.PositionBean" scope="session" />
	<jsp:useBean id="useridBean" class="de.lolturm.userid.UseridBean" scope="session" />
	<jsp:useBean id="guideBean" class="de.lolturm.guide.GuideBean" scope="session" />
	<jsp:useBean id="comeFromBean" class="de.lolturm.html.ComeFromBean" scope="session" />
	
	<jsp:setProperty property="currentSite" name="headerBean" value="<%=comeFromBean.getCurrentSite()%>"/>
	<jsp:setProperty property="userid" name="headerBean" value="<%=useridBean.getUsername()%>"/>

	<jsp:getProperty property="headerHtml" name="headerBean" />
	
	<div class="container-fluid">
		<div class="guide">
			
			<form action="/GuideServlet" class="guidebewertung">
				<input type="submit" value="up" name="bewertung"><jsp:getProperty property="bewertung" name="guideBean"/><input type="submit" value="down" name="bewertung">
			</form>
			
			<div class="guidebody">
				<div class="guideheader">
					<jsp:getProperty property="championImgHtml" name="guideBean"/>
					<jsp:getProperty property="guideName" name="guideBean"/>
					<jsp:getProperty property="date" name="guideBean"/>
					<jsp:getProperty property="position" name="guideBean"/>
					<jsp:getProperty property="patch" name="guideBean"/>
					<jsp:getProperty property="userHtml" name="guideBean"/>
				</div>
				<div class="guideitemset">
					<h2>Full Build</h2>
					<p>
						<jsp:getProperty property="itemSetHtml" name="guideBean"/>
					</p>
					<jsp:getProperty property="itemSetDesc" name="guideBean"/>
				</div>
				<div class="guideskillorder">
					<h2>Skill Order</h2>
					<jsp:getProperty property="skillOrderHtml" name="guideBean"/>
				</div>
				<div class="guiderunes">
					<h2>Runen</h2>
					<jsp:getProperty property="runenHtml" name="guideBean"/>
				</div>
				<%=guideBean.getAenderButtonHtml(useridBean)%>
			</div>
		</div>
	</div>
	
	<div id="runeTooltip"></div>
	<script type="text/javascript" src="/js/tooltip.js"></script>
	
</body>
</html>
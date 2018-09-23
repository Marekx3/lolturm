<%@page import="de.lolturm.itemset.LTItemBean"%>
<%@page import="de.lolturm.guide.Guides"%>
<%@page import="de.lolturm.guide.GuideBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="de.lolturm.champion.LTChampionBean"%>
<%@page import="de.lolturm.champion.LTChampions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<jsp:useBean id="headBean" class="de.lolturm.html.headBean" scope="session"/>
<jsp:getProperty property="headHtml" name="headBean" />

</head>
<body>
	<jsp:useBean id="headerBean" class="de.lolturm.html.headerBean" scope="session" />
	<jsp:useBean id="positionBean" class="de.lolturm.html.PositionBean" scope="session" />
	<jsp:useBean id="useridBean" class="de.lolturm.userid.UseridBean" scope="session" />
	<jsp:useBean id="guideOverviewBean" class="de.lolturm.html.GuideOverviewBean" scope="session"/>
	<jsp:useBean id="comeFromBean" class="de.lolturm.html.ComeFromBean" scope="session" />
	
	<jsp:setProperty property="currentSite" name="headerBean" value="<%=comeFromBean.getCurrentSite()%>"/>
	<jsp:setProperty property="userid" name="headerBean" value="<%=useridBean.getUsername()%>"/>

	<jsp:getProperty property="headerHtml" name="headerBean" />

	<div class="container-fluid">
		<div class="roles">
			<ul>
				<jsp:getProperty property="guideOverviewHtml" name="guideOverviewBean"/>
			</ul>
		</div>
	</div>
</body>
</html>
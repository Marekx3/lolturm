<%@page import="de.lolturm.html.PositionBean"%>
<%@page import="de.lolturm.guide.SelectBean"%>
<%@page import="de.lolturm.userid.UseridBean"%>
<%@page import="de.lolturm.html.HeaderBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<jsp:useBean id="headBean" class="de.lolturm.html.HeadBean" scope="session"/>
<jsp:getProperty property="headHtml" name="headBean" />

</head>
<body>

	<jsp:useBean id="headerBean" class="de.lolturm.html.HeaderBean" scope="session" />
	<jsp:useBean id="positionBean" class="de.lolturm.html.PositionBean" scope="session" />
	<jsp:useBean id="useridBean" class="de.lolturm.userid.UseridBean" scope="session" />
	<jsp:useBean id="selectBean" class="de.lolturm.guide.SelectBean" scope="session"/>
	<jsp:useBean id="comeFromBean" class="de.lolturm.html.ComeFromBean" scope="session" />
	
	<jsp:setProperty property="currentSite" name="headerBean" value="<%=comeFromBean.getCurrentSite()%>"/>
	<jsp:setProperty property="userid" name="headerBean" value="<%=useridBean.getUsername()%>"/>

	<jsp:getProperty property="headerHtml" name="headerBean" />
	<jsp:getProperty property="positionHtml" name="positionBean" />
	
</body>
</html>
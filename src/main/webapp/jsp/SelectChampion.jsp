<%@page import="de.lolturm.html.SelectChampionBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="de.lolturm.champion.LTChampionBean"%>
<%@page import="de.lolturm.champion.LTChampions"%>
<%@page import="de.lolturm.enumeration.PositionEnum"%>
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
	<jsp:useBean id="selectChampionBean" class="de.lolturm.html.SelectChampionBean" scope="session"/>
	<jsp:useBean id="comeFromBean" class="de.lolturm.html.ComeFromBean" scope="session" />

	<jsp:setProperty property="currentSite" name="headerBean" value="<%=comeFromBean.getCurrentSite()%>"/>
	<jsp:setProperty property="userid" name="headerBean" value="<%=useridBean.getUsername()%>"/>

    <%
        //-------------URL------------------------------
        String requestUrl = request.getRequestURI();
        String requestUrlMod = requestUrl.substring(1, requestUrl.length());
        String[] requestPathItems = requestUrlMod.split("/");
        //----------------------------------------------

        if (!requestPathItems[1].equals(null)) {
            positionBean.setPosition(PositionEnum.getByPosition(requestPathItems[1]));
            selectChampionBean.setPosition(PositionEnum.getByPosition(requestPathItems[1]));
        }
    %>

	<jsp:getProperty property="headerHtml" name="headerBean" />

	<div class="container-fluid">
		<div class="roles">
			<ul>
				<jsp:getProperty property="selectChampionHtml" name="selectChampionBean"/>
			</ul>
		</div>
	</div>
</body>
</html>
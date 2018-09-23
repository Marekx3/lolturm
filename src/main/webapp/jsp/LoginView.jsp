<%@page import="de.lolturm.html.ComeFromBean"%>
<%@page import="de.lolturm.message.MessageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<jsp:useBean id="headBean" class="de.lolturm.html.HeadBean" scope="session"/>
<jsp:getProperty property="headHtml" name="headBean" />

<link rel="stylesheet" href="../css/style.css">
</head>
<body>

	<jsp:useBean id="messageBean" class="de.lolturm.message.MessageBean" scope="session"/>
	<jsp:useBean id="headerBean" class="de.lolturm.html.HeaderBean" scope="session" />
	<jsp:useBean id="useridBean" class="de.lolturm.userid.UseridBean" scope="session" />
	<jsp:useBean id="comeFromBean" class="de.lolturm.html.ComeFromBean" scope="session" />
	
	<jsp:setProperty property="currentSite" name="headerBean" value="<%=comeFromBean.getCurrentSite()%>"/>
	<jsp:setProperty property="userid" name="headerBean" value="<%=useridBean.getUsername()%>"/>


	<jsp:getProperty property="headerHtml" name="headerBean" />

	<div class="container-fluid">
		<div class="registerbox">
			<form action="../LoginServlet">
				<table>
					<tr>
						<td>Username:</td>
						<td colspan="2"><input type="text" name="userid" value="" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td colspan="2"><input type="password" name="password" value="" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" name="zurReg" value="Zur Registrierung" /></td>
						<td><input type="submit" name="login" value="Login" /></td>
					</tr>
					<tr>
						<td colspan="3"><jsp:getProperty name="messageBean" property="message" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
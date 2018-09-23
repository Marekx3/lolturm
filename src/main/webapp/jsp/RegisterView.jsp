<%@page import="de.lolturm.message.MessageBean"%>
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

	<jsp:useBean id="messageBean" class="de.lolturm.message.MessageBean" scope="session"/>
	<jsp:useBean id="headerBean" class="de.lolturm.html.headerBean" scope="session" />
	<jsp:useBean id="useridBean" class="de.lolturm.userid.UseridBean" scope="session" />
	
	<jsp:setProperty property="userid" name="headerBean" value="<%=useridBean.getUsername()%>"/>

	<jsp:getProperty property="headerHtml" name="headerBean" />

	<div class="container-fluid">
		<div class="registerbox">
			<form action="../RegisterServlet">
				<table>
					<tr>
						<td>Username:</td>
						<td colspan="2"><input type="text" name="userid" value="" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password" value="" /></td>
						<td><input type="password" name="passwordConfirm" value="" /></td>

					</tr>
					<tr>
						<td>Email:</td>
						<td colspan="2"><input type="text" name="email" value="" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" name="zumlogin" value="Zum Login" /></td>
						<td><input type="submit" name="register" value="Registrieren" /></td>
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
<%@page import="de.lolturm.guide.GuideBean"%>
<%@page import="de.lolturm.html.NewGuideBean"%>
<%@page import="de.lolturm.html.headBean"%>
<%@page import="de.lolturm.userid.UseridBean"%>
<%@page import="de.lolturm.html.PositionBean"%>
<%@page import="de.lolturm.html.headerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<jsp:useBean id="headBean" class="de.lolturm.html.headBean" scope="session"/>
<jsp:getProperty property="headHtml" name="headBean" />


<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/codemirror.min.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.5.1/css/froala_editor.pkgd.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.5.1/css/froala_style.min.css"
	rel="stylesheet" type="text/css" />

<link rel="stylesheet" href="/css/emoticons.min.css">



<script type='text/javascript' src='/js/skillorder.js'></script>




<style type="text/css">
body {
	text-align: center;
}

section {
	width: 100%;
	margin: auto;
	text-align: left;
}
</style>

<link rel="stylesheet" href="/css/rune.css">
<link rel="stylesheet" href="/css/skillorder.css">

</head>
<body>

	<jsp:useBean id="headerBean" class="de.lolturm.html.headerBean" scope="session" />
	<jsp:useBean id="messageBean" class="de.lolturm.message.MessageBean" />
	<jsp:useBean id="useridBean" class="de.lolturm.userid.UseridBean" scope="session" />
	<jsp:useBean id="newGuideBean" class="de.lolturm.html.NewGuideBean" scope="session"/>
	<jsp:useBean id="positionBean" class="de.lolturm.html.PositionBean" scope="session"/>
	<jsp:useBean id="guideBean" class="de.lolturm.guide.GuideBean" scope="session"/>
	<jsp:useBean id="comeFromBean" class="de.lolturm.html.ComeFromBean" scope="session" />
	
	<jsp:setProperty property="currentSite" name="headerBean" value="<%=comeFromBean.getCurrentSite()%>"/>
	<jsp:setProperty property="userid" name="headerBean" value="<%=useridBean.getUsername()%>" />
	<jsp:setProperty property="guideBean" name="newGuideBean" value="<%=guideBean%>"/>

	<jsp:getProperty property="headerHtml" name="headerBean" />

	<div class="container-fluid">
		<div class="roles">
		
			<form action="/NewGuideServlet" method="POST">
				<table class="editnewguide">
					<tr>
						<td>Guide Name</td>
						<td><input type="text" name="guideName" value="<jsp:getProperty property="guideName" name="guideBean"/>"></td>
					</tr>
					<tr>
						<td>Champion</td>
						<td><jsp:getProperty property="championsSelectHtml" name="newGuideBean"/></td>
					</tr>
					<tr>
						<td>Position</td>
						<td><jsp:getProperty property="positionSelectHtml" name="newGuideBean"/></td>
					</tr>
					<tr>
						<td>Fullbuild</td>
						<td><jsp:getProperty property="fullBuildHtml" name="newGuideBean"/></td>
					</tr>
					<tr>
						<td>Item Set Beschreibung</td>
						<td>
							<section id="editor">
  								<textarea name="itemSetDesc" id="edit" style="margin-top: 30px;">
  									<jsp:getProperty property="itemSetDesc" name="guideBean"/>
  								</textarea>
							</section>
						</td>
					</tr>
					<tr>
						<td>Skill Order</td>
						<td><jsp:getProperty property="skillOrderHtml" name="newGuideBean"/></td>
					</tr>
					<tr>
						<td>Skill Order Beschreibung</td>
						<td>
							<section id="editor">
  								<textarea name="skillOrderDesc" id="edit1" style="margin-top: 30px;">
  									<jsp:getProperty property="skillOrderDesc" name="guideBean"/>
  								</textarea>
							</section>
						</td>
					</tr>
					<tr>
						<td>Runen</td>
						<td><jsp:getProperty property="runenHtml" name="newGuideBean"/></td>
					</tr>
					<tr>
						<td>Runen Beschreibung</td>
						<td>
							<section id="editor">
  								<textarea name="runesDesc" id="edit2" style="margin-top: 30px;">
  									<jsp:getProperty property="runesDesc" name="guideBean"/>
  								</textarea>
							</section>
						</td>
					</tr>
					<tr>
						<td>Patch</td>
						<td><jsp:getProperty property="patchHtml" name="newGuideBean"/></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="submit" name="speichern" value="Speichern"/>
							<input type="submit" name="neu" value="Neu"/>
						</td>
					</tr>
					<tr>
						<td></td>
						<td><jsp:getProperty name="messageBean" property="message" /></td>
					</tr>
				</table>
			</form>

		</div>
	</div>

	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/codemirror.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/mode/xml/xml.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.5.1//js/froala_editor.pkgd.min.js"></script>
	<!-- <script type="text/javascript" src="/js/champions.min.js"></script> -->
	 <script type="text/javascript" src="/js/items.min.js"></script>
	<script type='text/javascript' src='/js/skillorder.js'></script>
	
</body>
	<script>
		$(function() {
			$('#edit').froalaEditor(
				{
					toolbarButtons : [ 'bold', 'italic', 'underline',
							'strikeThrough', '|', 'champions', 'items',
							'|', 'undo', 'redo' ,'leftToRight']
				}
			)
		});
		$(function() {
			$('#edit1').froalaEditor(
				{
					toolbarButtons : [ 'bold', 'italic', 'underline',
							'strikeThrough',
							'|', 'undo', 'redo' ,'leftToRight']
				}
			)
		});
		$(function() {
			$('#edit2').froalaEditor(
				{
					toolbarButtons : [ 'bold', 'italic', 'underline',
							'strikeThrough',
							'|', 'undo', 'redo' ,'leftToRight']
				}
			)
		});
	</script>
</html>
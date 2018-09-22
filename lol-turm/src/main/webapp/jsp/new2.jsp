<%@page import="javax.print.attribute.standard.PresentationDirection"%>
<%@page import="de.lolturm.enumeration.InspirationEnum"%>
<%@page import="de.lolturm.enumeration.ResolveEnum"%>
<%@page import="de.lolturm.enumeration.SorceryEnum"%>
<%@page import="de.lolturm.enumeration.PrecisionEmun"%>
<%@page import="de.lolturm.enumeration.DominationEnum"%>
<%@page import="de.lolturm.enumeration.KeystoneEnum"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript" src="/lolturm/js/jquery-3.2.1.min.js" ></script>
<link rel="stylesheet" href="/lolturm/css/rune.css">
</head>
<body>
	<div id="runesSelect">
		<div id="keystoneTree">
			<div id="keystone">
				<%
					for (KeystoneEnum keystone : KeystoneEnum.values()) {
				%>
					<button id="<%=keystone.getEnglischText()%>Keystone"><%=keystone.getEnglischText()%></button>
				<%
					}
				%>
			</div>
			<div id="keystoneSelect">
			<div id="precisionSelect">
				<% for (PrecisionEmun precision : PrecisionEmun.values()) { %>
					<button id="<%=precision.getFirstRune().getIdName()%>">
						<img src="/lolturm/images/icons/rune/<%=precision.getFirstRune().getIdName()%>.png" />
					</button>
					<button id="<%=precision.getSecondRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=precision.getSecondRune().getIdName()%>.png" /></button>
					<button id="<%=precision.getThirdRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=precision.getThirdRune().getIdName()%>.png" /></button>
					<br />
				<% } %>
			</div>
			<div id="dominationSelect">
				<% for (DominationEnum domination : DominationEnum.values()) { %>
					<button id="<%=domination.getFirstRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=domination.getFirstRune().getIdName()%>.png" /></button>
					<button id="<%=domination.getSecondRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=domination.getSecondRune().getIdName()%>.png" /></button>
					<button id="<%=domination.getThirdRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=domination.getThirdRune().getIdName()%>.png" /></button>
					<br />
				<% } %>
			</div>
			<div id="sorcerySelect">
				<% for (SorceryEnum sorcery : SorceryEnum.values()) { %>
					<button id="<%=sorcery.getFirstRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=sorcery.getFirstRune().getIdName()%>.png" /></button>
					<button id="<%=sorcery.getSecondRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=sorcery.getSecondRune().getIdName()%>.png" /></button>
					<button id="<%=sorcery.getThirdRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=sorcery.getThirdRune().getIdName()%>.png" /></button>
					<br />
				<% } %>
			</div>
			<div id="resolveSelect">
				<% for (ResolveEnum resolve : ResolveEnum.values()) { %>
					<button id="<%=resolve.getFirstRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=resolve.getFirstRune().getIdName()%>.png" /></button>
					<button id="<%=resolve.getSecondRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=resolve.getSecondRune().getIdName()%>.png" /></button>
					<button id="<%=resolve.getThirdRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=resolve.getThirdRune().getIdName()%>.png" /></button>

					<br />
				<% } %>
			</div>
			<div id="inspirationSelect">
				<% for (InspirationEnum inspiration : InspirationEnum.values()) { %>
					<button id="<%=inspiration.getFirstRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=inspiration.getFirstRune().getIdName()%>.png" /></button>
					<button id="<%=inspiration.getSecondRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=inspiration.getSecondRune().getIdName()%>.png" /></button>
					<button id="<%=inspiration.getThirdRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=inspiration.getThirdRune().getIdName()%>.png" /></button>
					<br />
				<% } %>
			</div>
		</div>
		</div>
		<div id="secondTreeTree">
			<div id="secondTree">
				<%
					for (KeystoneEnum keystone : KeystoneEnum.values()) {
				%>
					<button id="<%=keystone.getEnglischText()%>SecondTree"><%=keystone.getEnglischText()%></button>
				<%
					}
				%>
			</div>
		<div id="secondTreeSelect">
			<div id="precisionSecondTreeSelect">
				<% 
				PrecisionEmun[] precision = PrecisionEmun.values();
				for (int i = 1; i < precision.length; i++) { %>
					<button class="<%=precision[i].getFirstRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=precision[i].getFirstRune().getIdName()%>.png" /></button>
					<button class="<%=precision[i].getSecondRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=precision[i].getSecondRune().getIdName()%>.png" /></button>
					<button class="<%=precision[i].getThirdRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=precision[i].getThirdRune().getIdName()%>.png" /></button>
					<br />
				<% } %>
			</div>
			<div id="dominationSecondTreeSelect">
				<% 
				DominationEnum[] domination = DominationEnum.values();
				for (int i = 1; i < domination.length; i++) { %>
					<button class="<%=domination[i].getFirstRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=domination[i].getFirstRune().getIdName()%>.png" /></button>
					<button class="<%=domination[i].getSecondRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=domination[i].getSecondRune().getIdName()%>.png" /></button>
					<button class="<%=domination[i].getThirdRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=domination[i].getThirdRune().getIdName()%>.png" /></button>
					<br />
				<% } %>
			</div>
			<div id="sorcerySecondTreeSelect">
				<% 
				SorceryEnum[] sorcery = SorceryEnum.values();
				for (int i = 1; i < sorcery.length; i++) { %>
					<button class="<%=sorcery[i].getFirstRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=sorcery[i].getFirstRune().getIdName()%>.png" /></button>
					<button class="<%=sorcery[i].getSecondRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=sorcery[i].getSecondRune().getIdName()%>.png" /></button>
					<button class="<%=sorcery[i].getThirdRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=sorcery[i].getThirdRune().getIdName()%>.png" /></button>
					<br />
				<% } %>
			</div>
			<div id="resolveSecondTreeSelect">
				<% 
				ResolveEnum[] resolve = ResolveEnum.values();
				for (int i = 1; i < resolve.length; i++) { %>
					<button class="<%=resolve[i].getFirstRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=resolve[i].getFirstRune().getIdName()%>.png" /></button>
					<button class="<%=resolve[i].getSecondRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=resolve[i].getSecondRune().getIdName()%>.png" /></button>
					<button class="<%=resolve[i].getThirdRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=resolve[i].getThirdRune().getIdName()%>.png" /></button>

					<br />
				<% } %>
			</div>
			<div id="inspirationSecondTreeSelect">
				<% 
				InspirationEnum[] inspiration = InspirationEnum.values();
				for (int i = 1; i < inspiration.length; i++) { %>
					<button class="<%=inspiration[i].getFirstRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=inspiration[i].getFirstRune().getIdName()%>.png" /></button>
					<button class="<%=inspiration[i].getSecondRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=inspiration[i].getSecondRune().getIdName()%>.png" /></button>
					<button class="<%=inspiration[i].getThirdRune().getIdName()%>"><img src="/lolturm/images/icons/rune/<%=inspiration[i].getThirdRune().getIdName()%>.png" /></button>
					<br />
				<% } %>
			</div>
		</div>
		</div>
	</div>
	
	<div id="selected">
		<form>
			<input type="text" value="" name="keystone" id="keystone0Input"/>
			<input type="text" value="" name="firstRune" id="keystone1Input"/>
			<input type="text" value="" name="secondRune" id="keystone2Input"/>
			<input type="text" value="" name="thirdRune" id="keystone3Input"/>
			
			<input type="text" value="" name="firstSecondTree" id="firstSecondInput"/>
			<input type="text" value="" name="secondSecondTree" id="secondSecondInput"/>
			
		</form>
	</div>

<script type="text/javascript" src="/lolturm/js/runes.js"></script>

</body>
</html>
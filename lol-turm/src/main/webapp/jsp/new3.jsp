<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:useBean id="headBean" class="de.lolturm.html.headBean" scope="session"/>
<jsp:getProperty property="headHtml" name="headBean" />
<!-- <script type="text/javascript" src="/lolturm/js/tooltip.js"></script>
 -->
 
<style type="text/css">
</style>
</head>
<body>

<img class="runeImage" alt="" src="/lolturm/images/icons/rune/LETHALTEMPO.png" onmouseenter="showDiv('runeTooltip', event)" onmouseleave="hideDiv('runeTooltip')" onmousemove="moveDiv('runeTooltip', event)"><br>
<img class="runeImage" alt="" src="/lolturm/images/icons/rune/PRESSTHEATTACK.png" onmouseenter="showDiv('runeTooltip', event)" onmouseleave="hideDiv('runeTooltip')" onmousemove="moveDiv('runeTooltip', event)">

<div id="runeTooltip" onclick="hideDiv(this.id)">
aasdasdasdasdasdasd
</div>

<div id="coor"></div>

<script type="text/javascript" src="/lolturm/js/tooltip.js"></script>

</body>
</html>
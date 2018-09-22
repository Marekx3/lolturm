<%@page import="de.lolturm.champion.Champions"%>
<%@page import="de.lolturm.champion.ChampionBean"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

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

<link rel="stylesheet" href="/lolturm/css/emoticons.min.css">

<style type="text/css">
body {
	text-align: center;
}

section {
	width: 81%;
	margin: auto;
	text-align: left;
}
</style>

</head>



<body>
	<!-- <section id="editor">
		<div id='edit' style="margin-top: 30px;"></div>

	</section>
		<button id="saveButton">Save</button> -->
		
		<section id="editor">
			<form action="/lolturm/NewGuideServlet" method="POST">
  				<textarea name="editor_content" id="edit" style="margin-top: 30px;"></textarea>
  				<button>Submit</button>
			</form>
		</section>

	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/codemirror.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.25.0/mode/xml/xml.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.5.1//js/froala_editor.pkgd.min.js"></script>
	<!-- <script type="text/javascript" src="/lolturm/js/champions.min.js"></script> -->
	 <script type="text/javascript" src="/lolturm/js/items.min.js"></script>


	<script type="text/javascript">
		$(function() {
			$('#edit').froalaEditor(
					{
						toolbarButtons : [ 'bold', 'italic', 'underline',
								'strikeThrough', '|', 'champions', 'items',
								'|', 'undo', 'redo' ,'leftToRight']
					})
		});
	</script>

</body>
</html>

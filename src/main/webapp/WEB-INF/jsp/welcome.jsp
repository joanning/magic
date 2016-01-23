<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String extjsRoot = request.getContextPath() +"/resources/extjs4";
String jsRoot = request.getContextPath() +"/resources/js";
%>

 

<link type="text/css" rel="stylesheet" href="<%=extjsRoot%>/extjs-4.2.0/resources/css/ext-all.css" />
<script type="text/javascript" src="<%=extjsRoot%>/extjs-4.2.0/ext-all-debug-w-comments.js"></script>
<script type="text/javascript" src="<%=jsRoot%>/ui/CardSearch.js"></script>
<script type="text/javascript" src="<%=jsRoot%>/ui/Card.js"></script>

<script type="text/javascript" src="<%=jsRoot%>/model/Artist.js"></script>
<script type="text/javascript" src="<%=jsRoot%>/model/Card.js"></script>
<script type="text/javascript" src="<%=jsRoot%>/model/Color.js"></script>
<script type="text/javascript" src="<%=jsRoot%>/model/Rarity.js"></script>
<script type="text/javascript" src="<%=jsRoot%>/model/SubType.js"></script>
<script type="text/javascript" src="<%=jsRoot%>/model/Type.js"></script>

</head>

<body>
<div id="app"></div>


<script type="text/javascript">

 	Ext.create('ui.CardSearch', {
		renderTo: 'app'
	}); 
	 
	
</script>
	
</body>

</html>

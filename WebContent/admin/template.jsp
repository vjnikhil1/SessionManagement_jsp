
<!DOCTYPE html>
<html>
<head>
<title>Admin Panel</title>
<script src="tabcontent.js" type="text/javascript"></script>
<style>
ul.tabs
{
    padding: 6px 0;
    font-size: 0;
    margin:0;
    list-style-type: none;
    text-align: center; /*set to left, center, or right to align the tabs as desired*/
}
        
ul.tabs li
{
    display: inline;
    margin: 0;
    margin-right:2px; /*distance between tabs*/
}
        
ul.tabs li a
{
    font: normal 12px Verdana;
    text-decoration: none;
    position: relative;
    padding: 6px 16px;
    border: 1px solid #CCC;
    border-bottom-color:#AAA;
    color: #000;
    background: #F0F0F0 url(tabbg.gif) repeat-x 0 0;
    border-radius: 2px 2px 0 0;
    outline:none;
}
        
ul.tabs li a:visited
{
    color: #000;
}
        
ul.tabs li a:hover
{
    border: 1px solid #AAA;
    background:#F0F0F0 url(tabbg.gif) 0 -36px repeat-x;
}
        
ul.tabs li.selected a, ul.tabs li.selected a:hover
{
    padding: 9px 16px 6px;
    position: relative;
    top: 0px;
    font-weight:bold;
    background: white url(tabbg.gif) 0 -72px repeat-x;
    border: 1px solid #AAA;
    border-bottom-color: white;
}
        
        
ul.tabs li.selected a:hover
{
    text-decoration: none;
}

div.tabcontents
{
    border: 1px solid #AAA; padding: 30px;
    background-color:#FFF;
    border-radius: 2px;
}
body
{
	background-image:url("../images/back.jpg");
}
</style>
</head>
<body>
<div style="width: 800px; margin: 0 auto; padding: 120px 0 40px;">
<ul class="tabs" data-persist="true">
	<li><a href="template.jsp">Welcome Admin</a></li>
	<li><a href="../ad?Action=insert">Add Medicines</a></li>
	<li><a href="../ad?Action=edit">Edit Medicines</a></li>
	<li><a href="../ad?Action=delete">Delete Medicines</a></li>
	<li><a href="../ad?Action=view">View Login Details</a></li>
	<li><a href="../do?MOD=ALUM&Action=logOff">Logout</a></li>
</ul>
<div class="tabcontents">
 <% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%>
    <%
String conPage=(String)session.getAttribute("content_page");
System.out.print("conPage ==> "+conPage);
if(conPage!=null){
%>
<jsp:include page="<%=conPage%>"/>
<%
}
else {
%>
<div>Sorry we have an issue. Please login again</div>
<%
}
%>
</div>
</div>
</body>
</html>
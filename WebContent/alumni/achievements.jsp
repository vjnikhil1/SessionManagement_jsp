<%@ page import="java.util.*"%>
<%
ArrayList x=(ArrayList)session.getAttribute("achdata");
String id=(String)x.get(0);
String name=(String)x.get(1);
String yop=(String)x.get(2);
String rollno=(String)x.get(3);
%>
<div class="box2">
	<div class="heading">Add Achievements</div>
	<form id="Addach" name="Addach" method="post" action="../do?MOD=ALUM&Action=Subach" enctype="multipart/form-data">
		<input type="hidden" name="aid" value="<%=id %>"/>
		<input type="hidden" name="aname" value="<%=name %>"/>
		<input type="hidden" name="ayop" value="<%=yop %>"/>
		<input type="hidden" name="rollno" value="<%=rollno %>"/>
		<textarea name="achievement" cols="50" rows="5" style="margin: 0px; height: 191px; width: 722px;"></textarea>
		<input type="date" name="date"/><br/>
		<input type="file" name="photo" size="50"/>
		<input type="submit" value="Submit"/>
	</form>
</div>
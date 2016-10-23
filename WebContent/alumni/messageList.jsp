<%
java.util.ArrayList al=(java.util.ArrayList)session.getAttribute("alu-scr");
int size=al.size();
if(size>0){
for(int i=0;i<size;i++){
java.util.ArrayList o=(java.util.ArrayList)al.get(i);
%>
<div class="heading">Scrap Details&nbsp;</div>

<div class="box2">
<b >Message No.&nbsp; <%=i+1%></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Posted at (&nbsp;<b><%=(String)o.get(2)%></b>&nbsp;)<br/>
From :&nbsp;<b><%=(String)o.get(3)%></b>
<hr width="500" align="left"/>
<%=(String)o.get(1)%>
</div><br/>
<%
}//for
}//if
else {
%>
<h3>No Messages Found</h3>
<%
}
%>

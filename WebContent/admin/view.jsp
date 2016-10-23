<h2>Login List</h2>
<%
//String sId=(String)session.getAttribute("s_id");
java.util.ArrayList al=(java.util.ArrayList)session.getAttribute("loginlist");
int size=al.size();
if(size>0){
for(int i=0;i<size;i++){
java.util.ArrayList one=(java.util.ArrayList)al.get(i);
%>
<div class="box1">
<div class="heading"><%=(String)one.get(0)%></div>
<div class="box_content">
<b>Timestamp :</b><%=(String)one.get(1)%><br/>
</div>
</div>
<%
}//for
}//if
else {
%>
<h3>Sorry:-(<br/><br/>
There are no logins.
</h3>
<%
}
%>
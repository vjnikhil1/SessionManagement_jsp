<h2>Alumni List</h2>
<%
//String sId=(String)session.getAttribute("s_id");
java.util.ArrayList al=(java.util.ArrayList)session.getAttribute("aLLL");
int size=al.size();
if(size>0){
for(int i=0;i<size;i++){
java.util.ArrayList one=(java.util.ArrayList)al.get(i);
%>
<div class="box1">
<div class="heading"><%=(String)one.get(0)%></div>
<div class="box_content">
<b>Email: :</b><%=(String)one.get(4)%><br/>
<b>Address :</b><%=(String)one.get(3)%><br/>
<b>Year of Passing - :</b>&nbsp;<%=(String)one.get(2)%> Year - <%=(String)one.get(1)%><br/> 
<b>Mobile No. :</b><%=(String)one.get(5)%><br/>
<b><a href="../do?MOD=ALUM&Action=Scrap&rId=<%=(String)one.get(6)%>">Send Scrap to <%=(String)one.get(0)%></a></b><BR/>
</div>
</div>
<%
}//for
}//if
else {
%>
<h3>Sorry:-(<br/><br/>
There is No Alumni with this Name.
</h3>
<%
}
%>
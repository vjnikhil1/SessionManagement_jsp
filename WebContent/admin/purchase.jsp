<%@page import="java.util.ArrayList"%>
<% ArrayList pd = (ArrayList)session.getAttribute("purchaselist"); %>
<table border=1>
  <tr>
    <th>Name</th>
    <th>Products purchased</th>
  </tr>
  <%for(int i=0;i<pd.size();i++){
	  ArrayList x = (ArrayList)pd.get(i);%>
  <tr>
    <td><%=(String)x.get(0) %></td>
    <td><%=(String)x.get(1) %></td>
  </tr>
  <%} %>
</table>
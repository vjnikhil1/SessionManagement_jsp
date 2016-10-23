<%@page import="java.util.ArrayList"%>
<h2>Items added to cart</h2>
<% java.util.ArrayList s = (ArrayList)session.getAttribute("cartvalues"); %>
<%
for(int i=0;i<s.size();i++){%>
	<%=(String)s.get(i) %><hr><br>
<%
}
%>
<input type="button" href="" name="Proceed to Checkout" value="Proceed to Checkout"/>
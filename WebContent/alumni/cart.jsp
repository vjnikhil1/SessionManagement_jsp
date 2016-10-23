<%@page import="java.util.ArrayList"%>
<h2>Items added to cart</h2>
<% java.util.ArrayList s = (ArrayList)session.getAttribute("cartvalues"); %>
<%
for(int i=0;i<s.size();i++){%>
	<%=(String)s.get(i) %><hr><br>
<%
}
session.setAttribute("cartvalues", s);
%>
<form action="../do?MOD=ALUM&Action=purchase" method="post">
<input type="submit" name="Proceed to Checkout" value="Proceed to Checkout">
</form>
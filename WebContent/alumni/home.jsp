<%java.util.ArrayList al=(java.util.ArrayList)session.getAttribute("medicinelist");
for(int i=0;i<al.size();i++){
	java.util.ArrayList one = (java.util.ArrayList)al.get(i);
%>
<form action="../do?MOD=ALUM&Action=cart" method="post">
<%=(String)one.get(0)%>
<input type="checkbox" name="cart" value="<%=(String)one.get(0)%>" style="align:right;"><br>
<hr>
<%
}
%>
<input type="submit" name="Add to Cart" value="Add to Cart">
</form>
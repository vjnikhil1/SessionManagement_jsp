<%
String r_id=(String)session.getAttribute("idAlu");
java.util.ArrayList us=(java.util.ArrayList)session.getAttribute("ap");
String id=(String)us.get(0);

%>
<div class="heading">Scrap Details</div>
<form action="../do?MOD=ALUM&Action=PostSc&sId=<%=id%>" method="post">
<div class="box2">
  <b>Scrap to Alimni </b>
  <input type="hidden" value="<%=r_id%>" name="rId"/>
  <p>
    <label>
    <textarea name="msg" cols="60" rows="5"></textarea>
    </label>
  </p>
      <input type="submit" value=" Post Message "  align="right"/>
 
</div><br/>
</form>
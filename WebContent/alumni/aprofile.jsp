<%
java.util.ArrayList hm=(java.util.ArrayList)session.getAttribute("a_prof");
%>
<div class="box2">
<div class="heading"><%=(String)hm.get(0)%>'s Profile</div>

<form id="frmEditFriend" name="frmEditFriend" method="post" >

  <table width="423" border="0">
    <tr>
      <td width="117">&nbsp;</td>
      <td width="8">&nbsp;</td>
      <td width="283"></td>
    </tr>
    <tr>
      <td>Alumni Name </td>
      <td>:</td>
      <td><label>
        <%=(String)hm.get(0)%>
      </label></td>
    </tr>
    <tr>
      <td>Branch</td>
      <td>:</td>
      <td><%=(String)hm.get(1)%></td>
    </tr>
    <tr>
      <td>Year of Passing</td>
      <td>:</td>
      <td><%=(String)hm.get(2)%></td>
    </tr>
    <tr>
      <td>Address</td>
      <td>:</td>
      <td><%=(String)hm.get(3)%></td>
    </tr>
    <tr>
      <td>Mobile No. </td>
      <td>&nbsp;</td>
      <td><%=(String)hm.get(5)%></td>
    </tr>
    <tr>
      <td>E-mail</td>
      <td>:</td>
      <td><%=(String)hm.get(4)%></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
</form>
</div>

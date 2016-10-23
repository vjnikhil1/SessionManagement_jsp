<% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  
%>
<%
java.util.HashMap hm=(java.util.HashMap)session.getAttribute("prof");
%>
<div class="box2">
<div class="heading"><%=(String)hm.get("s_name")%>'s Profile </div>

<form id="frmEditFriend" name="frmEditFriend" method="post" action="../do?MOD=STUD&Action=FriendEdit">

  <table width="423" border="0">
    <tr>
      <td width="117">&nbsp;</td>
      <td width="8">&nbsp;</td>
      <td width="283"><input type="hidden" name="sId" value="<%=(String)hm.get("u_id")%>"></td>
    </tr>
    <tr>
      <td>Friend Name </td>
      <td>:</td>
      <td><label>
        <%=(String)hm.get("s_name")%>
      </label></td>
    </tr>
    <tr>
      <td>Branch</td>
      <td>:</td>
      <td><%=(String)hm.get("branch_name")%></td>
    </tr>
    <tr>
      <td>Year</td>
      <td>:</td>
      <td><%=(String)hm.get("year")%></td>
    </tr>
    <tr>
      <td>Address</td>
      <td>:</td>
      <td><%=(String)hm.get("s_address")%></td>
    </tr>
    <tr>
      <td>Mobile No. </td>
      <td>&nbsp;</td>
      <td><%=(String)hm.get("s_mobile")%></td>
    </tr>
    <tr>
      <td>E-mail</td>
      <td>:</td>
      <td><%=(String)hm.get("s_email")%></td>
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

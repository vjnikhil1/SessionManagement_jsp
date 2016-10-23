<%
java.util.ArrayList hm=(java.util.ArrayList)session.getAttribute("editAlu");
%>
<div class="box2">
<div class="heading">Edit <%=(String)hm.get(1)%>'s Profile </div>

<form id="frmEditFriend" name="frmEditFriend" method="post" action="../do?MOD=ALUM&Action=AlumEdit">

  <table width="423" border="0">
    <tr>
      <td width="117">&nbsp;</td>
      <td width="8">&nbsp;</td>
      <td width="283"><input type="hidden" name="aId" value="<%=(String)hm.get(0)%>"></td>
    </tr>
    <tr>
      <td>Alumni Name </td>
      <td>:</td>
      <td><label>
        <input type="text" name="aName"  size="40" value="<%=(String)hm.get(1)%>"/>
      </label></td>
    </tr>
    <tr>
      <td>Branch</td>
      <td>:</td>
      <td><select name="bname">
        <option value="Computer">Computer Engineering</option>
        <option value="Mech">Mech Engineering</option>
        <option value="IT">Information Technology</option>
        <option value="Prod">Production Engineering</option>
      </select></td>
    </tr>
    <tr>
      <td>Year od Passing </td>
      <td>:</td>
      <td><select name="yop">
        <%
		for(int i=1980;i<2009;i++){
		%>
        <option value="<%=i%>"><%=i%></option>
        <%
		}
		%>
      </select></td>
    </tr>
    <tr>
      <td>Address</td>
      <td>:</td>
      <td><textarea name="add1" cols="37" id="address"><%=(String)hm.get(4)%></textarea></td>
    </tr>
    <tr>
      <td>Mobile No. </td>
      <td>&nbsp;</td>
      <td><input name="mobile" type="text" id="mobile"  size="30" value="<%=(String)hm.get(5)%>"/></td>
    </tr>
    <tr>
      <td>E-mail</td>
      <td>:</td>
      <td><input name="email" type="text" id="email"  size="40" value="<%=(String)hm.get(6)%>"/></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td><label>
        <div align="right">
          <input type="reset" name="Submit2" value="Reset" />
          </div>
      </label></td>
      <td>&nbsp;</td>
      <td><label>																		
        <input  type="submit" value="Edit <%=(String)hm.get(1)%>'s Profile"  />
      </label></td>
    </tr>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </table>
</form>
</div>

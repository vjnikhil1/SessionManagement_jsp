<div class="box2">
<div class="heading">Find a Alumni </div>

<form id="frmFindFriend" name="frmFindFriend" method="post" action="../do?MOD=ALUM&Action=FindA">
  <table width="423" border="0">
    <tr>
	
      <td width="117">&nbsp;</td>
      <td width="8">&nbsp;</td>
      <td width="283">&nbsp;</td>
    </tr>
    <tr>
      <td>Alumni Name </td>
      <td>:</td>
      <td><label>
        <input type="text" name="aName"  size="40"/>
      </label></td>
    </tr>
    <tr>
      <td>Y.O.P</td>
      <td>:</td>
      <td><label>
        <select name="yop">
          <%
		for(int i=1980;i<2009;i++){
		%>
          <option value="<%=i%>"><%=i%></option>
          <%
		}
		%>
        </select>
      </label></td>
    </tr>
    <tr>
      <td>Branch </td>
      <td>:</td>
      <td><select name="bname">
        <option value="Computer">Computer Engineering</option>
        <option value="Mech">Mech Engineering</option>
        <option value="IT">Information Technology</option>
        <option value="Prod">Production Engineering</option>
      </select></td>
    </tr>
    <tr>
      <td><label>
        <div align="right">
          <input type="reset" name="Submit2" value="Reset" />
          </div>
      </label></td>
      <td>&nbsp;</td>
      <td><label>																		
        <input  type="submit" value="Find Alumni "  />
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

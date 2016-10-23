

import java.sql.*;
import java.io.IOException;
import java.util.*;

public class DBConnect {

	public static Connection prepareConn()   {
			System.out.println ("In prepareConn().....");
			Connection con=null;
			try {
    				Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medicalmgmt","root","root");
				}
				catch (Exception ex) {
					System.out.println ("Exception in preapreConn()..."+ex);
				}
				return con;	
		}//prepareConn

	public static void closeConn(Connection con) throws SQLException,IOException {
		System.out.println ("In closeConn().....");
			if(con!=null)
				con.close();
		}//closeConn
	
	public static int updateQuery(String sql)  {
		int update=0;
		try{
			Connection con=prepareConn();
			Statement stmt=con.createStatement();
			update=stmt.executeUpdate(sql);
			closeConn(con);				
		}catch(Exception e){
			System.out.println ("Exception in updateQuery()..."+e);
		}
		return update;
		}//updateQuery	
	
	//-----------------------------------------------------------------------
	public static boolean isValid(String sql)  {
		boolean f=false;
		try{
			Connection con=prepareConn();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()==true){
				f=true;
			}else {
				f=false;
			}
			closeConn(con);				
		}catch(Exception e){
			System.out.println ("Exception in updateQuery()..."+e);
		}
		return f;
		}//updateQuery
	//-----------------------------------------------------------------------
	
	public static HashMap userLogin(String sql)  {
		ResultSet rs=null;
		HashMap hm=new HashMap();
		try {
				Connection con=prepareConn();
				Statement stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					hm.put("s_id",rs.getInt(1)+"");
					hm.put("s_name",rs.getString(2));
					hm.put("s_email",rs.getString(3));
				}
				closeConn(con);    
			}
			catch (Exception ex) {
				System.out.println ("Exception in executeQuery()...."+ex);
			}
		return hm;
	}
	//---------------------------------------------------------------------------
	public static HashMap userEdit(String sql)  {
		ResultSet rs=null;
		HashMap hm=new HashMap();
		try {
				Connection con=prepareConn();
				Statement stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					hm.put("s_id",rs.getInt(1)+"");
					hm.put("s_name",rs.getString(2));
					hm.put("s_pass",rs.getString(3));
					hm.put("branch_name",rs.getString(4));
					hm.put("year",rs.getString(5));
					hm.put("s_address",rs.getString(6));
					hm.put("s_mobile",rs.getString(7));
					hm.put("s_email",rs.getString(8));
				}
				closeConn(con);    
			}
			catch (Exception ex) {
				System.out.println ("Exception in executeQuery()...."+ex);
			}
		return hm;
	}//userEdit		
	//-----------------------------------------------------------------------------
	public static ArrayList friendlist(String sql)  {
		ResultSet rs=null;
		ArrayList all=new ArrayList();
		try {
				Connection con=prepareConn();
				Statement stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					ArrayList one=new ArrayList();
					one.add(rs.getInt(1)+"");
					one.add(rs.getString(2));
					one.add(rs.getString(3));
					one.add(rs.getString(4));
					one.add(rs.getString(5));
					one.add(rs.getString(6));
					one.add(rs.getString(7));
					all.add(one);
				}
				closeConn(con);    
			}
			catch (Exception ex) {
				System.out.println ("Exception in executeQuery()...."+ex);
			}
		return all;
	}
	//-----------------------------------------------------------------------------
	public static ArrayList viewAlumniProfile(String sql)  {
		ResultSet rs=null;
		ArrayList one=new ArrayList();
		try {
				Connection con=prepareConn();
				Statement stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					one.add(rs.getString(1));
					one.add(rs.getString(2));
					one.add(rs.getString(3));
					one.add(rs.getString(4));
					one.add(rs.getString(5));
					one.add(rs.getString(6));
				}
				closeConn(con);    
			}
			catch (Exception ex) {
				System.out.println ("Exception in executeQuery()...."+ex);
			}
		return one;
	}
	
	//--------------------------------------------------------------------------------
	public static ArrayList alumniList(String sql)  {
		ResultSet rs=null;
		ArrayList all=new ArrayList();
		try {
				Connection con=prepareConn();
				Statement stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					ArrayList one=new ArrayList();
					one.add(rs.getInt(1)+"");
					one.add(rs.getString(2));
					one.add(rs.getString(3));
					one.add(rs.getString(4));
					one.add(rs.getString(5));
					one.add(rs.getString(6));
					//one.add(rs.getString(7));
					all.add(one);
				}
				closeConn(con);    
			}
			catch (Exception ex) {
				System.out.println ("Exception in executeQuery()...."+ex);
			}
		return all;
	}
	//--------------------------------------------------------------------------------
	
	public static ArrayList viewScrap(String sql)  {
		ResultSet rs=null;
		ArrayList all=new ArrayList();
		try {
				Connection con=prepareConn();
				Statement stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					ArrayList one=new ArrayList();
					one.add(rs.getInt(1));
					one.add(rs.getString(2));
					one.add(rs.getString(3));
					one.add(rs.getString(4));
					all.add(one);
				}
				closeConn(con);    
			}
			catch (Exception ex) {
				System.out.println ("Exception in executeQuery()...."+ex);
			}
		return all;
	}
	//----------------------------------------------------------------------------
	public static ArrayList loginAlumni(String sql)  {
		ResultSet rs=null;
		ArrayList all=new ArrayList();
		try {
				Connection con=prepareConn();
				Statement stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					all.add(rs.getInt(1)+"");
					all.add(rs.getString(2));
				}
				closeConn(con);    
			}
			catch (Exception ex) {
				System.out.println ("Exception in executeQuery()...."+ex);
			}
		return all;
	}
	//------------------------------------------------------------------------------
	public static ArrayList viewInvitation(String sql)  {
		ResultSet rs=null;
		ArrayList all=new ArrayList();
		try {
				Connection con=prepareConn();
				Statement stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					ArrayList one=new ArrayList();
					one.add(rs.getString(1));
					one.add(rs.getString(2));
					one.add(rs.getString(3));
					all.add(one);
				}
				closeConn(con);    
			}
			catch (Exception ex) {
				System.out.println ("Exception in executeQuery()...."+ex);
			}
		return all;
	}
	//--------------------------------------------------------------------------
	public static ArrayList editAlumni(String sql)  {
		ResultSet rs=null;
		ArrayList one=new ArrayList();
		try {
				Connection con=prepareConn();
				Statement stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					//ArrayList one=new ArrayList();
					one.add(rs.getInt(1)+"");
					one.add(rs.getString(2));
					one.add(rs.getString(3));
					one.add(rs.getString(4));
					one.add(rs.getString(5));
					one.add(rs.getString(6));
					one.add(rs.getString(7));
					
				}
				closeConn(con);    
			}
			catch (Exception ex) {
				System.out.println ("Exception in executeQuery()...."+ex);
			}
		return one;
	}
	//----------------------------------------------------------------------------
	public static ArrayList alumlist(String sql)  {
		ResultSet rs=null;
		ArrayList all=new ArrayList();
		try {
				Connection con=prepareConn();
				Statement stmt=con.createStatement();
				rs=stmt.executeQuery(sql);
				while(rs.next()){
					ArrayList one=new ArrayList();
					one.add(rs.getString(1));
					one.add(rs.getString(2));
					one.add(rs.getString(3));
					one.add(rs.getString(4));
					one.add(rs.getString(5));
					one.add(rs.getString(6));
					one.add(rs.getInt(7)+"");
					all.add(one);
				}
				closeConn(con);    
			}
			catch (Exception ex) {
				System.out.println ("Exception in executeQuery()...."+ex);
			}
		return all;
	}
	//--------------------------------------------------------------------------
}//class
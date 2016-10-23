

import javax.servlet.http.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.*;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;

import java.io.*;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
@MultipartConfig(maxFileSize = 16177215)

public class AluminiServlet extends HttpServlet {
	
	//
	private String driverClass="";
	private String url="";
	private String uname="";
	private String upass="";
	private String http_url="";
	ArrayList<String> b=new ArrayList<String>();
	
	public void init(){
		System.out.println ("In init()......");
	}
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException {
			try {
    			process(req,res);							
			}
			catch (Exception ex) {
			}	
			
		}//doPost
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException {
			try {
    			process(req,res);							
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}//doGet
	
	public void process(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException,Exception {
			
			HttpSession session=req.getSession();
			RequestDispatcher rd=null;
			
			String 	mod=req.getParameter("MOD");
			String action=req.getParameter("Action");
			//module selection code
			//-------------------------------------------------------------------------------------
			if(mod.equals("ALUM")){
				if(action.equals("cart")){
					String[] a=req.getParameterValues("cart");
					//System.out.println(a[0]+a[1]);
					ArrayList<String> c = new ArrayList<String>(Arrays.asList(a));
					b.addAll(c);
					session.setAttribute("cartvalues", b);
					session.setAttribute("content_page", "cart.jsp");
					res.sendRedirect("alumni/template.jsp");
				}
				if(action.equals("Addach")){
					String id=req.getParameter("id");
					String sql="select * from alumni_details where id="+id;
					ResultSet rs=null;
					ArrayList one=new ArrayList();
					try{
						Connection con=DBConnect.prepareConn();
						Statement stmt=con.createStatement();
						rs=stmt.executeQuery(sql);
						while(rs.next()){
							//ArrayList one=new ArrayList();
							one.add(rs.getInt(1)+"");
							one.add(rs.getString(2));
							one.add(rs.getString(5));
							one.add(rs.getString(9));
						}
						DBConnect.closeConn(con);   
						
					}
					catch(Exception e){
					}
					session.setAttribute("achdata", one);
					session.setAttribute("content_page", "achievements.jsp");
					res.sendRedirect("alumni/template.jsp");
				}
				if(action.equals("Reg")){
					System.out.println("hello");
					String name=req.getParameter("name");
					String pass=req.getParameter("pass");
					String bname=req.getParameter("bname");
					String yop=req.getParameter("yop");
					String add=req.getParameter("add");
					String mob=req.getParameter("mob");
					String email=req.getParameter("email");
					String rollno=req.getParameter("rollno");
					String sql="insert into alumni_details (name,pass,branch,yop,add1,email,mob,rollno) "+
						"values('"+name+"','"+pass+"','"+bname+"','"+yop+"','"+add+"','"+email+"','"+mob+"','"+rollno+"')";
					System.out.println (sql);
					int up=DBConnect.updateQuery(sql);
					//res.sendRedirect("login.jsp");		
					if(up>0)
						res.sendRedirect("login.jsp");
				}
				else if(action.equals("Login")){
					Connection con = DBConnect.prepareConn();
					String name=req.getParameter("userName");
					String pass=req.getParameter("userPass");
					String sql="select id,name from user_details where name='"+name+"' and pass='"+pass+"'";
					System.out.println (sql);
					ArrayList a=DBConnect.loginAlumni(sql);
					if(a.size()>0){
					String t = (String)a.get(1);
					DBConnect.updateQuery("insert into login_details (name,timestamp) values('"+t+"',NOW());");
					ResultSet rs=null;
					ArrayList all=new ArrayList();
					try {
							Statement stmt=con.createStatement();
							rs=stmt.executeQuery("select * from medicines");
							while(rs.next()){
								ArrayList one=new ArrayList();
								one.add(rs.getString(2));
								//System.out.println((String)one.get(0));
								all.add(one);
								//System.out.println(one.get(0));
							}
							DBConnect.closeConn(con);  
							session.setAttribute("medicinelist", all);
						}
						catch (Exception ex) {
							System.out.println ("Exception in executeQuery()...."+ex);
						}
					session.setAttribute("name", a);
					session.setAttribute("content_page","home.jsp");
					res.sendRedirect("alumni/template.jsp");		
					}
					else
					{
						res.sendRedirect("login.jsp");
					}
				}
				else if(action.equals("Store")){
					session.setAttribute("content_page","home.jsp");
					res.sendRedirect("alumni/template.jsp");
				}
				else if(action.equals("View")){
					int id=Integer.parseInt(req.getParameter("id"));
					String sql="select sid,msg,date,fro from alu_msg_details where rid="+id;
					ArrayList al=DBConnect.viewScrap(sql);	
					session.setAttribute("alu-scr",al);
					session.setAttribute("content_page","messageList.jsp");
					res.sendRedirect("alumni/template.jsp");
				}
				else if(action.equals("logOff")){
					System.out.println ("alumni logoff--------------");
					session.setAttribute("content_page", null);
					res.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
				     res.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
				     res.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
				     res.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
					session.invalidate();
				     res.sendRedirect("login.jsp");		
				}
			}
		}
}
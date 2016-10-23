

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.InputStream;*/

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
		HttpSession session = req.getSession();
		String action = req.getParameter("Action");
		if(action.equals("view")){
			ResultSet rs=null;
			ArrayList all=new ArrayList();
			try {
					Connection con = DBConnect.prepareConn();
					Statement stmt=con.createStatement();
					rs=stmt.executeQuery("select * from login_details");
					while(rs.next()){
						ArrayList one=new ArrayList();
						one.add(rs.getString(2));
						one.add(rs.getString(3));
						//System.out.println((String)one.get(0));
						all.add(one);
					}
					DBConnect.closeConn(con);  
					session.setAttribute("loginlist", all);
				}
				catch (Exception ex) {
					System.out.println ("Exception in executeQuery()...."+ex);
				}
			session.setAttribute("content_page","view.jsp");
			res.sendRedirect("admin/template.jsp");		
		}
		if(action.equals("insertmedicine")){
			Connection con=DBConnect.prepareConn();
			String name=req.getParameter("MedicineName");
			String sql="insert into medicines (medicinename) values('"+name+"')";
			System.out.println (sql);
			int a=DBConnect.updateQuery(sql);
			session.setAttribute("content_page","messageadd.jsp");
			res.sendRedirect("admin/template.jsp");		
		}
		if(action.equals("deletemedicine")){
			Connection con=DBConnect.prepareConn();
			String name=req.getParameter("MedicineName");
			String sql="delete from medicines where medicinename='"+name+"'";
			System.out.println (sql);
			int a=DBConnect.updateQuery(sql);
			session.setAttribute("content_page","messageadd.jsp");
			res.sendRedirect("admin/template.jsp");		
		}
		if(action.equals("insert")){
			session.setAttribute("content_page", "insert.jsp");
			res.sendRedirect("admin/template.jsp");
		}
		if(action.equals("delete")){
			session.setAttribute("content_page", "delete.jsp");
			res.sendRedirect("admin/template.jsp");
		}
		if(action.equals("edit")){
			session.setAttribute("content_page", "edit.jsp");
			res.sendRedirect("admin/template.jsp");
		}
		if(action.equals("editmedicine")){
			String old = req.getParameter("OldMedicineName");
			String newm = req.getParameter("NewMedicineName");
			Connection con = DBConnect.prepareConn();
			String sql = "UPDATE medicines SET medicinename='"+newm+"' WHERE medicinename='"+old+"';";
			System.out.println(sql);
			if(DBConnect.updateQuery(sql)<1){
				session.setAttribute("content_page", "error.jsp");
				res.sendRedirect("admin/template.jsp");
			}
			else{
				session.setAttribute("content_page", "messageadd.jsp");
				res.sendRedirect("admin/template.jsp");
			}
		}
		else if(action.equals("Login")){
			ResultSet rs=null;
			Connection con = DBConnect.prepareConn();
			Statement s;
			try {
				s = con.createStatement();
				String mail=req.getParameter("userName");
				String pass=req.getParameter("userPass");
				rs = s.executeQuery("select * from admin_details where admin_name='"+mail+"' and admin_pass='"+pass+"'");
				if(rs.next()){
					session.setAttribute("adId", rs.getInt(1));
					session.setAttribute("content_page", "insert.jsp");
					res.sendRedirect("admin/template.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		doPost(req, res);
	}
}

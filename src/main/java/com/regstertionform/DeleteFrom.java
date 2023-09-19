package com.regstertionform;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteFrom extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		String myemail=req.getParameter("email1");
		String mypwd=req.getParameter("pass1");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai_college","root","1243");
	PreparedStatement ps=con.prepareStatement("delete from emp where email=? and password=?");
	ps.setString(1, myemail);
	ps.setString(2, mypwd);
 int value=ps.executeUpdate();
		if(value >0) {
			out.print("<h1 style='color : green'>Successfully Deleted...</h3>");
			RequestDispatcher rd=req.getRequestDispatcher("/removedata.jsp");
			rd.include(req, resp);
		}
		else {
			out.print("<h1 style='color : red'>Email and password not didnt Match...</h3>");
			RequestDispatcher rd=req.getRequestDispatcher("/removedata.jsp");
			rd.include(req, resp);
		}
		}
		catch(Exception e){
			e.printStackTrace();
			out.print("<h1 style='color : green'>"+e.getMessage()+"</h3>");
			RequestDispatcher rd=req.getRequestDispatcher("/removedata.jsp");
			rd.include(req, resp);
			
		}
	}

}

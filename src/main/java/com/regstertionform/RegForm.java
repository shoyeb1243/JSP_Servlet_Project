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

@WebServlet("/regsterForm")
public class RegForm extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String myname = req.getParameter("name1");
		String myemail = req.getParameter("email1");
		String mypwd = req.getParameter("pass1");
		String mygender = req.getParameter("gender1");
		String mycity = req.getParameter("city1");
		String mycontry = req.getParameter("contry1");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai_college", "root", "1243");
			PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?,?,?,?)");
			ps.setString(1, myname);
			ps.setString(2, myemail);
			ps.setString(3, mypwd);
			ps.setString(4, mygender);
			ps.setString(5, mycity);
			ps.setString(6, mycontry);
			int value = ps.executeUpdate();
			if (value > 0) {
				resp.setContentType("text/html");
				out.print("<h3 style='color : green'>Successfully Insertd Value In Database</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.include(req, resp);
			} else {
				resp.setContentType("text/html");
				out.print("<h3 style='color : red'>Not Insertd Value In Database</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			resp.setContentType("text/html");
			out.print("<h3 style='color : red'>Check This Program  : " + e.getMessage() + "</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.include(req, resp);
		}
	}

}

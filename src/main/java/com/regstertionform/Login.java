package com.regstertionform;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginfrom")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String myemail = req.getParameter("email1");
		String mypwd = req.getParameter("pass1");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/center", "root", "1243");
			PreparedStatement ps = con.prepareStatement("select student where email=? and password=?");
			ps.setString(1, myemail);
			ps.setString(2, mypwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				HttpSession hs = req.getSession();
				hs.setAttribute("session", rs.getString("name"));
				RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
				rd.include(req, resp);
			} else {
				out.print("<h1 style='color : red'> Email And Password Not Matched...</h1>");
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.print("<h1 style='color : red'>Exception :" + e.getMessage() + "</h1>");
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.include(req, resp);
		}
	}

}

package myPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginForm")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String myemail = req.getParameter("email1");
		String mypass = req.getParameter("pass1");

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

try {
			// load and Register Driver
	Class.forName("com.mysql.cj.jdbc.Driver");
			// Connection provide and jar file
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/study", "root", "Self@2124");

			// prepared statement
	PreparedStatement ps = con.prepareStatement("Select * from register where email=? and password=?");
			ps.setString(1, myemail);
			ps.setString(2, mypass);

	ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				HttpSession session=req.getSession();
				
			   session.setAttribute("Session_name",rs.getString("name"));
		 //	   session.setAttribute("Session_Emaill",rs.getString("email"));
        //      session.setAttribute("Session_Pass", rs.getString("password"));
               session.setAttribute("Session_gender",rs.getString("gender"));
              session.setAttribute("Session_City", rs.getString("city"));
               
				RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
				rd.include(req, resp);
			} 
	        else {

				out.println("<h3 style='color:red'>Email id and Password not match</h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
				rd.include(req, resp);

			}

		}
catch (Exception e) {

			e.printStackTrace();

			out.println("<h3 style='color:red'>" + e.getMessage() + "</h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.include(req, resp);
		}

	}
}

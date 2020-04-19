package BillCreate;

import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 


import BillCreate.BillDataBaseConnect; 
// Servlet Name 
@WebServlet("/BillServlet") 
public class BillServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L; 

	protected void doPost(HttpServletRequest request, 
HttpServletResponse response) 
		throws ServletException, IOException 
	{ 
		try { 

			
			Connection con = BillDataBaseConnect.initializeDatabase(); 

			
			PreparedStatement st = con 
				.prepareStatement("insert into billtable values(?,?,?,?,?,?)"); 

			st.setInt(1, Integer.valueOf(request.getParameter("Bno")));
			st.setDate(2, java.sql.Date.valueOf(request.getParameter("date")));
			st.setDouble(3, Double.valueOf(request.getParameter("HCid"))); 
			st.setDouble(4, Double.valueOf(request.getParameter("DCid"))); 
			st.setDouble(5, Double.valueOf(request.getParameter("OCid")));
			st.setDouble(6, Double.valueOf(request.getParameter("TBid")));
			
			
			st.executeUpdate(); 

			
			st.close(); 
			con.close(); 

			 
			PrintWriter out = response.getWriter(); 

			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Bill Added Successfully' ,  '' ,  'success' );");
			out.println("});");
			out.println("</script>"); 
			
			RequestDispatcher rd = request.getRequestDispatcher("BillDetails.jsp");
			rd.include(request, response);
		
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
} 

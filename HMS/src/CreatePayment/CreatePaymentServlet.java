package CreatePayment;

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

// Import Database Connection Class file 
import CreatePayment.PaymentDatabase; 

// Servlet Name 
@WebServlet("/CreatePaymentServlet") 

public class CreatePaymentServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L; 

	protected void doPost(HttpServletRequest request, 
HttpServletResponse response) 
		throws ServletException, IOException 
	{ 
		try { 
			
			
			Connection con1 = PaymentDatabase.initializeDatabase(); 

			
			PreparedStatement st = con1 
				.prepareStatement("insert into payment values(?,?,?,?,?)"); 

			 
			st.setString(1, String.valueOf(request.getParameter("Vnumber"))); 
			st.setString(2, String.valueOf(request.getParameter("Jnumber"))); 
			st.setDouble(3, Double.valueOf(request.getParameter("Tpayment"))); 
			st.setDouble(4, Double.valueOf(request.getParameter("Dpayment"))); 
			st.setDouble(5, Double.valueOf(request.getParameter("balance"))); 
			
			
			
			
			st.executeUpdate(); 

			
			st.close(); 
			con1.close(); 

			 
			PrintWriter out = response.getWriter(); 

			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( ' Create payment Successfully' ,  '' ,  'success' );");
			out.println("});");
			out.println("</script>"); 
			
			RequestDispatcher rd = request.getRequestDispatcher("Payment.jsp");
			rd.include(request, response);
		
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
} 



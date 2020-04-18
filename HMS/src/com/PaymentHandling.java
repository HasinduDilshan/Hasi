package com;

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

import dbConnection.PaymentDB;

@WebServlet("/PaymentHandling")
public class PaymentHandling extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			Connection con = PaymentDB.initializeDatabase();

			PreparedStatement st = con.prepareStatement("insert into PaymentTable values(?,?,?,?,?,?,?,?)");

			st.setString(1, String.valueOf(request.getParameter("PaymentId")));
			st.setString(2, String.valueOf(request.getParameter("Customer_name")));
			st.setString(3, String.valueOf(request.getParameter("Payment_method")));
			st.setString(4, String.valueOf(request.getParameter("card_no")));
			st.setDate(5, java.sql.Date.valueOf(request.getParameter("date")));
			st.setString(6, String.valueOf(request.getParameter("country")));
			st.setString(7, String.valueOf(request.getParameter("zip")));
			st.setDouble(8, Double.valueOf(request.getParameter("bill")));
			System.out.println(st);
			st.executeUpdate();

			st.close();
			con.close();

			PrintWriter out = response.getWriter();

			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( ' Payment Added Successfully' ,  '' ,  'success' );");
			out.println("});");
			out.println("</script>");

			RequestDispatcher rd = getServletContext().getRequestDispatcher("/CPdetails.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

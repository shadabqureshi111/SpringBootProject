package com.csm.operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csm.dao.EmpDao;
import com.csm.model.Emp;

@WebServlet("/Insert")
public class Insert extends HttpServlet {
	
//	private String url = "jdbc:mysql://localhost:3306/shadab";
//	private String username = "root";
//	private String password = "root";
//	Connection con;
//	PreparedStatement stmt;
//	public void init(ServletConfig config) throws ServletException {
//		try 
//			{
//				Class.forName("com.mysql.jdbc.Driver");
//				con = DriverManager.getConnection(url,username,password);
//			} 
//		catch (ClassNotFoundException e) 
//			{
//				e.printStackTrace();
//			} 
//		catch (SQLException e) 
//			{
//				e.printStackTrace();
//			}
//
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		List<Emp> allEmployees = EmpDao.getAllEmployees();
		request.setAttribute("data",allEmployees);
		RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
			Long id = Long.parseLong(req.getParameter("id"));
	    	String name = req.getParameter("name");
	    	Double salary = Double.parseDouble(req.getParameter("salary"));
		
		Emp e=new Emp();
		e.setId(id);
		e.setName(name);
		e.setSalary(salary);
		
		
		int status=EmpDao.save(e);
		if(status>0){
			out.print("<p>Record saved successfully!</p>");
			List<Emp> allEmployees = EmpDao.getAllEmployees();
			req.setAttribute("data",allEmployees);
			RequestDispatcher dispatcher = req.getRequestDispatcher("fetch.jsp");
			dispatcher.forward(req, res);
			//req.getRequestDispatcher("index.html").include(req, res);
			//req.setAttribute("message", "Error inserting record");
			//res.sendRedirect("Fetch");
	        //dispatcher.forward(req, res);
		}else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	
	   }
}

package com.csm.operations;
//package com.csm.operations;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.csm.dao.EmpDao;
//import com.csm.model.Emp;
//
///**
// * Servlet implementation class EditDataForm
// */
//@WebServlet("/UpdateDataForm")
//public class EditDataForm extends HttpServlet {
//  
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//		out.println("<h1>Update Employee</h1>");
//		String sid=request.getParameter("id");
//		int id=Integer.parseInt(sid);
//		
//		Emp e=EmpDao.getEmployeeById(id);
//		
//		out.print("<form action='EditServlet2' method='post'>");
//		out.print("<table>");
//		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");
//		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
//		out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getSalary()+"'/></td></tr>");
//		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
//		out.print("</table>");
//		out.print("</form>");
//		
//		out.close();
//	}
//
//}

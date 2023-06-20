//package com.csm.operations;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
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
// * Servlet implementation class Fetch
// */
//@WebServlet("/Fetch")
//public class Fetch extends HttpServlet {
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
//	{
//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//		out.println("<a href='insert.jsp' >Add New Employee</a>");
//		out.println("<h1>Employee List</h1>");
//		
//		List<Emp> list=EmpDao.getAllEmployees();
//		
//		out.print("<table border='2px solid black' width='100%' style='border-collapse: collapse;' >");
//		out.print("<tr><th>Id</th><th>Name</th><th>Salary</th><th>Edit</th><th>Delete</th></tr>");
//		for(Emp e:list){
//			out.print("<tr align='center'><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getSalary()+"</td><td><a href='insert.jsp?id="+e.getId()+"'>edit</a></td><td><a href='DeleteData?id="+e.getId()+"'>delete</a></td></tr>");
//		}
//		out.print("</table>");
//		
//		out.close();
//	}
//
//}

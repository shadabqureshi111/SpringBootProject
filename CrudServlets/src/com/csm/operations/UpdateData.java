package com.csm.operations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csm.dao.EmpDao;
import com.csm.model.Emp;

/**
 * Servlet implementation class EditDataSave
 */
@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Long id=Long.parseLong(request.getParameter("id"));
		String name=request.getParameter("name");
		Double salary=Double.parseDouble(request.getParameter("salary"));
		System.out.println("Update = "+id+" "+name+" "+salary);
		
		Emp e=new Emp();
		e.setId(id);
		e.setName(name);
		e.setSalary(salary);
		
		
		int status=EmpDao.update(e);
		if(status>0){
			response.sendRedirect("fetch.jsp");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}

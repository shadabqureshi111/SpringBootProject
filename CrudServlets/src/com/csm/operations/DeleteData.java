package com.csm.operations;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csm.dao.EmpDao;


@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		EmpDao empDao = new EmpDao();
		int id =Integer.parseInt( request.getParameter("id"));
		empDao.delete(id);
		response.sendRedirect("fetch.jsp");
	}

}

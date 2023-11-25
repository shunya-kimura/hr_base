package controller;

import java.io.IOException;

import dao.HrDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class CreateController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		int department_id = Integer.parseInt(request.getParameter("department_id"));
		String employee = request.getParameter("employee");
		int position_id = Integer.parseInt(request.getParameter("position_id"));
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		
		HrDAO hrDAO = new HrDAO();
		hrDAO.createHr(department_id, employee, position_id, username, userpassword);
		
		request.setAttribute("department_id", department_id);
		request.setAttribute("employee", employee);
		request.setAttribute("jobtitle", position_id);
		request.setAttribute("username", username);
		request.setAttribute("userpassword", userpassword);
		
		response.sendRedirect("list");
	}
}
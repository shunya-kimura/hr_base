package controller;

import java.io.IOException;

import dao.HrDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id").trim());
		int department_id = Integer.parseInt(request.getParameter("department_id"));
		String employee = request.getParameter("employee");
		int position_id = Integer.parseInt(request.getParameter("position_id"));
		String username = request.getParameter("username");
		String userpassword = request.getParameter("userpassword");
		
		System.out.println(department_id);
		
		HrDAO hrDAO = new HrDAO();
		hrDAO.updateHr(id, department_id, employee, position_id, username, userpassword);
		
		request.setAttribute("id", id);
		
		response.sendRedirect("show?id=" + id);
	}
}
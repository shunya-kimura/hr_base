package controller;

import java.io.IOException;

import dao.HrDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/destroy")
public class DestroyController extends HttpServlet {
	
	public void doGet(HttpServletRequest request,
	HttpServletResponse response) throws ServletException,
	IOException {

		int id = Integer.parseInt(request.getParameter("id").trim());
		
		HrDAO hrDAO = new HrDAO();
		hrDAO.destroyHr(id);
		
		request.setAttribute("id", id);
		
		String forward = "/list";
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}
}
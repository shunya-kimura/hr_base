package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import dao.HrDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/edit")
public class EditController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		HrDAO hrDAO = new HrDAO();
		List<HashMap<String, String>> hrs = hrDAO.getEdit(id);
		
		request.setAttribute("employees", hrs);
		request.setAttribute("id", id);
		
		String view = "/WEB-INF/views/edit.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
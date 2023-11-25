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


@WebServlet("/list")
public class ListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		HrDAO hrDAO = new HrDAO();
		List<HashMap<String, String>> hrs = hrDAO.getHrs();
		
		request.setAttribute("employees", hrs);

		String view = "/WEB-INF/views/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/new")
public class NewController extends HttpServlet {
	
	public void doGet(HttpServletRequest request,
	HttpServletResponse response) throws ServletException,
	IOException {
		
		String view = "/WEB-INF/views/new.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher
		(view);
		dispatcher.forward(request, response);
	}
}
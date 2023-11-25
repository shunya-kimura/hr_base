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
import jakarta.servlet.http.HttpSession;


@WebServlet("/mypage")
public class MypageController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
    	Object id = session != null ? session.getAttribute("id") : null;
    	
    	if (id == null) {
    		response.sendRedirect("login");
    		return;
    	}
    	
    	HttpSession session1 = request.getSession();
		int id1 = (int)session1.getAttribute("id");
	
		HrDAO hrDAO = new HrDAO();
		List<HashMap<String, String>> hrs = hrDAO.getMypage(id1);
		
		request.setAttribute("employees", hrs);

		String view = "/WEB-INF/views/mypage.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
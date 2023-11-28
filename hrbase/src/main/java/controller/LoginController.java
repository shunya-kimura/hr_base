package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import dao.HrDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	/*
	 * ログイン 係長以上
	 * username：kimura　password：12345678
	 * ログイン 係長未満
	 * username：nakata　password：12345678
	 * */
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String view = "/WEB-INF/views/login.jsp";
        req.getRequestDispatcher(view).forward(req, res);
    }
	
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String userpassword = req.getParameter("userpassword");
        HrDAO userDAO = new HrDAO();
        try {
        	int[] userData = userDAO.getUserId(username, userpassword);
            int userId = userData[0];
            int positionId = userData[1];
            if (userId != -1) {	
                HttpSession session = req.getSession();
                session.setAttribute("id", userId);
                session.setAttribute("username", username);
                session.setAttribute("position_id", positionId);
               
                if (positionId > 2) {
                    res.sendRedirect("mypage");
                } else {
                    res.sendRedirect("list");
                }
            } else {
            	String view = "/WEB-INF/views/login.jsp";
                req.setAttribute("error", "Invalid username or password");
                req.getRequestDispatcher(view).forward(req, res);
            }
        } catch (SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new ServletException("Login Failed", e);
        }
    }
}

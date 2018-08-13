package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TaiKhoanDAO;
import model.TaiKhoan;


@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html:charset=utf-8");
	
	String action= request.getParameter("action");
	if(action==null) {
		System.out.println("ko lam gi ca");
		
	}else 
		if(action.equals("Login")) {
			String userName=request.getParameter("username");
			String passWord=request.getParameter("password");
if(new TaiKhoanDAO().checkLogin(userName, passWord)) {
	HttpSession session = request.getSession();
	TaiKhoan taiKhoan = TaiKhoanDAO.mapTaiKhoan.get(userName);
session.setAttribute("userlogin", taiKhoan);
}
		
	}else 
		if(action.equals("Res")) {
			
		
	}else 
		if(action.equals("Logout")) {
			
		}
response.sendRedirect("account.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

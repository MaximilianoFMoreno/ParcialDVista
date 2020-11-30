package edu.usal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.usal.negocio.dao.implementacion.UserDAO_ImpSQL;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("user"); 
		String contra = request.getParameter("password"); 
		String tUser = request.getParameter("t_user");
		
		//HttpSession session = request.getSession();
        //session.setAttribute("usuario", usuario);
        
		UserDAO_ImpSQL usq = new UserDAO_ImpSQL(); 
		
		if(tUser.equals("Admin")){
			
			try {
				if (usq.vLogin(usuario, contra)) {
					//session.setAttribute("usuario", usuario);
					response.sendRedirect("HomeAdmin.html");
				}else{
					
				}
			} catch (Exception e) {
				e.printStackTrace();
		}
		}else {
			
			if (tUser.equals("Chofer")) {
				try {
					if (usq.vLogin(usuario, contra)) {
						//ession.setAttribute("usuario", usuario);
						response.sendRedirect("HolaMundo.jsp");
					}else{
						
					}
				} catch (Exception e) {
				e.printStackTrace();
				}
				
			}
			
		}
			
			
		}
		
		
	}



package edu.usal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usal.negocio.dao.implementacion.CamionDAO_ImpSQL;
import edu.usal.negocio.dao.implementacion.ChoferDAO_ImpSQL;
import edu.usal.negocio.dominio.Chofer;

/**
 * Servlet implementation class ServletMChofer
 */
@WebServlet("/ServletMChofer")
public class ServletMChofer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMChofer() {
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
		
		int dni = Integer.parseInt(request.getParameter("dni_chofer"));
		String tel = request.getParameter("tel_chofer"); 
		
		ChoferDAO_ImpSQL chofi2 =  new ChoferDAO_ImpSQL();
		Chofer chofer = new Chofer(); 
		chofer.setNro_telefono(tel);
		chofer.setDni(dni);
		
		chofi2.updateChofer(chofer);
		response.sendRedirect("HomeAdmin.html");
	}

}

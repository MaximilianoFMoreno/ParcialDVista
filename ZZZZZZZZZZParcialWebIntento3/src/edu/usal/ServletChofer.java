package edu.usal;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usal.negocio.dao.implementacion.CamionDAO_ImpSQL;
import edu.usal.negocio.dao.implementacion.ChoferDAO_ImpSQL;
import edu.usal.negocio.dominio.Chofer;

/**
 * Servlet implementation class ServletChofer
 */
@WebServlet("/ServletChofer")
public class ServletChofer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletChofer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int dni_chof = Integer.parseInt(request.getParameter("dni_chof"));
		ChoferDAO_ImpSQL chofi =  new ChoferDAO_ImpSQL();
		try {
			chofi.bajaChofer(dni_chof);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("HomeAdmin.html");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre_c = request.getParameter("nombre_chofer");
		String apellido_c = request.getParameter("apellido_chofer");
		int dni_c = Integer.parseInt(request.getParameter("dni_chofer"));
		String telefonoc = request.getParameter("telefono_chofer");
		String usuario_c = request.getParameter("usuario_chofer");
		String contraseña_c = request.getParameter("contraseña_chofer");
		String categoria_c = request.getParameter("categria_chofer");
		
		ChoferDAO_ImpSQL cami =  new ChoferDAO_ImpSQL();
		Chofer ch = new Chofer(); 
		
		ch.setNombre(nombre_c);
		ch.setApellido(apellido_c);
		ch.setDni(dni_c);
		ch.setNro_telefono(telefonoc);
		ch.setUsuario_chofer(usuario_c);
		ch.setContraseña_chofer(contraseña_c);
		ch.setId_categoria(categoria_c);
		
		try {
			cami.altaChofer(ch);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("HomeAdmin.html");
	}

}

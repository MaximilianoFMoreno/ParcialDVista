package edu.usal;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usal.negocio.dao.implementacion.CamionDAO_ImpSQL;
import edu.usal.negocio.dao.implementacion.ViajeDAO_ImpSQL;
import edu.usal.negocio.dominio.Camion;
import edu.usal.negocio.dominio.Viaje;

/**
 * Servlet implementation class Sv_Camiones
 */
//@WebServlet("/Sv_Camiones")
public class Sv_Camiones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sv_Camiones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// El metodo de la implementacion anda perfecto... pero no elimina
		String dom = request.getParameter("dom_camiom");
		CamionDAO_ImpSQL kmi =  new CamionDAO_ImpSQL(); 
		kmi.bajaCamion(dom);
		response.sendRedirect("HomeAdmin.html");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dominio = request.getParameter("dominio_camion"); 
		String marca = request.getParameter("marca_camion");
		int tone = Integer.parseInt(request.getParameter("toneladas_camion"));
		int lt = Integer.parseInt(request.getParameter("litros_camion")); 
		int cons = Integer.parseInt(request.getParameter("consumo_camion")); 
		int est = 0; 
		String cat = request.getParameter("categoria_camion"); 
		
		CamionDAO_ImpSQL cami =  new CamionDAO_ImpSQL(); 
		Camion kmion = new Camion(); 
		kmion.setDomino(dominio);
		kmion.setMarca(marca);
		kmion.setToneladas_max(tone);
		kmion.setLitros_tanque(lt);
		kmion.setConsumo(cons);
		kmion.setEstado(est);
		kmion.setCategoria(cat);
		
		try {
			cami.altaCamion(kmion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("HomeAdmin.html");
		
		//Puedo agregar una alerta de JS indicando que se inserto correctamente
		
		/*
		CamionDAO_ImpSQL cami =  new CamionDAO_ImpSQL(); 
		
		Camion kmion = new Camion(request.getParameter("dominio_camion"),
								  request.getParameter("marca_camion"),
									Integer.parseInt(request.getParameter("toneladas_camion")),
									Integer.parseInt(request.getParameter("litros_camion")),
									Integer.parseInt(request.getParameter("consumo_camion")),
									0,
									request.getParameter("categoria_camion")); 
		try {
			cami.altaCamion(kmion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

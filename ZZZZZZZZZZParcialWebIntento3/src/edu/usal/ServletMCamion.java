package edu.usal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usal.negocio.dao.implementacion.CamionDAO_ImpSQL;
import edu.usal.negocio.dominio.Camion;

/**
 * Servlet implementation class ServletMCamion
 */
@WebServlet("/ServletMCamion")
public class ServletMCamion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMCamion() {
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
		
		String dominio = request.getParameter("domi_camion");
		int tone = Integer.parseInt(request.getParameter("tone_camion"));
		int lt = Integer.parseInt(request.getParameter("lit_camion")); 
		int cons = Integer.parseInt(request.getParameter("cons_camion"));
		String cat = request.getParameter("cate_camion");
		
		CamionDAO_ImpSQL cami2 =  new CamionDAO_ImpSQL(); 
		Camion kmion2 = new Camion(); 
		kmion2.setDomino(dominio);
		kmion2.setToneladas_max(tone);
		kmion2.setLitros_tanque(lt);
		kmion2.setConsumo(cons);
		kmion2.setCategoria(cat);
		cami2.updateCamion(kmion2);
		response.sendRedirect("HomeAdmin.html");
	}

}

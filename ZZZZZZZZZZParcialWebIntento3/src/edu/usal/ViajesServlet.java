package edu.usal;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.usal.negocio.dao.implementacion.ViajeDAO_ImpSQL;
import edu.usal.negocio.dominio.Camion;
import edu.usal.negocio.dominio.Viaje;

/**
 * Servlet implementation class ViajesServlet
 */
@WebServlet("/ViajesServlet")
public class ViajesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViajesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    int dni_chof  = 0; 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int dni_chof = Integer.parseInt(request.getParameter("dni_chof"));
		ViajeDAO_ImpSQL vj = new ViajeDAO_ImpSQL();
		List<Camion> asd = vj.altaViaje(dni_chof);
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html>\r\n")
  	  			.append("<html>\r\n")
  	  			.append("        <head>\r\n")
  	  			.append("            <title>Tabla de Camiones</title>\r\n")
  	  			.append("        </head>\r\n")
  	  			.append("        <body>\r\n");
		writer.append("<div>");
		writer.append("<table border='1' align=\"center\">\r\n");
		writer.append("<tr>\r\n");
  
		writer.append("<H1>Tabla de camiones disponibles: </H1>");
		writer.append("<th>DOMINIO</th>\r\n");
		writer.append("<th>MARCA</th>\r\n");
		writer.append("<th>ESTADO</th>\r\n");
		writer.append("<th>CONSUMO</th>\r\n");
		writer.append("<th>LITROS POR TANQUE</th>\r\n");
		writer.append("<th>CATEGORIA</th>\r\n");
        writer.append("</tr>\r\n");
        
        for (Camion camion : asd) {
			
        	writer.append("<tr>\r\n");
			writer.append("<td>" + camion.getDomino() + "</td>\r\n");
			writer.append("<td>" + camion.getMarca() + "</td>\r\n");	
			
			int conver = camion.getEstado(); 
			String setear = ""; 
			
			if(conver == 0){
				setear = "SIN INICIO";
			}
			if(conver == 1){
				setear = "EN CURSO";
			}
			if(conver == 2){
				setear = "FINALIZADO";
			}
			writer.append("<td>" + setear +"</td>\r\n");
			writer.append("<td>" + camion.getConsumo() + "</td>\r\n");
			writer.append("<td>" + camion.getLitros_tanque() + "</td>\r\n");
			writer.append("<td>" + camion.getCategoria() + "</td>\r\n");
			writer.append("</tr>\r\n");	
			writer.append("</table");
		}
        
        writer.append("</div>");
		writer.append("<form action=\"ViajesServlet\" method=\"POST\">");
		//writer.append("DNI: ");
		//writer.append("<label name=\"dni_c\">" + dni_chof + "</label>");
		writer.append("Ingrese el dominio que desea: ");
		writer.append("<input type=\"text\" name=\"domin_camion\">");
		writer.append("<br>");
		writer.append("Ingrese el origen del viaje: ");
		writer.append("<br>");
		writer.append("<input type=\"text\" name=\"origen_viaje\">");
		writer.append("<h4 style=\"color: red;\">(Los Origenes disponibles son: )</h4>");
		writer.append("Ingrese el destino desl viaje: ");
		writer.append("<br>");
		writer.append("<input type=\"text\" name=\"destino_viaje\">");
		writer.append("<h4 style=\"color: red;\">(Los destinos disponibles son: )</h4>");
		writer.append("<br>");
		writer.append("<input type=\"submit\" value=\"Cargar\">");
		writer.append("</form>");
		writer.append(" </body>\r\n")
        	  .append("</html>\r\n");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dominio = request.getParameter("domin_camion"); 
		String origen = request.getParameter("origen_viaje"); 
		String destino = request.getParameter("destino_viaje");
		int dni = Integer.parseInt(request.getParameter("dni_c"));
		
		Viaje viaj = new Viaje();
		ViajeDAO_ImpSQL vvjj = new ViajeDAO_ImpSQL();
		//viaj.setId_chofer(dni);
		viaj.setId_camion(dominio);
		viaj.setOrigen(origen);
		viaj.setDestino(destino);
		vvjj.altaRealViaje(dominio, origen, destino);
		
		response.sendRedirect("HomeAdmin.html");
	}

}

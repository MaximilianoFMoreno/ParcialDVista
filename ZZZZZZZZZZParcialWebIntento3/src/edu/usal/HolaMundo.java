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
import edu.usal.negocio.dominio.Viaje;

/**
 * Servlet implementation class HolaMundo
 */
//@WebServlet("/HolaMundo")
public class HolaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HolaMundo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String dni_chofer = request.getParameter("dni_chofer");
		
		int aux = 0;
		
		dni_chofer.valueOf(aux); //PUEDO CAMBIAR EL AUX POR PARCEARLO DIRECTO, PERO ANTES NO ME SALIA
		
		ViajeDAO_ImpSQL vj = new ViajeDAO_ImpSQL();
		List<Viaje> asd = vj.listarViajes(aux);
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html>\r\n")
        	  .append("<html>\r\n")
        	  .append("        <head>\r\n")
        	  .append("            <title>Tabla de Viajes</title>\r\n")
        	  .append("        </head>\r\n")
        	  .append("        <body>\r\n");
		writer.append("<div>");
		writer.append("<table border='1' align=\"center\">\r\n");
        writer.append("<tr>\r\n");
        
        writer.append("<H1>Su tabla de viajes!</H1>");
	        writer.append("<th>IDENTIFICADOR</th>\r\n");
	        writer.append("<th>DNI</th>\r\n");
	        writer.append("<th>DOMINIO</th>\r\n");
	        writer.append("<th>ORIGEN</th>\r\n");
	        writer.append("<th>DESTINO</th>\r\n");
	        writer.append("<th>ESTADO</th>\r\n");
	        writer.append("<th>TTIEMPO DE VIAJE</th>\r\n");
	        writer.append("<th>CONSUMO EN TANQUES</th>\r\n");
        writer.append("</tr>\r\n");
		
		for (Viaje viaje : asd) {
			
			writer.append("<tr>\r\n");
			writer.append("<td>" + viaje.getViajeID() + "</td>\r\n");
			writer.append("<td>" + viaje.getId_chofer() + "</td>\r\n");	
			writer.append("<td>" + viaje.getId_camion() +"</td>\r\n");
			writer.append("<td>" + viaje.getOrigen() + "</td>\r\n");
			writer.append("<td>" + viaje.getDestino() + "</td>\r\n");
			
			int conver = viaje.getEstado(); 
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
			
			writer.append("<td>" + setear + "</td>\r\n");
			writer.append("<td>" + viaje.getTiempo_viajes() + "</td>\r\n");
			writer.append("<td>" + viaje.getCant_tanques() + "</td>\r\n");
			writer.append("</tr>\r\n");	
			writer.append("</table");
				
			//response.getWriter().append(viaje.getDestino());
		}
		writer.append("</div>");
		writer.append("<form action=\"HolaMundo\" method=\"POST\">");
		writer.append("Identificador de viaje         ");
		writer.append("<input type=\"number\" name=\"id_viaje\">");
		writer.append("<br>");
		writer.append("Identificador de viaje         ");
		writer.append("<br>");
		writer.append("Ingrese 1 para EN CURSO y 2 para FINALIZADO");
		writer.append("<input type=\"number\" name=\"estado\">");
		writer.append("<br>");
		//writer.append("Nuevo estado       ");
		/*
		writer.append("<input class=\"box\" type=\"text\" list=\"estado\" name=\"estado\" placeholder=\"Seleccione estado\">");
		writer.append("<datalist id=\"estado\">");
		writer.append("<option value=\"EN CURSO\">");
		writer.append("<option value=\"FINALIZADO\">");
		*/
		//writer.append("<br>");
		
		writer.append("<input type=\"submit\" value=\"Actualizar\">");
		
		//writer.append("Nuevo estado       ");
		/*
		writer.append("Identificador de viaje         ");
		writer.append("<input type=\"number\" name=\"id_viaje\">");
		writer.append("<br>");
		writer.append("Nuevo estado       ");
		writer.append("<input class=\"box\" type=\"text\" list=\"estado\" name=\"estado\" placeholder=\"Seleccione estado\">");
		writer.append("<br>");
		writer.append("<datalist id=\"estado\">");
		writer.append("<option value=\"EN CURSO\">");
		writer.append("<option value=\"FINALIZADO\">");
		writer.append("<br>");
		writer.append("<hr>");
		//writer.append("<form action=\"HolaMundo\" method=\"POST\">");
		//writer.append("<input type=\"submit\" value=\"Actualizar\">");
		 */
		writer.append("</form>");
		
		//writer.append("");
		 writer.append(" </body>\r\n")
         .append("</html>\r\n");
		
		 
		 
		 
		 
		//response.sendRedirect("HolaMundo2.jsp");
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int id_viaje = Integer.parseInt(request.getParameter("id_viaje"));
		int estado = Integer.parseInt(request.getParameter("estado"));
		
		//int estado = Integer.parseInt(request.getParameter("estado"));
		
		/*
		String estado = request.getParameter("estado");
		
		int aux2 = 0; 
		
		if (estado.equals("EN CURSO")) {
			aux2 = 1;
		}
		
		if (estado.equals("FINALIZADO")) {
			aux2 = 2;
		}
		*/
		
		
		Viaje viajesito = new Viaje(); 
		ViajeDAO_ImpSQL vjj = new ViajeDAO_ImpSQL();
		viajesito.setViajeID(id_viaje); // id_viaje
		viajesito.setEstado(estado); // aux2
		vjj.updateViaje(viajesito);
		
		
		//PrintWriter writer = response.getWriter();
		//writer.append(viajesito);
		//doGet(request, response);
		
		response.sendRedirect("HolaMundo?dni_chofer=");
		
		
	}

}

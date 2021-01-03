package website.jorgeperez;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jorge Luis Pérez Canto
 * @date 2/01/2021 15:48
 */

@WebServlet("/Carrito")
public class Servlet8bCarritoCompras extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Creamos o recuperamos el objeto http session
        HttpSession sesion = request.getSession();

        // Recuperamos la lista de artículos agregados previamente si es que existen
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");

        // Verificamos si la lista de artículos existen
        if (articulos == null) {
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }

        // Procesamos el nuevo artículo
        String articuloNuevo = request.getParameter("articulo");

        // Revisamos el artículo nuevo
        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) {
            articulos.add(articuloNuevo);
        }

        // Imprimimos la lista de artículos
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Lista de Artículos</h2>");
            out.println("<br>");
            // Iteramos todos lso artículos
            for (String articulo : articulos) {
                out.println("<li>" + articulo + "</li>");
            }
            // Link para regresar al inicio
            out.println("<br>");
            out.println("<a href='/Servlets/idx8b_carrito_compras.html'>Regresar al inicio</a>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}

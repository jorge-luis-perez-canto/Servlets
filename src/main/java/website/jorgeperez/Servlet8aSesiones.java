package website.jorgeperez;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jorge Luis Pérez Canto
 * @date 2/01/2021 13:08
 */

@WebServlet("/Sesiones")
public class Servlet8aSesiones extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession sesion = request.getSession();
        String titulo = null;

        // Pedir el atributo contadorVisitas a la sesión
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");

        // Si es nulo es la primera vez que accedemos a la aplicación
        if (contadorVisitas == null) {
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        } else {
            contadorVisitas++;
            titulo = "Bienvenido nuevamente";
        }

        // Agregamos el nuevo valor a la sesión
        sesion.setAttribute("contadorVisitas", contadorVisitas);

        // Mandamos la respuesta al cliente
        PrintWriter out = response.getWriter();

        out.println("Título: " + titulo);
        out.println("<br>");
        out.println("No. de acceso al recurso: " + contadorVisitas);
        out.println("<br>");
        out.println("ID de la sesión: " + sesion.getId());

    }
}

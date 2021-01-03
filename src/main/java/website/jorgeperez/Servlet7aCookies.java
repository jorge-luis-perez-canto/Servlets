package website.jorgeperez;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jorge Luis Pérez Canto
 * @date 1/01/2021 23:55
 */

@WebServlet("/Cookies")
public class Servlet7aCookies extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Suponemos que el usuario visita por primera vez nuestro sitio
        boolean nuevoUsuario = true;

        // Obtenemos el arreglo de cookies
        Cookie[] cookies = request.getCookies();

        // Buscamos si ya existe una cookie creada con anterioridad llamada visitanteRecurrente

        if (cookies != null) {
            for (Cookie c : cookies) {
                if ((c.getName().equals("visitanteRecurrente")) && (c.getValue().equals("si"))) {
                    // Si ya existe la cookie es un usuario recurrente
                    nuevoUsuario = false;
                    break;
                }
            }
        }

        String mensaje = null;
        if (nuevoUsuario) {
            Cookie visitanteNuevo = new Cookie("visitanteRecurrente", "si");
            response.addCookie(visitanteNuevo);
            mensaje = "Gracias por visitar nuestro sitio por primera vez";
        } else {
            mensaje = "Gracias por visitar NUEVAMENTE nuestro sitio";
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Mensaje: " + mensaje);
        out.close();

        // Eliminar Cookies
        /*
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("visitanteNuevo")) {
                    cookies[i].setMaxAge(0);
                    response.addCookie(cookies[i]);
                }
            }
        }
        */
    }
}

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
 * @date 2/01/2021 11:09
 */

@WebServlet("/ContadorVisitasServlet")
public class Servlet7bContadorVisitas extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Declaramos variable contador contador
        int contador = 0;

        // Revisamos si existe la cookie contadorVisitas
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("contadorVisitas")) {
                    contador = Integer.parseInt(c.getValue());
                }
            }
        }

        // Incrementamos el valor en uno
        contador++;

        // Agregamos la respuesta al navegador
        Cookie c = new Cookie("contadorVisitas", Integer.toString(contador));

        // La cookie se almacenará en el cliente por 1 hora (3600 seg)
        c.setMaxAge(3600);

        response.addCookie(c);

        // Mandamos el mensaje al navegador
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("Contador de visitas de cada cliente. " + contador);
    }
}

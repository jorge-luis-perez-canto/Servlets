package website.jorgeperez;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jorge Luis Pérez Canto
 * @date 29/12/2020 01:09
 */

@WebServlet("/ManejoParametros")
public class Servlet2ManejoParametros extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Leer los parámetros del formulario
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        System.out.println("usuario = " + usuario);
        System.out.println("password = " + password);

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("El parámetro usuario es: " + usuario);
        out.println("<br>");
        out.println("El parámetro password es: " + password);
        out.println("<br>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

}

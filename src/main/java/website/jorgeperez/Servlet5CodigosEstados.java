package website.jorgeperez;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Jorge Luis Pérez Canto
 * @date 31/12/2020 14:14
 */

@WebServlet("/Estados")
public class Servlet5CodigosEstados extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Simular los valores correctos
        String usuarioOk = "Jorge";
        String passwordOk = "321";

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        PrintWriter out = response.getWriter();

        if (usuarioOk.equals(usuario) && passwordOk.equals(password)) {
            out.println("<h1>Datos correctos</h1>");
            out.println("<br>Usuario: " + usuario);
            out.println("<br>Password: " + password);
        } else {
            response.sendError(response.SC_UNAUTHORIZED, "Las credenciales son incorrectas.");
        }
        out.close();
    }
}

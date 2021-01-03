package website.jorgeperez;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Jorge Luis Pérez Canto
 * @date 31/12/2020 20:18
 */

@WebServlet("/Hora")
public class Servlet6bHora extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setHeader("refresh", "1");
        Date fecha = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss");
        String horaConFormato = formateador.format(fecha);
        PrintWriter out = resp.getWriter();
        out.println("Hora actualizada: " + horaConFormato);
        out.close();
    }
}

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
 * @date 31/12/2020 20:19
 */

@WebServlet("/GeneracionExcel")
public class Servlet6aGeneracionExcel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Indicamos el tipo de respuesta al navegador

        resp.setContentType("application/vnd.ms-excel");
        resp.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");
        // Para un uso más profesional de excel usar poi.apache.org

        // Indicar al navegador que no guarde cache
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-store");
        resp.setDateHeader("Expires", -1);

        // Desplegar la información al cliente
        PrintWriter out = resp.getWriter();
        out.println("\tValores");
        out.println("\t1");
        out.println("\t2");
        out.println("Total\t=SUM(B2:B3)");
        out.close();
    }
}

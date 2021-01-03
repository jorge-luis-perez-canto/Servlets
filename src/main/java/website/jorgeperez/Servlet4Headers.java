package website.jorgeperez;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author Jorge Luis Pérez Canto
 * @date 31/12/2020 00:51
 */

@WebServlet("/Headers")
public class Servlet4Headers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        // Tipo de petición (GET, POST, PUT, DELETE, HEAD, OPTIONS, TRACE)
        String metodoHttp = req.getMethod();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Headers HTTP</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Headers HTTP</h1>");
        out.println("<br>");
        out.println("Método HTTP: " + metodoHttp);

        // Nombre y versión usada en la línea de petición (HTTP/1.0, HTTP/1.1 ...)
        String protocol = req.getProtocol();
        out.println("<br>");
        out.println("Protocol: " + protocol);

        // Path del servlet
        String servletPath = req.getServletPath();
        out.println("<br>");
        out.println("ServletPath: " + servletPath);

        // Identificador de recursos uniforme
        String uri = req.getRequestURI();
        out.println("<br>");
        out.println("Uri: " + uri);

        // Path del directorio raíz del servidor web
        String realPath = req.getServletContext().getRealPath("/");
        out.println("<br>");
        out.println("RealPath: " + realPath);

        // Información del servidor web
        String serverInfo = req.getServletContext().getServerInfo();
        out.println("<br>");
        out.println("ServerInfo: " + serverInfo);

        // Nombre del servidor web
        String serverName = req.getServerName();
        out.println("<br>");
        out.println("ServerName: " + serverName);

        // Puerto por el que escucha el servidor
        int serverPort = req.getServerPort();
        out.println("<br>");
        out.println("ServerPort: " + serverPort);

        // IP del servidor que recibe la petición
        String localAddr = req.getLocalAddr();
        out.println("<br>");
        out.println("LocalAddr IPv6: " + localAddr);

        // IP del cliente que hizo la petición
        String remoteAddr = req.getRemoteAddr();
        out.println("<br>");
        out.println("RemoteAddr IPv6: " + remoteAddr);

        // Nombre del dominio del cliente que hizo la petición o IP si no se puede determinar (getRemoteAddr)
        String remoteHost = req.getRemoteHost();
        out.println("<br>");
        out.println("RemoteHost IPv6: " + remoteHost);

        // Obtendremos todas las cookies de la petición
        Cookie[] s1 = req.getCookies();
        out.println("<br>");
        for (Cookie c : s1) {
            out.println("Cookie: " + c.getName() + " / " + c.getValue() + "<br>");
        }

        // Obtenemos el valor de la cabecera Content-Length
        // Número de bytes enviados en peticiones POST
        long contentLength = req.getContentLengthLong();
        out.println("ContentLength: " + contentLength);

        out.println("<br>");
        out.println("<br>");
        out.println("<br>");
        out.println("HeaderNames:");
        out.println("<br>");
        out.println("<br>");


        // Obtendremos todos los nombres de las cabeceras enviadas
        Enumeration cabeceros = req.getHeaderNames();
        while (cabeceros.hasMoreElements()) {
            String nombreCabecero = (String) cabeceros.nextElement();
            // Imprimimos todos los cabeceros disponibles
            out.println("<b>" + nombreCabecero + ": </b>");
            out.println(req.getHeader(nombreCabecero));
            out.println("<br>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}

package es.unex.cum.tw.servlet;


import es.unex.cum.tw.models.Usuario;
import es.unex.cum.tw.services.UsuarioService;
import es.unex.cum.tw.services.UsuarioServiceJDBCImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@WebServlet(
        name = "LoginServlet",
        value = "/login"
)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            UsuarioService usuarioService = new UsuarioServiceJDBCImpl();
            Optional<Usuario> usuarioOptional = usuarioService.login(username, password);

            if(usuarioOptional.isPresent()){
                req.setAttribute("mensaje", "Usuario logueado");
                HttpSession session = req.getSession();
                session.setAttribute("user", usuarioOptional.get());
            }else{
                req.setAttribute("mensaje", "Error, Credenciales incorrectas");
            }

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            try{
                dispatcher.forward(req, resp);
            }catch (Exception e){
                throw new RuntimeException();
            }
        } catch (SQLException | NamingException e) {
            throw new RuntimeException(e);
        }









    }
}

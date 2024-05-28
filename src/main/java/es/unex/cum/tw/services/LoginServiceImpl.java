package es.unex.cum.tw.services;

import es.unex.cum.tw.models.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

/**
 * Clase que implementa la interfaz LoginService.
 * @author Jose Luis Obiang Ela Nanguang
 * @version 1.0 12-05-2024, Sun, 12:49
 */
public class LoginServiceImpl implements LoginService {
    @Override
    public Optional<Usuario> authenticate(HttpServletRequest request) {
        HttpSession session = request.getSession();

        Usuario user = (Usuario) session.getAttribute("user");

        return Optional.ofNullable(user);
    }
}

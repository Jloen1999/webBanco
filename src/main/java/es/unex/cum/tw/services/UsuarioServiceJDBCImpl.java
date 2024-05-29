package es.unex.cum.tw.services;

import es.unex.cum.tw.models.Usuario;
import es.unex.cum.tw.repositories.UsuarioRepository;
import es.unex.cum.tw.repositories.UsuarioRepositoryJDBCImpl;

import java.sql.SQLException;
import java.util.Optional;

import javax.naming.NamingException;

public class UsuarioServiceJDBCImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceJDBCImpl() throws SQLException, NamingException{
        this.usuarioRepository = new UsuarioRepositoryJDBCImpl();
    }


       @Override
           public Optional<Usuario> login(String username, String password) {
               try {
                   return usuarioRepository.findByUsernameAndPassword(username, password).filter(user -> user.getContrasena().equals(password));
               } catch (SQLException e) {
                   throw new ServiceJdbcException(e.getMessage(), e.getCause());
               }

           }
}
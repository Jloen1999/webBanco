package es.unex.cum.tw.repositories;

import es.unex.cum.tw.models.Usuario;
import es.unex.cum.tw.util.ConexionBD_DSPool;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsuarioRepositoryJDBCImpl implements UsuarioRepository {

    private final Connection conn;

    public UsuarioRepositoryJDBCImpl() throws SQLException, NamingException {
        conn = ConexionBD_DSPool.getConexionBD();
    }


    /**
     * Busca un usuario por su nombre de usuario y contraseña
     *
     * @param username nombre de usuario
     * @param password contraseña
     * @return <ul>
     *     <li>Optional.empty() si no se encuentra el usuario</li>
     *     <li>Optional.of(Usuario) si se encuentra el usuario</li>
     * </ul>
     */
    @Override
    public Optional<Usuario> findByUsernameAndPassword(String username, String password) throws SQLException {
        Usuario user = null;
        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM usuarios WHERE nombre_usuario = ? AND contrasena = ?")) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    user = new Usuario(username, password);
                }
            }
        }
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<Usuario> findById(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<Usuario> findAll() throws SQLException {
        return List.of();
    }

    @Override
    public boolean save(Usuario usuario) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Usuario usuario) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Usuario usuario) throws SQLException {
        return false;
    }
}

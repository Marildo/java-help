package model.dao.interfaces;

import java.util.Optional;

import model.entity.Usuario;

public interface UsuarioDAO extends BaseDao<Usuario> {
	
	public Optional<Usuario> findByLogin(String usuario, String senha);

}

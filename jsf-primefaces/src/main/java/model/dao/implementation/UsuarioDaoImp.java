package model.dao.implementation;

import java.util.Optional;

import model.dao.ProviderEntityManager;
import model.dao.interfaces.UsuarioDAO;
import model.entity.Usuario;

public class UsuarioDaoImp extends GenericDao<Usuario> implements UsuarioDAO {
	
    public UsuarioDaoImp() {
    	 entityManager = ProviderEntityManager.getInstance().getEntityManager();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Optional<Usuario> findByLogin(String usuario, String senha) {
		 Optional<?> opt = entityManager
				.createQuery("SELECT u FROM Usuario u WHERE usuario = :user AND senha = :password")
				.setParameter("user", usuario)
				.setParameter("password", senha)
				.getResultList()
				.stream()
				.findFirst(); 
		 
		 return (Optional<Usuario>) opt;
	}
}

package model.dao;

import java.util.Optional;

import model.entity.Usuario;

public class UsuarioDao extends GenericDao<Usuario> {
	
    public UsuarioDao() {
    	 entityManager = ProviderEntityManager.getInstance().getEntityManager();
	}
	
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

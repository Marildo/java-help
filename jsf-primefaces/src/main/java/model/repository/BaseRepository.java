package model.repository;

import javax.persistence.EntityManager;

public abstract class BaseRepository {
	protected final EntityManager entityManager;

	public BaseRepository() {	
		 this. entityManager = ProviderEntityManager.getInstance().getEntityManager();
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
}

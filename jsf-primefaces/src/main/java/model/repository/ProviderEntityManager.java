package model.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

 class ProviderEntityManager {
	
	private static ProviderEntityManager instance;
	
	public static ProviderEntityManager getInstance() {
		if(instance == null) {
		   instance = new ProviderEntityManager();
		}
		return instance;
	}
	
	private EntityManager entityManager;
	
	public ProviderEntityManager() {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("jsf-prime");
		 this. entityManager = emf.createEntityManager();
	}
		
	public EntityManager getEntityManager() {
		return entityManager;
	}
}

package model.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.AbstractEntity;

public class GenericDao<E extends AbstractEntity<?>> {

	protected EntityManager entityManager;

	public E salvar(E entity) {
		EntityTransaction transaction = this.entityManager.getTransaction();
		try {
			transaction.begin();
			entity = this.entityManager.merge(entity);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		return entity;
	}

	public List<E> findAll() {
		final String tableName = getClassType().getSimpleName();
		return (List<E>) entityManager.createQuery("from " + tableName).getResultList();
	}

	private Class<E> getClassType() {
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		return (Class<E>) parameterizedType.getActualTypeArguments()[0];
	}	
}

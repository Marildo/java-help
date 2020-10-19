package model.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.entity.AbstractEntity;

public abstract class GenericDao<E extends AbstractEntity<?>> {

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
		final List<?> result = entityManager.createQuery("from " + tableName).getResultList();
		return (List<E>) result;
	}

	private Class<E> getClassType() {
		final ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type result = parameterizedType.getActualTypeArguments()[0];
		return (Class<E>) result;
	}
}

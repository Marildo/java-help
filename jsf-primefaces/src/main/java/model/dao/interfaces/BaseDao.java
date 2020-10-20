package model.dao.interfaces;

import java.util.List;

import model.entity.AbstractEntity;

public interface BaseDao<E extends AbstractEntity<?>> {
		
	public E salvar(E entity);
	
	public List<E> findAll();
}

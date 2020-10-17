package model.repository;

import model.Produto;

public class ProdutoRepository extends BaseRepository {

	public ProdutoRepository() {
		super();
	}

	public Produto save(Produto produto) {
		entityManager.getTransaction().begin();
		try {
			try {
				produto = entityManager.merge(produto);
				entityManager.getTransaction().commit();
				return produto;
			} catch (Exception e) {
				entityManager.getTransaction().rollback();
				e.printStackTrace();
				return null;
			}
		} finally {
			entityManager.close();
		}
	}
}

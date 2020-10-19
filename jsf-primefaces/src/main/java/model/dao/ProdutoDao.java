package model.dao;

import model.Produto;

public class ProdutoDao extends GenericDao<Produto> {

	 public ProdutoDao() {
		 entityManager = ProviderEntityManager.getInstance().getEntityManager();
	}
}

package model.dao;

import model.entity.Produto;

public class ProdutoDao extends GenericDao<Produto> {

    public ProdutoDao() {
		 entityManager = ProviderEntityManager.getInstance().getEntityManager();
	}
}

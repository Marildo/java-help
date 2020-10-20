package model.dao.implementation;

import model.dao.ProviderEntityManager;
import model.dao.interfaces.ProdutoDao;
import model.entity.Produto;

public class ProdutoDaoImp  extends GenericDao<Produto> implements ProdutoDao {
    public ProdutoDaoImp() {
		 entityManager = ProviderEntityManager.getInstance().getEntityManager();
	}
}

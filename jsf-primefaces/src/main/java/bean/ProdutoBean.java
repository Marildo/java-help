package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.dao.implementation.ProdutoDaoImp;
import model.dao.interfaces.ProdutoDao;
import model.entity.Categoria;
import model.entity.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = -7535626331983535680L;

	private final String header = "Cadastro de Produtos";
	
	private ProdutoDao produtoDao;

	public ProdutoBean() {
		System.out.println("Cadastro de Produto");
	}

	public String getHeader() {
		return header;
	}

	public String saveProduto() {
		Categoria categoria = new Categoria();
		categoria.setId(1);

		Produto produto = new Produto();
		produto.setNome("Produto 03");
		produto.setValor(24.0);
		produto.setCategoria(categoria);

	
		produtoDao = new ProdutoDaoImp();
		produto = produtoDao.salvar(produto);
		System.out.println(produto);

		return "";
	}
	
	public String list() {		
		ProdutoDao dao = new ProdutoDaoImp();
		List<Produto> produtos =   dao.findAll();
		System.out.println(produtos);
		
		return null;		
	}
}

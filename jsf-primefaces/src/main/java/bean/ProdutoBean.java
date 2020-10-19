package bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Categoria;
import model.Produto;
import model.dao.ProdutoDao;

@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = -7535626331983535680L;

	private final String header = "Cadastro de Produtos";

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

	
		ProdutoDao dao = new ProdutoDao();
		produto = dao.salvar(produto);
		System.out.println(produto);

		return "";
	}
	
	public String list() {		
		ProdutoDao dao = new ProdutoDao();
		List<Produto> produtos =   dao.findAll();
		System.out.println(produtos);
		
		return null;		
	}
}

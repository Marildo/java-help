package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Categoria;
import model.Produto;
import model.repository.ProdutoRepository;

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

		ProdutoRepository repository = new ProdutoRepository();
		repository.save(produto);

		return "";
	}
}

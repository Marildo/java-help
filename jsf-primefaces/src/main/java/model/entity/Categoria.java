package model.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Categoria extends AbstractEntity<Integer>{
	
	private String nome;
	
	@OneToMany(mappedBy = "categoria")
	private List<Produto> produtos;

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}

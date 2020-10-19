package model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Usuario extends AbstractEntity<Integer>{
	
	@Column(unique = true)
	private String usuario;
	
	private String senha;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", senha=" + senha + "]";
	}	
}

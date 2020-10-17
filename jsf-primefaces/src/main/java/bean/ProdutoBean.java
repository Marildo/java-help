package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
	
}

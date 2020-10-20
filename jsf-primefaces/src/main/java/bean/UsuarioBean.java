package bean;

import java.io.Serializable;
import java.util.Optional;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.dao.implementation.UsuarioDaoImp;
import model.dao.interfaces.UsuarioDAO;
import model.entity.Usuario;
import service.LoginService;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1l;
	
	//@Inject
	private UsuarioDAO usuarioDAO;

	private String usuario ;
	private String senha;

	public String login() {
		// Logger.getLogger(getClass().getName()).info(usuario + " :: " + senha);
		usuarioDAO= new UsuarioDaoImp();
		Optional<Usuario> user = usuarioDAO.findByLogin(usuario, senha);
		if (user.isPresent()) {
			LoginService service = new LoginService();
			return service.login(user.get());
		}
		return "";
	}

	public String newUser() {
		Usuario user = new Usuario();
		user.setSenha(senha);
		user.setUsuario(usuario);

		usuarioDAO = new UsuarioDaoImp();
		user = usuarioDAO.salvar(user);
		LoginService service = new LoginService();
		Logger.getLogger(getClass().getName()).info(user.toString());
		return service.login(user);
	}

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
}

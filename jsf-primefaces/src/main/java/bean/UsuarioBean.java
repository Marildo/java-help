package bean;

import java.io.Serializable;
import java.util.Optional;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.dao.UsuarioDao;
import model.entity.Usuario;
import service.LoginService;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1l;

	private String usuario ;
	private String senha;

	public String login() {
		// Logger.getLogger(getClass().getName()).info(usuario + " :: " + senha);
		UsuarioDao dao = new UsuarioDao();
		Optional<Usuario> user = dao.findByLogin(usuario, senha);
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

		UsuarioDao dao = new UsuarioDao();
		user = dao.salvar(user);
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

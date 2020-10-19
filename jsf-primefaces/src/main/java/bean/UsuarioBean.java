package bean;

import java.io.Serializable;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.dao.UsuarioDao;
import model.entity.Usuario;
import service.LoginService;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = -9162222995892286784L;

	public String login() {

		String senha = "123456";
		String usuario = "admin";

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
		user.setSenha("123456");
		user.setUsuario("admin");

		UsuarioDao dao = new UsuarioDao();
		user = dao.salvar(user);
		LoginService service = new LoginService();
		return service.login(user);
	}

}

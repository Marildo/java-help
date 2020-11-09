package service;

import javax.faces.context.FacesContext;

import model.entity.Usuario;

public class LoginService {

	public String login(Usuario usuario) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put("usuarioLogado", usuario);
		return "index.xhtml";
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		request.getSession().invalidate();
		return "login.xhtml";
	}
}

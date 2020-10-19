package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.entity.Usuario;

@WebFilter(urlPatterns = "/*")
public class AuthenticateFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;

		String url = req.getServletPath();
		
		HttpSession session = req.getSession();
		Usuario user = (Usuario) session.getAttribute("usuarioLogado");
	
		if(!url.equalsIgnoreCase("index.xhtml") && user == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.xhtml");
			dispatcher.forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);		
	}

}

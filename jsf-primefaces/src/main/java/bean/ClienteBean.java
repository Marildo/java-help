package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.time.LocalDateTime;


@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String message = "Minha message "+LocalDateTime.now();
	
	public ClienteBean() {
	   System.out.println(message);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}

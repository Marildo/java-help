package bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.time.LocalDateTime;


@ManagedBean
@ViewScoped
public class IndexBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String message = "Tela App "+LocalDateTime.now();
	
	public IndexBean() {
	   System.out.println(message);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}

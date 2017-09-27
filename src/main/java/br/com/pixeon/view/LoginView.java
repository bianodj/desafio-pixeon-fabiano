package br.com.pixeon.view;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.pixeon.app.bean.LoginBean;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginView extends LoginBean {
	
	private static final long serialVersionUID = 4790685130792057020L;

	public LoginView() {
		super();
	}

	public LoginView(String usuario, String senha) {
		super(usuario, senha);
	}

	@XmlElement(name="username")
	@Override
	public String getUsuario() {
		return super.getUsuario();
	}

	@XmlElement(name="senha")
	@Override
	public String getSenha() {
		return super.getSenha();
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + getUsuario() + ", senha=" + getSenha() + "]";
	}
	
}
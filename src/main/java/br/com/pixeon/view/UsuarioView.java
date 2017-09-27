package br.com.pixeon.view;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.pixeon.app.bean.UsuarioBean;
import br.com.pixeon.model.entity.Usuario;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UsuarioView extends UsuarioBean {
	
	private static final long serialVersionUID = 4790685130792057020L;

	public UsuarioView() {
		super();
	}

	public UsuarioView(Integer id, String nome, String email, String usuario, String senha, boolean admin, Date dataCadastro, String situacao) {
		super(id, nome, email, usuario, senha, admin, dataCadastro, situacao);
	}

	public UsuarioView(Usuario entity) {
		super(entity.getId(), entity.getNome(), entity.getEmail(), entity.getUsuario(), entity.getSenha(), entity.getAdmin(), entity.getDataCadastro(), entity.getSituacao());
	}

	@XmlElement(name="id")
	@Override
	public Integer getId() {
		return super.getId();
	}

	@XmlElement(name="nome")
	@Override
	public String getNome() {
		return super.getNome();
	}

	@XmlElement(name="email")
	@Override
	public String getEmail() {
		return super.getEmail();
	}

	@XmlElement(name = "usuario")
	@Override
	public String getUsuario() {
		return super.getUsuario();
	}

	@XmlElement(name = "senha")
	@Override
	public String getSenha() {
		return super.getSenha();
	}

	@XmlElement(name = "admin")
	@Override
	public boolean getAdmin() {
		return super.getAdmin();
	}

	@XmlElement(name="dataCadastro")
	@Override
	public Date getDataCadastro() {
		return super.getDataCadastro();
	}

	@XmlElement(name="situacao")
	@Override
	public String getSituacao() {
		return super.getSituacao();
	}

	@Override
	public String toString() {
		return "UsuarioView [id=" + getId() + ", nome=" + getNome() + ", email=" + getEmail() + ", dataCadastro=" + getDataCadastro() + ", situacao=" + getSituacao() + "]";
	}
	
}
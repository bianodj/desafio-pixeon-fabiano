package br.com.pixeon.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.pixeon.app.bean.UsuarioBean;
import br.com.pixeon.view.UsuarioView;

@Entity
@Table(name = "Usuario")
@NamedQueries({ 
	@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u ORDER BY u.id"), 
	@NamedQuery(name = "Usuario.login", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.senha = :senha") 
})
public class Usuario extends UsuarioBean {

	private static final long serialVersionUID = -7491678457517091119L;

	public Usuario(Integer id, String nome, String email, String usuario, String senha, boolean admin, Date dataCadastro, String situacao) {
		super(id, nome, email, usuario, senha, admin, dataCadastro, situacao);
	}

	public Usuario(UsuarioView usuario) {
		super(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getUsuario(), usuario.getSenha(), usuario.getAdmin(), usuario.getDataCadastro(), usuario.getSituacao());
	}

    public Usuario() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Override
	public Integer getId() {
		return super.getId();
	}

	@Column(name = "nome")
	@Override
	public String getNome() {
		return super.getNome();
	}

	@Column(name = "email")
	@Override
	public String getEmail() {
		return super.getEmail();
	}

	@Column(name = "usuario")
	@Override
	public String getUsuario() {
		return super.getUsuario();
	}

	@Column(name = "senha")
	@Override
	public String getSenha() {
		return super.getSenha();
	}

	@Column(name = "admin")
	@Override
	public boolean getAdmin() {
		return super.getAdmin();
	}

	@Column(name = "dataCadastro")
	@Override
	public Date getDataCadastro() {
		return super.getDataCadastro();
	}

	@Column(name = "situacao")
	@Override
	public String getSituacao() {
		return super.getSituacao();
	}

}

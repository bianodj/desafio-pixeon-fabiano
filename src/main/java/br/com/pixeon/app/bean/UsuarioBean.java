package br.com.pixeon.app.bean;

import java.io.Serializable;
import java.util.Date;

public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String email;
	private String usuario;
	private String senha;
	private boolean admin;
	private Date dataCadastro;
	private String situacao;
	
	public UsuarioBean() {
		super();
	}

	public UsuarioBean(Integer id, String nome, String email, String usuario, String senha, boolean admin, Date dataCadastro, String situacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.usuario = usuario;
		this.senha = senha;
		this.admin = admin;
		this.dataCadastro = dataCadastro;
		this.situacao = situacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}

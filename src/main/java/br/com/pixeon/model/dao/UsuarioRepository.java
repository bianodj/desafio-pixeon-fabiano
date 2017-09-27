package br.com.pixeon.model.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.pixeon.model.entity.Usuario;

public class UsuarioRepository {

	private final EntityManagerFactory entityManagerFactory;
	private final EntityManager entityManager;
	
	public UsuarioRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_db_estudo");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	public void Salvar(Usuario usuario) {
		usuario.setDataCadastro(new Date());
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(usuario);
		this.entityManager.getTransaction().commit();
	}
	
	public List<Usuario> TodasPessoas() {
		return this.entityManager.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
	}
	
	public Usuario GetUsuario(Integer id) {
		return this.entityManager.find(Usuario.class, id);
	}
	
	public Usuario login(String usuario, String senha) {
		Usuario result = new Usuario();
		try {
			Query query = this.entityManager.createNamedQuery("Usuario.login", Usuario.class);
			query.setParameter("usuario", usuario);
			query.setParameter("senha", senha);
			result = (Usuario) query.getSingleResult();
		} finally{
			this.entityManager.close();
		}
        return result;
    }

	public void Excluir(Integer id) {
		Usuario usuario = this.GetUsuario(id);
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(usuario);
		this.entityManager.getTransaction().commit();
	}
	
}

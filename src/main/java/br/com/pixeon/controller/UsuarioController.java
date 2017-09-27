package br.com.pixeon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pixeon.model.dao.UsuarioRepository;
import br.com.pixeon.model.entity.Usuario;
import br.com.pixeon.view.UsuarioView;

@RestController
public class UsuarioController {

	private final UsuarioRepository repository = new UsuarioRepository();
	
	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	public List<UsuarioView> GetUsuarioView() {
		return getUsuarioViewList();
	}

	@RequestMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<UsuarioView> InserUsuario(@RequestBody UsuarioView usuarioView) {
		Usuario usuario = new Usuario(usuarioView);
		repository.Salvar(usuario);
		return getUsuarioViewList();
	}

	@RequestMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public List<UsuarioView> UpdateUsuario(@RequestBody UsuarioView usuarioView) {
		Usuario usuario = new Usuario(usuarioView);
		repository.Salvar(usuario);
		return getUsuarioViewList();
	}

	@RequestMapping(value = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public List<UsuarioView> DeleteUsuario(@RequestBody UsuarioView usuarioView) {
		Usuario usuario = new Usuario(usuarioView);
		repository.Excluir(usuario.getId());
		return getUsuarioViewList();
	}
	
	private List<UsuarioView> getUsuarioViewList() {
		List<UsuarioView> usuarioViewList = new ArrayList<UsuarioView>();
		List<Usuario> listaEntityPessoas = repository.TodasPessoas();
		for (Usuario usuario : listaEntityPessoas) {
			usuarioViewList.add(new UsuarioView(usuario));
		}
		return usuarioViewList;
	}

}
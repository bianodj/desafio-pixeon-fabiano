package br.com.pixeon.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pixeon.model.dao.UsuarioRepository;
import br.com.pixeon.view.LoginView;
import br.com.pixeon.view.UsuarioView;

@RestController
public class LoginController {

	private final UsuarioRepository repository = new UsuarioRepository();
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UsuarioView logon(@RequestBody LoginView login) {
		return new UsuarioView(repository.login(login.getUsuario(), login.getSenha()));
	}

}
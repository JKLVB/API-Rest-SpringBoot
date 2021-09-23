package com.cadastro.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.apirest.model.Usuario;
import com.cadastro.apirest.model.DTO.UsuarioDTO;
import com.cadastro.apirest.service.ServiceUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "API REST Usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
	
	@Autowired
	private ServiceUsuario serviceUsuario;
	
	@GetMapping("/usuarios")
	@ApiOperation(value = "Retorna uma lista de usuários")
	public ResponseEntity<List<Usuario>> consultar(){
		List<Usuario> user = serviceUsuario.consultarUsuarios();
		if(user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/nome")
	@ResponseStatus
	@ApiOperation(value = "Consulta por nome de usuário")
	public ResponseEntity<Usuario> consultarPorNome(String nome){
		
		Usuario user = serviceUsuario.consultarPorNome(nome);
		
		if(user != null) {
			return new ResponseEntity<> (user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/cpf")
	@ApiOperation(value = "Consulta por cpf")
	public ResponseEntity<Usuario>consultarPorCpf(Long cpf){
		
		Usuario user = serviceUsuario.consultarPorCpf(cpf);
		
		if(user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/salvar")
	@ApiOperation(value = "Salva um usuário")
	public ResponseEntity<Usuario> salvar(@RequestBody UsuarioDTO usuario){
		
		return new ResponseEntity<>(serviceUsuario.salvarUsuario(usuario), HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/editar/{id}")
	@ApiOperation(value = "Atualiza dados do usuário")
	public ResponseEntity<Usuario> atualizar(@PathVariable Integer id, @RequestBody Usuario usuario){
	  
	  Usuario user = serviceUsuario.atualizarUsuario(id, usuario);
	  
	  if(user != null) {
		  return new ResponseEntity<>(user, HttpStatus.OK);
		  }
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(value = "/deletar/{id}")
	@ApiOperation(value = "Deleta um usuário")
	public ResponseEntity<Usuario> deletar(@PathVariable Integer id){
		
		Usuario user = serviceUsuario.deletarUsuario(id);
		
		if(user != null) {
			return new ResponseEntity<> (user, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}

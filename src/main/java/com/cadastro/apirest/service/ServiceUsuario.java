package com.cadastro.apirest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.apirest.model.Perfil;
import com.cadastro.apirest.model.Usuario;
import com.cadastro.apirest.model.DTO.UsuarioDTO;
import com.cadastro.apirest.repository.PerfilRepository;
import com.cadastro.apirest.repository.UsuarioRepository;

@Service
public class ServiceUsuario {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	//	Método para consultar lista de usuários
	public List<Usuario> consultarUsuarios(){
		
		List<Usuario> listaUsuario = usuarioRepository.findAll();
		
		if(!listaUsuario.isEmpty()) {
			return listaUsuario;
		}
		return null;
	}
	
//	Método para consultar por nome
	public Usuario consultarPorNome(String nome) {
		
		boolean verificaNumeros = nome.matches("-?\\d+");
		
		if(verificaNumeros == true) {
			return null;
		}
		return usuarioRepository.findByNomeContaining(nome);
	}
	
//	Método para consultar por CPF
	public Usuario consultarPorCpf(Long cpf) {
		
		Usuario consultaCpf = usuarioRepository.findByCpf(cpf);
		
		if(consultaCpf == null) {
			return null; 
		}
	  	return usuarioRepository.findByCpf(cpf);
	}
	
//	Método para salvar usuário
	public Usuario salvarUsuario(UsuarioDTO usuario) {
		
		List<Perfil> listaPerfil = new ArrayList<>();
		
		for (Integer id : usuario.getPerfil()) {
			
			Perfil objPerfil = perfilRepository.findById(id).get();
			listaPerfil.add(objPerfil);
		}
		
		Usuario objUsuario = new Usuario();
		
		objUsuario.setId(null);
		objUsuario.setCpf(usuario.getCpf());
		objUsuario.setEmail(usuario.getEmail());
		objUsuario.setNascimento(usuario.getNascimento());
		objUsuario.setNome(usuario.getNome());
		objUsuario.setTelefone(usuario.getTelefone());
		objUsuario.setPerfil(listaPerfil);
		
		return usuarioRepository.save(objUsuario);
	}
	
//	Método para atualizar usuário
	
	  public Usuario atualizarUsuario(Integer id, Usuario usuario){
	  
	  Usuario objUsuario = usuarioRepository.findById(id).get();
	  
	  if(objUsuario != null){
		  
		objUsuario.setCpf(usuario.getCpf());
		objUsuario.setEmail(usuario.getEmail());
		objUsuario.setNascimento(usuario.getNascimento());
		objUsuario.setNome(usuario.getNome());
		objUsuario.setPerfil(usuario.getPerfil());
		objUsuario.setTelefone(usuario.getTelefone());
			  
		return usuarioRepository.save(objUsuario);
	  	}
	  	return null;
	}
	 
	
//	Método para deletar por ID
	public Usuario deletarUsuario(Integer id) {
		
		Optional<Usuario> objUsuario = usuarioRepository.findById(id);
		
		if(!objUsuario.isEmpty()) {
			usuarioRepository.deleteById(id);
			return objUsuario.get();
		}
		return null;
	}
}

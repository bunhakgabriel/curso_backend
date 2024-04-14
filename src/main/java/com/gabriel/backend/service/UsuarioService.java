package com.gabriel.backend.service;

import com.gabriel.backend.dto.UsuarioDTO;
import com.gabriel.backend.entity.UsuarioEntity;
import com.gabriel.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarTodos(){
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDTO::new).toList(); //Estamos percorrendo a lista de usuarios retornada e convertendo ela para UsuarioDTO, entao esse método vai retornar uma lista de UsuarioDTO
    }

    public void inserir(UsuarioDTO usuario){ //Neste caso vamos receber um UruarioDTO, mas como vamos mandar esse usuario para o banco de dados nós vamos converte-lo em UsuarioEntity
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioRepository.save(usuarioEntity);
    }

    public UsuarioDTO alterar(UsuarioDTO usuario){ //O metodo save serve tanto para inserir como para alterar, se nós mandarmos um objeto com um id que ja existe no banco de dados, oJPA vai saber que esse objeto precisa ser alterado, se o Id não existir em outro objeto do banco, ele vai apenas fazer a inserção
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
    }

    public void excluir(Long id) { //Não é necessario mandar o objeto inteiro, podemos mandar apenas o id do usuario
        UsuarioEntity usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }

    public UsuarioDTO buscarPorId(Long id){
        return new UsuarioDTO(usuarioRepository.findById(id).get());
    }
}

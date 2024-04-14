package com.gabriel.backend.controller;

import com.gabriel.backend.dto.UsuarioDTO;
import com.gabriel.backend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listarTodos(){
        return usuarioService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody UsuarioDTO usuario){
        usuarioService.inserir(usuario);
    }

    @PutMapping
    public UsuarioDTO alterar(@RequestBody UsuarioDTO usuario){ //@RequestBody significa que as informações vem no corpo da requisição
        return usuarioService.alterar(usuario);
    }

    //http://localhost:8080/usuario/3  // o /{id} neste exemplo corresponde ao 3
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {//ResponseEntity é uma classe do proprio springboot //@PathVariable("id") --> estamos indicando que o id que vem da url vai ser jogado no parametro 'id' que o método esta esperando
        usuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }
}



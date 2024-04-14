package com.gabriel.backend.dto;

import com.gabriel.backend.entity.UsuarioEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.BeanUtils;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String email;

    //Se eu for criar um método de consultas no banco de dados, então eu vou criar uma lista de entidades,
    //e aqui no usuario DTO eu tenho que fazer uma conversão do usuario ENTITY para o usuario DTO
    public UsuarioDTO(UsuarioEntity usuario){ //estamos pegando os atributos do ENTITY e jogando para o DTO de forma automatica, o springboot faz essa conversão caso ele ache os atributos iguais
        BeanUtils.copyProperties(usuario, this); //Leio um Entity e converto pra DTO
    }//Se quisermos fazer o contrario, converter um DTO para Entity nós fazemos esse mesmo processo na entidade

    //é interessanto no DTO nós termos um construtor vazio, que o springboot exige em algumas situações
    public UsuarioDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

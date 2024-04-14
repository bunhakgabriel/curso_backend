package com.gabriel.backend.entity;

import com.gabriel.backend.dto.UsuarioDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "Usuarios")
public class UsuarioEntity {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) //Essa coluna não pode ser nula
    private String nome;
    @Column(nullable = false, unique = true) //'unique = true' significa que o campo login vai ser unico, se alguém tentar cadastrar um nome de login que ja exista a aplicação vai acusar um erro
    private String login;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false)
    private String email;

    public UsuarioEntity(UsuarioDTO usuario){ //Estamos convertendo um UsuarioDTO para um UsuarioEntity, é o processo inverso do qual fizemos no UsuarioDTO, onde convertemos uma ENTITY para um DTO
        BeanUtils.copyProperties(usuario, this);
    }

    //é interessanto na entidade nós termos um construtor vazio, que o springboot exige em algumas situações
    public UsuarioEntity(){

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

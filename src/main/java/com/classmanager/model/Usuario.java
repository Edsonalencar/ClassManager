package com.classmanager.model;

import com.classmanager.enums.RoleType;

public class Usuario {
    private String login;
    private String senha;
    private RoleType role;
    private long id;

    public Usuario() {}

    public Usuario(String login, String senha, RoleType role) {
        this.login = login;
        this.senha = senha;
        this.role = role;
    }
    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
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

    public long getUserId() {
        return id;
    }

    public void setUserId(long id) {
        this.id = id;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", role=" + role +
                ", id=" + id +
                '}';
    }
}

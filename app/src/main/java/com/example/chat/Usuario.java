package com.example.chat;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String usuario;
    private String contrasena;
    private String email;
    private String nombre;

    public Usuario(String usuario, String contrasena, String email, String nombre) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.email = email;
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

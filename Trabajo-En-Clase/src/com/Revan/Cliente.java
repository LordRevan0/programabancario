package com.Revan;

import com.Revan.exepciones.ErrorValidacion;

public class Cliente {
    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;


    public Cliente(String id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    /** estos son getters y setters para id*/
    public String getId() {
        return id;
    }
    public void setId(String id) throws Exception {
        if(id.length()!=13){
                throw new ErrorValidacion("el numero de identidad debe tener 13 caracteres");
        }
        this.id = id;
    }

    /** estos son getters y setters para apellido*/
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNombreCompleto(){
        return this.nombre + " " + this.apellido;
    }

    /** estos son getters y setters para email*/
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if (!email.matches("^\\w+@\\w+\\.[a-z]{2,4}"));
        this.email = email;
    }
    /** estos son setters para telefono*/
    public void setTelefono(String telefono) {
        if (!telefono.matches("^(\\+504\\s?)?[0-9]{4}\\-?[0-9]{4}"));
        this.telefono = telefono;

    }







}

package com.gestioneden.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "La cédula o NIT es obligatorio")
    @Size(max = 20, message = "La cédula o NIT no puede superar 20 caracteres")
    @Column(name = "cedula_nit", nullable = false, unique = true, length = 20)
    private String cedulaNit;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede superar 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombre;

    @Size(max = 20, message = "El teléfono no puede superar 20 caracteres")
    @Column(length = 20)
    private String telefono;

    @Email(message = "El correo debe tener un formato válido")
    @Size(max = 120, message = "El correo no puede superar 120 caracteres")
    @Column(length = 120)
    private String correo;

    public Cliente() {
    }

    public Cliente(Integer id, String cedulaNit, String nombre,
                   String telefono, String correo) {
        this.id = id;
        this.cedulaNit = cedulaNit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedulaNit() {
        return cedulaNit;
    }

    public void setCedulaNit(String cedulaNit) {
        this.cedulaNit = cedulaNit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
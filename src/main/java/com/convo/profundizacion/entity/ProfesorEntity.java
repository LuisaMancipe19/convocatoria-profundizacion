package com.convo.profundizacion.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "profesor")
public class ProfesorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(nullable = false , unique = true)
    private long id;
    @Column(name ="tipo_documento")
    private String tipoDocumento;
    @Column(name ="numero_documento")
    private String numeroDocumento;
    private String nombre;
    @Column(name ="segundo_nombre")
    private String segundoNombre;
    private String apellido;
    @Column(name ="segundo_apellido")
    private String segundoApellido;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

}

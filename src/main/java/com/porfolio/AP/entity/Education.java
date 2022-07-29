package com.porfolio.AP.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String institucion;
    private String descripcion;
    private String img;
    private float inicio;
    private float fin;

    //constructores

    public Education() {
    }

    public Education(String titulo, String institucion, String descripcion, String img, float inicio, float fin) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.descripcion = descripcion;
        this.img = img;
        this.inicio = inicio;
        this.fin = fin;
    }

    //g&s


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public float getInicio() {
        return inicio;
    }

    public void setInicio(float inicio) {
        this.inicio = inicio;
    }

    public float getFin() {
        return fin;
    }

    public void setFin(float fin) {
        this.fin = fin;
    }
}

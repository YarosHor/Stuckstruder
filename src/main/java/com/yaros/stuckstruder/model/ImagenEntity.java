package com.yaros.stuckstruder.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "imagen", schema = "stuckstruder", catalog = "")
public class ImagenEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = true, length = 45)
    private String nombre;
    @Basic
    @Column(name = "archivo", nullable = true, length = 45)
    private String archivo;
    @Basic
    @Column(name = "fch_creacion", nullable = true)
    private Date fchCreacion;
    @Basic
    @Column(name = "fk_pregunta", nullable = false)
    private int fkPregunta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public Date getFchCreacion() {
        return fchCreacion;
    }

    public void setFchCreacion(Date fchCreacion) {
        this.fchCreacion = fchCreacion;
    }

    public int getFkPregunta() {
        return fkPregunta;
    }

    public void setFkPregunta(int fkPregunta) {
        this.fkPregunta = fkPregunta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImagenEntity that = (ImagenEntity) o;

        if (id != that.id) return false;
        if (fkPregunta != that.fkPregunta) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (archivo != null ? !archivo.equals(that.archivo) : that.archivo != null) return false;
        if (fchCreacion != null ? !fchCreacion.equals(that.fchCreacion) : that.fchCreacion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (archivo != null ? archivo.hashCode() : 0);
        result = 31 * result + (fchCreacion != null ? fchCreacion.hashCode() : 0);
        result = 31 * result + fkPregunta;
        return result;
    }
}

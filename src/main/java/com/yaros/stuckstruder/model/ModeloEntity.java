package com.yaros.stuckstruder.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "modelo", schema = "stuckstruder", catalog = "")
public class ModeloEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name = "fecha_creacion", nullable = true)
    private Date fechaCreacion;
    @Basic
    @Column(name = "fk_pregunta", nullable = false)
    private int fkPregunta;
    @Basic
    @Column(name = "fk_imagen", nullable = false)
    private int fkImagen;

    @OneToOne(mappedBy = "fkModelo")
    private PublicacionEntity publicacion;

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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getFkPregunta() {
        return fkPregunta;
    }

    public void setFkPregunta(int fkPregunta) {
        this.fkPregunta = fkPregunta;
    }

    public int getFkImagen() {
        return fkImagen;
    }

    public void setFkImagen(int fkImagen) {
        this.fkImagen = fkImagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModeloEntity that = (ModeloEntity) o;

        if (id != that.id) return false;
        if (fkPregunta != that.fkPregunta) return false;
        if (fkImagen != that.fkImagen) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (archivo != null ? !archivo.equals(that.archivo) : that.archivo != null) return false;
        if (fechaCreacion != null ? !fechaCreacion.equals(that.fechaCreacion) : that.fechaCreacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (archivo != null ? archivo.hashCode() : 0);
        result = 31 * result + (fechaCreacion != null ? fechaCreacion.hashCode() : 0);
        result = 31 * result + fkPregunta;
        result = 31 * result + fkImagen;
        return result;
    }
}

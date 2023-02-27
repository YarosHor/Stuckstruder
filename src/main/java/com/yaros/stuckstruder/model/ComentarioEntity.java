package com.yaros.stuckstruder.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "comentario", schema = "stuckstruder", catalog = "")
public class ComentarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "texto", nullable = true, length = 45)
    private String texto;
    @Basic
    @Column(name = "fecha_creacion", nullable = true)
    private Date fechaCreacion;
    @Basic
    @Column(name = "fk_publicacion", nullable = false)
    private int fkPublicacion;
    @Basic
    @Column(name = "fk_usuario", nullable = false)
    private int fkUsuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getFkPublicacion() {
        return fkPublicacion;
    }

    public void setFkPublicacion(int fkPublicacion) {
        this.fkPublicacion = fkPublicacion;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComentarioEntity that = (ComentarioEntity) o;

        if (id != that.id) return false;
        if (fkPublicacion != that.fkPublicacion) return false;
        if (fkUsuario != that.fkUsuario) return false;
        if (texto != null ? !texto.equals(that.texto) : that.texto != null) return false;
        if (fechaCreacion != null ? !fechaCreacion.equals(that.fechaCreacion) : that.fechaCreacion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (texto != null ? texto.hashCode() : 0);
        result = 31 * result + (fechaCreacion != null ? fechaCreacion.hashCode() : 0);
        result = 31 * result + fkPublicacion;
        result = 31 * result + fkUsuario;
        return result;
    }
}

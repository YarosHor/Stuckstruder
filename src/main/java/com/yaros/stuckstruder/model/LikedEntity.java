package com.yaros.stuckstruder.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "liked", schema = "stuckstruder", catalog = "")
public class LikedEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "fecha_guardado", nullable = true)
    private Date fechaGuardado;
    @Basic
    @Column(name = "usuario_id", nullable = false)
    private int usuarioId;
    @Basic
    @Column(name = "publicacion_id", nullable = false)
    private int publicacionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaGuardado() {
        return fechaGuardado;
    }

    public void setFechaGuardado(Date fechaGuardado) {
        this.fechaGuardado = fechaGuardado;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(int publicacionId) {
        this.publicacionId = publicacionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LikedEntity that = (LikedEntity) o;

        if (id != that.id) return false;
        if (usuarioId != that.usuarioId) return false;
        if (publicacionId != that.publicacionId) return false;
        if (fechaGuardado != null ? !fechaGuardado.equals(that.fechaGuardado) : that.fechaGuardado != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fechaGuardado != null ? fechaGuardado.hashCode() : 0);
        result = 31 * result + usuarioId;
        result = 31 * result + publicacionId;
        return result;
    }
}

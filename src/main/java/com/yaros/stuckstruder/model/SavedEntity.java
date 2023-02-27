package com.yaros.stuckstruder.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "saved", schema = "stuckstruder", catalog = "")
public class SavedEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "fecha_guardado", nullable = true)
    private Date fechaGuardado;
    @Basic
    @Column(name = "fk_usuario", nullable = false)
    private int fkUsuario;
    @Basic
    @Column(name = "fk_publicacion", nullable = false)
    private int fkPublicacion;

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

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public int getFkPublicacion() {
        return fkPublicacion;
    }

    public void setFkPublicacion(int fkPublicacion) {
        this.fkPublicacion = fkPublicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SavedEntity that = (SavedEntity) o;

        if (id != that.id) return false;
        if (fkUsuario != that.fkUsuario) return false;
        if (fkPublicacion != that.fkPublicacion) return false;
        if (fechaGuardado != null ? !fechaGuardado.equals(that.fechaGuardado) : that.fechaGuardado != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fechaGuardado != null ? fechaGuardado.hashCode() : 0);
        result = 31 * result + fkUsuario;
        result = 31 * result + fkPublicacion;
        return result;
    }
}

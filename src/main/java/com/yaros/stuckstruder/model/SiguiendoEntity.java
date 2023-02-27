package com.yaros.stuckstruder.model;

import jakarta.persistence.*;

@Entity
@Table(name = "siguiendo", schema = "stuckstruder", catalog = "")
public class SiguiendoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "fk_usuario", nullable = false)
    private int fkUsuario;
    @Basic
    @Column(name = "fk_seguidor", nullable = false)
    private int fkSeguidor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(int fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public int getFkSeguidor() {
        return fkSeguidor;
    }

    public void setFkSeguidor(int fkSeguidor) {
        this.fkSeguidor = fkSeguidor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SiguiendoEntity that = (SiguiendoEntity) o;

        if (id != that.id) return false;
        if (fkUsuario != that.fkUsuario) return false;
        if (fkSeguidor != that.fkSeguidor) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fkUsuario;
        result = 31 * result + fkSeguidor;
        return result;
    }
}

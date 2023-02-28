package com.yaros.stuckstruder.model;

import com.yaros.stuckstruder.service.UserDetailsImpl;
import jakarta.persistence.*;
import org.springframework.security.core.context.SecurityContextHolder;

@Entity
@Table(name = "publicacion", schema = "stuckstruder", catalog = "")
public class PublicacionEntity {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_usuario", nullable = true)
    private UsuarioEntity fkUsuario;*/
    @ManyToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id"/*, nullable=true*/)
    private UsuarioEntity fkUsuario;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_modelo", referencedColumnName = "id", nullable = true)
    private ModeloEntity fkModelo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_pregunta", referencedColumnName = "id", nullable = true)
    private PreguntaEntity fkPregunta;
    @Basic
    @Column(name = "is_question", nullable = true)
    private Byte isQuestion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioEntity getFkUsuario() {
        return fkUsuario;
    }

    public void setFkUsuario(UsuarioEntity fkUsuario) {
        this.fkUsuario = fkUsuario;
    }

    public ModeloEntity getFkModelo() {
        return fkModelo;
    }

    public void setFkModelo(ModeloEntity fkModelo) {
        this.fkModelo = fkModelo;
    }

    public PreguntaEntity getFkPregunta() {
        return fkPregunta;
    }

    public void setFkPregunta(PreguntaEntity fkPregunta) {
        this.fkPregunta = fkPregunta;
    }

    public Byte getIsQuestion() {
        return isQuestion;
    }

    public void setIsQuestion(Byte isQuestion) {
        this.isQuestion = isQuestion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PublicacionEntity that = (PublicacionEntity) o;

        if (id != that.id) return false;
        if (fkUsuario != null ? !fkUsuario.equals(that.fkUsuario) : that.fkUsuario != null) return false;
        if (fkModelo != null ? !fkModelo.equals(that.fkModelo) : that.fkModelo != null) return false;
        if (fkPregunta != null ? !fkPregunta.equals(that.fkPregunta) : that.fkPregunta != null) return false;
        if (isQuestion != null ? !isQuestion.equals(that.isQuestion) : that.isQuestion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fkUsuario != null ? fkUsuario.hashCode() : 0);
        result = 31 * result + (fkModelo != null ? fkModelo.hashCode() : 0);
        result = 31 * result + (fkPregunta != null ? fkPregunta.hashCode() : 0);
        result = 31 * result + (isQuestion != null ? isQuestion.hashCode() : 0);
        return result;
    }
}
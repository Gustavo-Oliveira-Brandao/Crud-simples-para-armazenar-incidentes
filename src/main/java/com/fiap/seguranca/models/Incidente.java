package com.fiap.seguranca.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    @Length(max = 100)
    @Column(nullable = false, length = 100)
    private String titulo;

    @NotNull
    @NotBlank
    @Length(max = 500)
    @Column(nullable = false, length = 500)
    private String descricao;

    @NotNull
    @NotBlank
    @Length(max = 100)
    @Column(nullable = false, length = 100)
    private String latitude;

    @NotNull
    @NotBlank
    @Length(max = 100)
    @Column(nullable = false, length = 100)
    private String longitude;

    @NotNull
    @Column(nullable = false)
    private Date dtCriadoEm;

    @Column
    private Date dtAlteradoEm;

    @Column
    private Date dtDeletadoEm;

    public Incidente(){}
    public Incidente(String titulo, String descricao, String latitude, String longitude, Date dtCriadoEm) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dtCriadoEm = dtCriadoEm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Date getDtCriadoEm() {
        return dtCriadoEm;
    }

    public void setDtCriadoEm(Date dtCriadoEm) {
        this.dtCriadoEm = dtCriadoEm;
    }

    public Date getDtAlteradoEm() {
        return dtAlteradoEm;
    }

    public void setDtAlteradoEm(Date dtAlteradoEm) {
        this.dtAlteradoEm = dtAlteradoEm;
    }

    public Date getDtDeletadoEm() {
        return dtDeletadoEm;
    }

    public void setDtDeletadoEm(Date dtDeletadoEm) {
        this.dtDeletadoEm = dtDeletadoEm;
    }
}

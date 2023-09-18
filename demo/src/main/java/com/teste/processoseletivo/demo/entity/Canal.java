package com.teste.processoseletivo.demo.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "canal")
public class Canal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="numero")
    private int numero;
    @Column(name="descricao")
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "camera")
    private Camera camera;

    public Canal() {
    }

    public Canal(Long id, int numero, String descricao) {
        this.id = id;
        this.numero = numero;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Canal canal = (Canal) o;
        return Objects.equals(id, canal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Canal{" +
                "id=" + id +
                ", numero=" + numero +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

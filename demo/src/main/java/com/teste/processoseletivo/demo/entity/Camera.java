package com.teste.processoseletivo.demo.entity;

import com.teste.processoseletivo.demo.enums.Tipo;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "camera")
public class Camera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "protocolo")
    private Tipo protocolo;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "camera")
    private List<Canal> canais = new ArrayList<>();

    public Camera() {
    }

    public Camera(Long id, String nome, Tipo protocolo, List<Canal> canais) {
        this.id = id;
        this.nome = nome;
        this.protocolo = protocolo;
        this.canais = canais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(Tipo protocolo) {
        this.protocolo = protocolo;
    }

    public List<Canal> getCanais() {
        return canais;
    }

    public void setCanais(List<Canal> canais) {
        this.canais = canais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera camera = (Camera) o;
        return Objects.equals(id, camera.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Camera{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", protocolo=" + protocolo +
                '}';
    }
}

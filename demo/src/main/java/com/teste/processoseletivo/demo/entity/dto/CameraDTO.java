package com.teste.processoseletivo.demo.entity.dto;

import com.teste.processoseletivo.demo.entity.Camera;
import com.teste.processoseletivo.demo.enums.Tipo;

import java.io.Serializable;

public class CameraDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private Tipo protocolo;

    public CameraDTO() {
    }

    public CameraDTO(Camera camera) {
        this.id = camera.getId();
        this.nome = camera.getNome();
        this.protocolo = camera.getProtocolo();
    }

    public static Camera convert(CameraDTO dto) {
        Camera camera = new Camera();
        camera.setId(dto.getId());
        camera.setNome(dto.getNome());
        camera.setProtocolo(dto.getProtocolo());
        return camera;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getProtocolo() {
        return this.protocolo;
    }

    public void setProtocolo(Tipo protocolo) {
        this.protocolo = protocolo;
    }
}

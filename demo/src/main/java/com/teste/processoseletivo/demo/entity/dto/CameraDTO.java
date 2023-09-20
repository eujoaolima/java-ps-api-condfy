package com.teste.processoseletivo.demo.entity.dto;

import com.teste.processoseletivo.demo.entity.Camera;
import com.teste.processoseletivo.demo.entity.Canal;
import com.teste.processoseletivo.demo.enums.Tipo;

import java.io.Serializable;
import java.util.List;

public class CameraDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private Tipo protocolo;
    private List<CanalDTO> canais;

    public CameraDTO() {
    }

    public CameraDTO(Camera camera) {
        this.id = camera.getId();
        this.nome = camera.getNome();
        this.protocolo = camera.getProtocolo();
        this.canais = camera.getCanais().stream().map(CanalDTO::new).toList();
    }

    public static Camera convert(CameraDTO dto) {
        Camera camera = new Camera();
        camera.setId(dto.getId());
        camera.setNome(dto.getNome());
        camera.setProtocolo(dto.getProtocolo());
        if (dto.getCanais() != null) {
            List<Canal> canais = dto.getCanais().stream().map(CanalDTO::convert).toList();
            camera.setCanais(canais);
        }
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

    public List<CanalDTO> getCanais() {
        return canais;
    }

    public void setCanais(List<CanalDTO> canais) {
        this.canais = canais;
    }
}

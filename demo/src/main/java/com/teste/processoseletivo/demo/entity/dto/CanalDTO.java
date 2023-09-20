package com.teste.processoseletivo.demo.entity.dto;

import com.teste.processoseletivo.demo.entity.Camera;
import com.teste.processoseletivo.demo.entity.Canal;

import java.io.Serializable;

public class CanalDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private int numero;
    private String descricao;

    public CanalDTO() {
    }

    public CanalDTO(Canal canal) {
        this.id = canal.getId();
        this.numero = canal.getNumero();
        this.descricao = canal.getDescricao();
    }

    public static Canal convert(CanalDTO dto) {
        Canal canal = new Canal();
        canal.setId(dto.getId());
        canal.setNumero(dto.getNumero());
        canal.setDescricao(dto.getDescricao());
        return canal;
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
}

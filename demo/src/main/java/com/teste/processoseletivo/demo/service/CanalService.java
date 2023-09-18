package com.teste.processoseletivo.demo.service;

import com.teste.processoseletivo.demo.entity.Canal;
import com.teste.processoseletivo.demo.entity.dto.CameraDTO;
import com.teste.processoseletivo.demo.entity.dto.CanalDTO;
import com.teste.processoseletivo.demo.repository.CanalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CanalService {
    @Autowired
    private CanalRepository repository;
    @PostMapping
    public CanalDTO save(CanalDTO dto) {
        Canal canal = CanalDTO.convert(dto);
        canal = this.repository.save(canal);
        return new CanalDTO(canal);
    }
    @GetMapping
    public List<CanalDTO> findAll() {
        List<Canal> lista = this.repository.findAll();
        return lista.stream().map(CanalDTO::new).collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public CanalDTO findById(Long id) {
        Optional<Canal> canal = this.repository.findById(id);
        if (canal.isEmpty()) {
            throw new RuntimeException("O canal não foi encontrado");
        } else {
            return new CanalDTO(canal.get());
        }
    }
    @DeleteMapping("/{id}")
    public CanalDTO deleteById(Long id) {
        CanalDTO dto = findById(id);
        this.repository.deleteById(id);
        return dto;
    }
}

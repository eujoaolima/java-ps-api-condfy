package com.teste.processoseletivo.demo.service;

import com.teste.processoseletivo.demo.entity.Canal;
import com.teste.processoseletivo.demo.entity.dto.CameraDTO;
import com.teste.processoseletivo.demo.entity.dto.CanalDTO;
import com.teste.processoseletivo.demo.repository.CanalRepository;
import com.teste.processoseletivo.demo.service.exceptions.DatabaseException;
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
    @PostMapping("/canal")
    public CanalDTO save(CanalDTO dto) {
        Canal canal = CanalDTO.convert(dto);
        if (canal.getNumero() <= 0) {
            throw new DatabaseException("O número inserido deve ser maior que zero");
        }
        canal = this.repository.save(canal);
        // System.out.println("Canal criado: " + canal);
        return new CanalDTO(canal);
    }
    @GetMapping("/canal")
    public List<CanalDTO> findAll() {
        List<Canal> lista = this.repository.findAll();
        return lista.stream().map(CanalDTO::new).collect(Collectors.toList());
    }
    @GetMapping("/canal/{id}")
    public CanalDTO findById(Long id) {
        Optional<Canal> canal = this.repository.findById(id);
        if (canal.isEmpty()) {
            throw new DatabaseException("O canal não foi encontrado");
        } else {
            return new CanalDTO(canal.get());
        }
    }
    @DeleteMapping("/canal/{id}")
    public CanalDTO deleteById(Long id) {
        CanalDTO dto = findById(id);
        this.repository.deleteById(id);
        return dto;
    }

    @DeleteMapping("/canal")
    public List<CanalDTO> deleteAll() {
        List<CanalDTO> canal = findAll();
        this.repository.deleteAll();
        return canal;
    }
}

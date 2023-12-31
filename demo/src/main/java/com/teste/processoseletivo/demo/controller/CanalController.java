package com.teste.processoseletivo.demo.controller;

import com.teste.processoseletivo.demo.entity.dto.CanalDTO;
import com.teste.processoseletivo.demo.service.CanalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/canal")
public class CanalController {
    @Autowired
    private CanalService service;

    @PostMapping
    public CanalDTO save(@RequestBody @Valid CanalDTO dto) {
        return this.service.save(dto);
    }

    @GetMapping
    public List<CanalDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public CanalDTO findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @DeleteMapping("/{id}")
    public CanalDTO deleteById(@PathVariable Long id) {
        return this.service.deleteById(id);
    }

    @DeleteMapping
    public List<CanalDTO> deleteAll() {
        return this.service.deleteAll();
    }
}

package com.teste.processoseletivo.demo.controller;

import com.teste.processoseletivo.demo.entity.dto.CameraDTO;
import com.teste.processoseletivo.demo.service.CameraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/camera")
public class CameraController {
    @Autowired
    private CameraService service;

    @PostMapping
    public CameraDTO save(@Valid @RequestBody CameraDTO dto) {
        return this.service.save(dto);
    }

    @GetMapping
    public List<CameraDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public CameraDTO findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PutMapping("/{id}")
    public CameraDTO updateById(@PathVariable Long id, @RequestBody @Valid CameraDTO dto) {
        return this.service.updateById(id, dto);
    }

    @DeleteMapping("/{id}")
    public CameraDTO deleteById(@PathVariable Long id) {
        return this.service.deleteById(id);
    }

    @DeleteMapping
    public List<CameraDTO> deleteAll() {
        return this.service.deleteAll();
    }
}

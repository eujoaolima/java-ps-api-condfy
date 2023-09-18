package com.teste.processoseletivo.demo.service;

import com.teste.processoseletivo.demo.entity.Camera;
import com.teste.processoseletivo.demo.entity.dto.CameraDTO;
import com.teste.processoseletivo.demo.repository.CameraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CameraService {
	@Autowired
    private CameraRepository repository;
	
	@PostMapping("/camera")
    public CameraDTO save(@RequestBody CameraDTO dto) {
        Camera camera = CameraDTO.convert(dto);
        camera = this.repository.save(camera);
        return new CameraDTO(camera);
    }

	@GetMapping("/camera/{id}")
    public CameraDTO findById(@PathVariable Long id) {
        Optional<Camera> cameraOp = this.repository.findById(id);
        if (cameraOp.isEmpty()) {
            throw new RuntimeException("A câmera não foi encontrada");
        } else {
            Camera camera = cameraOp.get();
            camera.getCanais().size();
            return new CameraDTO(camera);
        }
    }

	@GetMapping("/camera")
    public List<CameraDTO> findAll() {
//      List<Camera> lista = this.repository.findAll();
        List<Camera> lista = this.repository.findAllByOrderByNomeAsc();
        return lista.stream().map(CameraDTO::new).collect(Collectors.toList());
    }
	
	@PutMapping("/camera/{id}")
    public CameraDTO updateById(Long id, CameraDTO dto) {
        this.findById(id);
        Camera camera = CameraDTO.convert(dto);
        this.repository.save(camera);
        camera.setId(id);
        return new CameraDTO(camera);
    }

	@DeleteMapping("/camera/{id}")
    public CameraDTO deleteById(Long id) {
        CameraDTO dto = findById(id);
        this.repository.deleteById(id);
        return dto;
    }
}

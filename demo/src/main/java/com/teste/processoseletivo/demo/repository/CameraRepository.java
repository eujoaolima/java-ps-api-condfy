package com.teste.processoseletivo.demo.repository;

import com.teste.processoseletivo.demo.entity.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import java.util.List;

@Repository
public interface CameraRepository extends JpaRepository<Camera, Long> {
    // public List<Camera> findAllByOrderByNomeAsc();
}

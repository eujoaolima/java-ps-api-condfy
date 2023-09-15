package com.teste.processoseletivo.demo.repository;

import com.teste.processoseletivo.demo.entity.Canal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanalRepository extends JpaRepository<Canal, Long> {
}

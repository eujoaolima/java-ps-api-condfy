package com.teste.processoseletivo.demo.config;

import com.teste.processoseletivo.demo.entity.Camera;
import com.teste.processoseletivo.demo.entity.Canal;
import com.teste.processoseletivo.demo.entity.dto.CameraDTO;
import com.teste.processoseletivo.demo.enums.Tipo;
import com.teste.processoseletivo.demo.repository.CameraRepository;
import com.teste.processoseletivo.demo.repository.CanalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

public class TestConfig implements CommandLineRunner {
    @Autowired
    private CameraRepository cameraRepository;
    @Autowired
    private CanalRepository canalRepository;

    @Override
    public void run(String... args) throws Exception {
        cameraRepository.deleteAll();
        canalRepository.deleteAll();
        System.out.println("Criando cameras...");
        Camera camera1 = new Camera(null, "Salão de jogos 1", Tipo.MAIN);
        Camera camera2 = new Camera(null, "Salão de jogos 2", Tipo.SUB);

        cameraRepository.saveAll(Arrays.asList(camera1, camera2));
        System.out.println("Canais criados!");

        System.out.println("--------------------------------");

        System.out.println("Criando canais...");
        Canal canal1 = new Canal(null, 1, "Sala");
        Canal canal2 = new Canal(null, 2, "Porta de entrada");
        Canal canal3 = new Canal(null, 3, "Corredor");

        camera1.getCanais().addAll(Arrays.asList(canal1, canal3));
        camera2.getCanais().addAll(Arrays.asList(canal1, canal2));

        canalRepository.saveAll(Arrays.asList(canal1, canal2, canal3));

        System.out.println("Canais criados!");
    }
}

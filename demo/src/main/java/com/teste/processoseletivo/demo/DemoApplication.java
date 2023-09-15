package com.teste.processoseletivo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Server running ;)");
	}

	/*
		ITENS A FAZER
		- Corrigir o relacionamento das entidades (1:N)

        - Desenvolver a listagem com filtro por nome
		- Testar tudo no POSTMAN


		*** CÂMERA ***
		- FindAll() OK
		- FindById() OK
		- Save() OK
		- UpdateById() OK
		- DeleteById() OK

		*** CANAL ***
		- FindAll() OK
		- FindById() OK
		- Save() OK
	*/

}

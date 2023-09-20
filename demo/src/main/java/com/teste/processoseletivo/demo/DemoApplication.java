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

		OBRIGATÓRIOS:
		- Corrigir o relacionamento das entidades (1:N)
		- Testar tudo no POSTMAN

		OPCIONAIS:
		- Adicionar lógica de numeração nos ENUMS (springboot-api -> orderstatus)
		- Adicionar tratamento de exceções


		*** CÂMERA ***
		- FindAll() -> Não reconhece o relacionamento, então o problema está quando você CRIA uma câmera
		- FindById() -> Não reconhece o relacionamento, então o problema está quando você CRIA uma câmera
		- Save() -> Encontrar o porquê de não estar criando o relacionamento entre Camera e Canal

		*** CANAL ***
		- FindAll() OK
		- FindById() OK
		- Save() OK
	*/

}

package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MorExemploSpringJpaApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MorExemploSpringJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MorExemploSpringJpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PessoaRepository repository) {
		return (args) -> {
			// Adiciona algumas pessoas no banco
			repository.save(new Pessoa("Jessica", "325.668.895-2", "10/10/2001", "Corumbataí"));
			repository.save(new Pessoa("Joselina", "345.555.234-4", "06/06/1977", "Capivari"));
			repository.save(new Pessoa("Jorge", "222.444.895-4", "02/10/1963", "Capivari"));
			repository.save(new Pessoa("Josiane", "456.455.222-2", "01/02/1991", "Alegre"));

			log.info("------- DEMONSTRAÇÃO -------");
			log.info("Pessoas encontradas com findAll():");
			log.info("-------------------------------");
			for (Pessoa pessoa : repository.findAll()) {
				log.info("Nome: " + pessoa.getNome() + " é de " + pessoa.getCidade());
			}
			log.info("------- FIM -------");

			// Busca pessoas de uma cidade
			log.info("Pessoas da cidade de Capivari");
			log.info("--------------------------------------------");
			for (Pessoa pessoa : repository.findByCidade("Capivari")) {
				log.info("Nome: " + pessoa.getNome() + " é de " + pessoa.getCidade());
			}
			log.info("------- FIM -------");
		};
	}

}

package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	public List<Pessoa> findByNome(String nome);
	
	public List<Pessoa> findByCidade(String cidade);
	
	public Pessoa findByCpf(String cpf);

}

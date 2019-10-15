package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {

	public Conta findByAgenciaAndNumero(String agencia, String numero);
	
	public Conta findByProprietariosCpf(String cpf);

}

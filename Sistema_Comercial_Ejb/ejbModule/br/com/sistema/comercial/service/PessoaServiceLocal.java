package br.com.sistema.comercial.service;


import java.util.List;

import javax.ejb.Local;

import br.com.sistema.comercial.entidade.Pessoa;

@Local
public interface PessoaServiceLocal {

	
List<Pessoa> recuperarPessoa();

List<Pessoa> recuperaPessoaPorNome(String nome);

Pessoa recupararPessoa(long documentoPrincipal);	
	
}

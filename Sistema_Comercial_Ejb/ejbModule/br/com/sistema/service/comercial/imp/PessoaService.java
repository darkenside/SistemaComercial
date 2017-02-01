package br.com.sistema.service.comercial.imp;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import br.com.sistema.comercial.entidade.Pessoa;

import br.com.sistema.comercial.dao.local.PessoaDAOLocal;
import br.com.sistema.comercial.service.PessoaServiceLocal;



@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PessoaService implements PessoaServiceLocal {

	@EJB
    private PessoaDAOLocal pessoa;
	
	@Override
	public List<Pessoa> recuperarPessoa() {
	
		
		return pessoa.recuperaPessoaPorNome("");
	}

	@Override
	public List<Pessoa> recuperaPessoaPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa recupararPessoa(long documentoPrincipal) {
		// TODO Auto-generated method stub
		return null;
	}


	

	
	

	
	
	

}
	

/*
 * Direitos de  cópia pela BRASILPREV
 *
 * Todos os direitos reservados.
 *
 * Este sistema contém informações confidenciais e de propriedade da
 * BRASILPREV ("Informações Confidenciais").
 * Você  não deve divulgar tais informações confidenciais e deve
 * usá-las somente em conformidade com os termos do contrato de licença
 * definidos pela BRASILPREV.
 */
package br.com.sistema.comercial.dao.local;

import java.util.List;

import javax.ejb.Local;

import br.com.sistema.comercial.dao.DAO;
import br.com.sistema.comercial.entidade.Pessoa;

/**
 * Interface EAO Local para a entidade DocumentoEmissao.
 */
@Local
public interface PessoaDAOLocal extends DAO<Pessoa,Long> {

    /**
     * Recupera todos os tipos cadastrados.
     *
     * @return list Lista de tipos encontrados.
     */
	Pessoa recupararPessoa(long documentoPrincipal);
	List<Pessoa> recuperaPessoaPorNome(String nome);
    
}

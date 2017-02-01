/*
 * Direitos de cópia pela BRASILPREV
 *
 * Todos os direitos reservados.
 *
 * Este sistema contém informações confidenciais e de propriedade da
 * BRASILPREV ("Informações Confidenciais").
 * Você não deve divulgar tais informações confidenciais e deve
 * usá-las somente em conformidade com os termos do contrato de licença
 * definidos pela BRASILPREV.
 */
package br.com.sistema.comercial.entidade;

import java.util.Date;

/**
 * Interface para entidades de dominio.
 * 
 * @param <PK> Id do dominio
 * @author Fornax Tecnologia
 */
public interface DominioEntity<PK> {

     /**
     * Obtém id.
     * 
     * @return id
     */
    public PK getId();

    /**
     * Obtém descricao.
     * 
     * @return descricao
     */
    public String getDescricao();


    /**
     * Obtém data atualizacao.
     * 
     * @return data atualizacao
     */
    public Date getDataAtualizacao();

    /**
     * Obtém status.
     * 
     * @return status
     */
    public String getStatus();

    /**
     * Obtém nome.
     * 
     * @return nome
     */
    public String getNome();
}

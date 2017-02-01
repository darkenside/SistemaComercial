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
package br.com.sistema.comercial.dao;

import java.io.Serializable;




/**
 * Interface EAO.
 *
 */
public interface DAO<T, PK extends Serializable> {
    
    /**
     * Persist.
     *
     * @param t o t
     */
    void persist(T t);

    /**
     * Find.
     *
     * @param pk o pk
     * @return t
     */
    T find(PK pk);

    /**
     * Merge.
     *
     * @param t o t
     * @return t
     */
    T merge(T t);

    /**
     * Removes the.
     *
     * @param t o t
     */
    void remove(T t);

    /**
     * Refresh.
     *
     * @param t o t
     * @return t
     */
    T refresh(T t);
 }
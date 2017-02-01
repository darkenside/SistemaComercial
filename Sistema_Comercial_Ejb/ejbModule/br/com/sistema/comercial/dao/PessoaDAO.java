package br.com.sistema.comercial.dao;




import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.sistema.comercial.dao.local.PessoaDAOLocal;
import br.com.sistema.comercial.entidade.Pessoa;


@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PessoaDAO extends AbstractGenericDAO<Pessoa,Long> implements  PessoaDAOLocal {

	public PessoaDAO() {
		super(Pessoa.class);
		// TODO Auto-generated constructor stub
	}

	private static final String SQL_RECUPERAR_POR_NOME = 
			"Pessoa.recuperar";
	//private static final String SQL_RECUPERAR_RESGATE_ATIVO = 
	//		"resgateDotal.recuperaAberturaResgateAtivo";
	
	

	/**
	 * Recupera dados Resgate.
	 * @return List<RequisicaoResgateDotalVO>
	 * @param Long
	 */
	
	/*
	@SuppressWarnings("unchecked")
	public List<Pessoa> recuperarDadosResgate(Long idProposta, Date dataAtual) {

		List<RequisicaoResgateDotalVO> lista =
				((Session) getEntityManager().getDelegate())
						.createSQLQuery(createNamedQueryAsString(SQL_RECUPERAR_DADOS_RESGATE))
						.addScalar("numeroApolice", Hibernate.LONG)
						.addScalar("pessoaNome", Hibernate.STRING)
						.addScalar("dadoBancarioBase", Hibernate.LONG)
						.addScalar("codigoMorte", Hibernate.LONG)
						.addScalar("codigoIpa", Hibernate.LONG)
						.addScalar("codigoSobrevivencia", Hibernate.LONG)
						.addScalar("cpf", Hibernate.LONG)
						.addScalar("dataInicioVigencia", Hibernate.DATE)
						.addScalar("vlMorte", Hibernate.BIG_DECIMAL)
						.addScalar("vlIpa", Hibernate.BIG_DECIMAL)
						.addScalar("vlSobrevivencia", Hibernate.BIG_DECIMAL)
						.addScalar("reservaMorte", Hibernate.BIG_DECIMAL)
						.addScalar("valorApuradoMorte", Hibernate.BIG_DECIMAL)
						.addScalar("valorCota", Hibernate.BIG_DECIMAL)
						.addScalar("reservaSobrevivencia", Hibernate.BIG_DECIMAL)
						.addScalar("reservaInvalidez", Hibernate.BIG_DECIMAL)
						.addScalar("tipoPlanoSobrevivencia", Hibernate.STRING)
						.addScalar("tipoPlanoMorte", Hibernate.STRING)
						.addScalar("tipoPlanoIpa", Hibernate.STRING)
						.addScalar("nomeSobrevivencia", Hibernate.STRING)
						.addScalar("nomeMorte", Hibernate.STRING)
						.addScalar("nomeIpa", Hibernate.STRING)
						.setParameter("proposta", idProposta)
						.setParameter("dataAtual", dataAtual)
						.setResultTransformer(Transformers.aliasToBean(RequisicaoResgateDotalVO.class))
						.list();

		return lista;

	}
     /**
	 * Recupera Resgate Dotal a partir do status.
	 * @return List<ResgateDotal>
	 * @param Long
	
	@SuppressWarnings("unchecked")
	public List<ResgateDotal> recuperaResgateAtivo(Long idProposta, List<Integer> tipo) {

		List<ResgateDotal> result =
				((Session) getEntityManager().getDelegate())
						.createSQLQuery(createNamedQueryAsString(SQL_RECUPERAR_RESGATE_ATIVO))
						.addEntity("resgate", ResgateDotal.class)
						.setParameter("proposta", idProposta)
						.setParameterList("tipo", tipo)
						.list();

		return result;

	}
	 */
	
    /**
	 * Recupera Resgate Dotal a partir do status.
	 * @return List<ResgateDotal>
	 * @param Long
	 */
	
	
	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<Pessoa> recuperaPessoaPorNome(String nome) {

		
		
		
		final TypedQuery<Pessoa> query = 
               createNamedQuery(SQL_RECUPERAR_POR_NOME); 

	List<Pessoa> p =query.getResultList();
      
		return p;

	}
	

	
	@SuppressWarnings("unchecked")
	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public Pessoa recupararPessoa(long documentoPrincipal) {
		Query query = createNamedQuery("Pessoa.recuperar");
		List<Pessoa> pessoas = null;

		//query.setParameter("documentoPrincipal", documentoPrincipal);

		pessoas = query.getResultList();

		if (!pessoas.isEmpty()) {
			return pessoas.get(0);
		}

		return null;
	}



	@Override
	public void persist(Pessoa t) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Pessoa find(Long pk) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Pessoa merge(Pessoa t) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void remove(Pessoa t) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public Pessoa refresh(Pessoa t) {
		// TODO Auto-generated method stub
		return null;
	}













	
	
/**
 * 
 * @param ano
 * @return

	public Long recuperarCarregamentoSobrevivencia(Long ano, Long carregamento) {

		Query query = createNamedQuery(SQL_RECUPERA_CARREGAMENTO);
		query.setParameter("anoVigencia", ano);
		query.setParameter("carregamento", carregamento);
		
		return (Long) query.getSingleResult();

	}
	 */
}

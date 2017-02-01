package br.com.sistema.comercial.WebBean;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;

import javax.inject.Inject;

import org.primefaces.model.UploadedFileWrapper;

import br.com.sistema.comercial.entidade.Pessoa;
import br.com.sistema.comercial.leitura.arquivo.MessagesUtil;
import br.com.sistema.comercial.service.FtpServiceLocal;
import br.com.sistema.comercial.service.PessoaServiceLocal;




@ManagedBean(name = "pessoaBean")
@ConversationScoped 
public class PessoaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 @Inject
	private PessoaServiceLocal pessoaServiceLocal;

	// @Inject
   //  private FtpServiceLocal ftpServiceLocal;
	
	 @Inject
	 private Conversation conversation;
	 
	public Conversation getConversation() {
		return conversation;
	}


	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	private  Pessoa p = new Pessoa();
	 
	private UploadedFileWrapper imagem = new UploadedFileWrapper();
	
	public void recuperaPessoa(){
		List<Pessoa> pessoaList = new ArrayList<Pessoa>();
		
		pessoaList = pessoaServiceLocal.recuperarPessoa();
		
		p= pessoaList.get(0);
	
	}

	
	public Pessoa getP() {
		return p;
	}


	public void setP(Pessoa p) {
		this.p = p;
	}


	public void upparImagem (){
	
	if(imagem != null){}
	/*	try {
			//ftpServiceLocal.salvarImagem(imagem.getInputstream(),1L);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	*/
	
	}
	public String downloadImage(){
		
	
	//	return ftpServiceLocal.recupararImagem(1L).getPath();
	
return"";

		
	}
	
	public String retornaMensagem(String chave){
		
	return	MessagesUtil.getValorProper(chave);
		
	}
	
	
	

	public UploadedFileWrapper getImagem() {
		return imagem;
	}


	public void setImagem(UploadedFileWrapper imagem) {
		this.imagem = imagem;
	}
	
	
	
	public void initConversation() {

		if (conversation.isTransient()) {

			conversation.begin();
			conversation.setTimeout(900000L);
		}

	}

	public void endConversation() {
		if (!conversation.isTransient()) {
			conversation.end();
		}

	}

}
package br.com.sistema.comercial.leitura.arquivo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import com.sun.jndi.toolkit.url.Uri;





public class MessagesUtil implements Serializable {

	public static final String MESSAGES = "/META-INF/messages.properties";

	public static final String PATH = "resources";

	private static final long serialVersionUID = 1L;
	private static Properties props;
	private  Properties propert;

	private static Properties carregaArquivo() {
		props = new Properties();

		URL path=null;
		path=MessagesUtil.class.getClassLoader().getResource(MESSAGES);

		File msg = null;
		
			msg = new File(path.getFile());
		
		
		try {
			FileInputStream in = new FileInputStream(msg);
			props.load(in);
			in.close();

		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return props;
	}
	
	private  Properties carregaArquivoMsg() {
		Properties props = new Properties();

		String path=null;
		try {
			path = new File(MESSAGES).getCanonicalPath();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		File msg = new File(path);
		
		try {
			FileInputStream in = new FileInputStream(msg);
			props.load(in);
			in.close();

		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return props;
	}

	public  String getValor(String chave) {
		if (propert == null) {

			propert = carregaArquivoMsg();
		}

		return (String) propert.getProperty(chave);
	}
	
	
	public static String getValorProper(String chave) {
		if (props == null) {

			props = carregaArquivo();
		}

		return (String) props.getProperty(chave);
	}
}
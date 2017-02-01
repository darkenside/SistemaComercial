package br.com.sistema.comercial.service;


import java.io.File;
import java.io.InputStream;

import javax.ejb.Local;

import org.apache.commons.net.ftp.FTPClient;


@Local
public interface FtpServiceLocal {

File recupararImagem(Long idImagem);	
void salvarImagem (InputStream inputStream,Long Id);
void fecharConexao(FTPClient ftpClient);
FTPClient abrirConexaoFtp();

}

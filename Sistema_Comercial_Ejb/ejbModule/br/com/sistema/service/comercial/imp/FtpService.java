package br.com.sistema.service.comercial.imp;



import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedOutputStream;
import java.net.SocketException;


import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import br.com.sistema.comercial.service.FtpServiceLocal;




@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FtpService implements FtpServiceLocal {

	@Override
	public File recupararImagem(Long idImagem) {

		 String server = "127.0.0.1";
	        int port = 21;
	        String user = "user1";
	        String pass = "327536";
	        File downloadFile1=null;
			try {
				downloadFile1 = File.createTempFile("img_"+idImagem, ".jpg");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        FTPClient ftpClient = new FTPClient();
	        try {
	 
	            ftpClient.connect(server, port);
	            ftpClient.login(user, pass);
	            ftpClient.enterLocalPassiveMode();
	            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	 
	            // APPROACH #1: using retrieveFile(String, OutputStream)
	            String remoteFile1 = idImagem+".jpg";
	            
	            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
	            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
	            outputStream1.close();
	 
	            if (success) {
	                System.out.println("File #1 has been downloaded successfully.");
	            }
	 
	           
	 
	        } catch (IOException ex) {
	            System.out.println("Error: " + ex.getMessage());
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (ftpClient.isConnected()) {
	                    ftpClient.logout();
	                    ftpClient.disconnect();
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
     return downloadFile1;
	}
	
	@Override
	public  FTPClient abrirConexaoFtp(){
		String server = "127.0.0.1";
        int port = 21;
        String user = "user1";
        String pass = "327536";
        
       FTPClient ftpClient = new FTPClient();
        
        try {
        	
			ftpClient.connect(server, port);
			ftpClient.login(user, pass);
	        ftpClient.enterLocalPassiveMode();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return ftpClient;
	}
	
	@Override
	public void fecharConexao(FTPClient ftpClient){
		
		 if (ftpClient.isConnected()) {
             try {
				ftpClient.logout();
				ftpClient.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             
         }
		
	}
	

	@Override
	public void salvarImagem(InputStream inputStream,Long id) {
		
		 String server = "127.0.0.1";
	        int port = 21;
	        String user = "user1";
	        String pass = "327536";
	 
	        FTPClient ftpClient = new FTPClient();
	        try {
	 
	            ftpClient.connect(server, port);
	            ftpClient.login(user, pass);
	            ftpClient.enterLocalPassiveMode();
	 
	            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	 
	 
	            String firstRemoteFile = ""+id+".jpg";
	            
	 
	            System.out.println("Start uploading first file");
	            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
	            inputStream.close();
	            if (done) {
	                System.out.println("The first file is uploaded successfully.");
	            }
	 
	            /* APPROACH #2: uploads second file using an OutputStream
	            File secondLocalFile = new File("E:/Test/Report.doc");
	            String secondRemoteFile = "test/Report.doc";
	            inputStream = new FileInputStream(secondLocalFile);
	 
	            System.out.println("Start uploading second file");
	            OutputStream outputStream = ftpClient.storeFileStream(secondRemoteFile);
	            byte[] bytesIn = new byte[4096];
	            int read = 0;
	 
	            while ((read = inputStream.read(bytesIn)) != -1) {
	                outputStream.write(bytesIn, 0, read);
	            }
	            inputStream.close();
	            outputStream.close();
	 
	            boolean completed = ftpClient.completePendingCommand();
	            if (completed) {
	                System.out.println("The second file is uploaded successfully.");
	            }*/
	 
	        } catch (IOException ex) {
	            System.out.println("Error: " + ex.getMessage());
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (ftpClient.isConnected()) {
	                    ftpClient.logout();
	                    ftpClient.disconnect();
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
		
		
		
	}



	

	
	

	
	
	

}
	

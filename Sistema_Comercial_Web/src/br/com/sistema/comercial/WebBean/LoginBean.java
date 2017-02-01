package br.com.sistema.comercial.WebBean;


import java.io.Serializable;
import java.security.Principal;

 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
@ManagedBean(name="loginBean")
@javax.faces.bean.ViewScoped
public class LoginBean implements Serializable {
 
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String username;
public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}


private String password;

 
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
 
public LoginBean(){
   if(session != null){
   session.invalidate();
  }
}
 
public String login(){
   String message = "";
 
   try {
 
   request.login(username, password);
   Principal principal = request.getUserPrincipal();
 
   if(request.isUserInRole("Administrador")){
     message = "Usuário : " + principal.getName() + " Você é Administrador e tem direito a todos as funcionalidades!";
 
   }else if(request.isUserInRole("usuario")){
     message = "Usuário : " + principal.getName() + "Você é um usuario padrão!";
 
   }
 
  FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
 
  return "index";
 
  } catch (ServletException e) {
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocorreu algum problema e o Login Falhou!", null));
    e.printStackTrace();
 }
   return null;
 }
 

public String logout(){
	   if(session != null){
	     session.invalidate();
	 }                                                                                                                                                     

	   return "logout";
	 
}
	 






}
 
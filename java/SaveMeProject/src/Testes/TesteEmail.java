package Testes;

import Funcoes.EnviarEmail;

public class TesteEmail {

	/*public static void main(String[] args) { 
	     
	enviar();
	}*/
	 public void enviar(){
		    String to = "diego93rocha@gmail.com";
		    String subject = "SaveMe";  
		    String msg = "Um usuário precisa da sua ajuda!";  
		          
		    EnviarEmail.send(to, subject, msg);
		      }

}

package Interfaces;

import java.util.List;

import Dados.Usuario;

public interface InterfaceUsuarioDAO {

	public abstract Usuario getByLogAndSen (String login, String senha);
	public abstract List<Usuario> getByLogSen (String login, String senha);
	
}

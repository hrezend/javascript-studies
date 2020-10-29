package Dados;

import javax.persistence.Entity;
import javax.persistence.Table;

import Persistencia.ContatosDAO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@Table(name="Contatos")
@NamedQueries({
	@NamedQuery(name="consultarContatoPorIdU",query="From Contatos c where "
			+ "c.usuario.IdUsuario = :idUsuario " )	
})

public class Contatos {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="IdContato")
private int IdContato;

@Column
private String NomeContato;

@Column
private String TelefoneContato;

@Column
private String EmailContato;

@ManyToOne
@JoinColumn(name="IdUsuario")
private Usuario usuario;



public int getIdContato() {
	return IdContato;
}

public void setIdContato(int idContato) {
	IdContato = idContato;
}

public String getNomeContato() {
	return NomeContato;
}

public void setNomeContato(String nomeContato) {
	NomeContato = nomeContato;
}

public String getTelefoneContato() {
	return TelefoneContato;
}

public void setTelefoneContato(String telefoneContato) {
	TelefoneContato = telefoneContato;
}

public String getEmailContato() {
	return EmailContato;
}

public void setEmailContato(String emailContato) {
	EmailContato = emailContato;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario){
	this.usuario = usuario;
}


public List<Contatos> ConsultarPorId(int IdUsuario){
    List<Contatos> contatos = new ContatosDAO().ConsultarPorId(IdUsuario);
    return contatos;        
}
public boolean insert(){
	new ContatosDAO().add(this);
	return true;
}
public boolean delete(){
	new ContatosDAO().delete(IdContato);
	return true;
}
public boolean update(){
	new ContatosDAO().update(this);
	return true;
}

}
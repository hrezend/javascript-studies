package Dados;

import javax.persistence.Entity;
import javax.persistence.Table;

import Persistencia.AlergiaDAO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity(name="Alergias")
@Table(name="Alergias")
@NamedQueries({
	@NamedQuery(name="consultarAlergiaPorIdU",query="From Alergias a where "
			+ "a.usuario.IdUsuario = :idUsuario " )
})

public class Alergia {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="IdAlergia")
private int IdAlergia;

@Column
private String DescricaoAlergia;

@ManyToOne
@JoinColumn(name="IdUsuario")
private Usuario usuario;



public int getIdAlergia() {
	return IdAlergia;
}

public void setIdAlergia(int idAlergia) {
	IdAlergia = idAlergia;
}

public String getDescricaoAlergia() {
	return DescricaoAlergia;
}

public void setDescricaoAlergia(String descricaoAlergia) {
	DescricaoAlergia = descricaoAlergia;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}

public List<Alergia> ConsultarPorId(int IdUsuario) {
    
    List<Alergia> alergias = new AlergiaDAO().ConsultarPorId(IdUsuario);
    return alergias;        
}

public boolean insert(){
	new AlergiaDAO().add(this);
	return true;
}
public boolean delete(){
	new AlergiaDAO().delete(IdAlergia);
	return true;
}

public boolean update(){
	new AlergiaDAO().update(this);
	return true;
}

}

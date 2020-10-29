package Dados;

import javax.persistence.Entity;
import javax.persistence.Table;
import Persistencia.RemedioDAO;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity(name="Remedios")
@Table(name="Remedios")
@NamedQueries({
	@NamedQuery(name="consultarRemedioPorIdU",query="From Remedios r where "
			+ "r.usuario.IdUsuario = :idUsuario " )
})

public class Remedio {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="IdRemedio")
private int IdRemedio;

@Column
private String NomeRemedio;

@Column
private String DescricaoUso;

@ManyToOne
@JoinColumn(name="IdUsuario")
private Usuario usuario;


public int getIdRemedio() {
	return IdRemedio;
}

public void setIdRemedio(int idRemedio) {
	IdRemedio = idRemedio;
}

public String getNomeRemedio() {
	return NomeRemedio;
}

public void setNomeRemedio(String nomeRemedio) {
	NomeRemedio = nomeRemedio;
}

public String getDescricaoUso() {
	return DescricaoUso;
}

public void setDescricaoUso(String descricaoUso) {
	DescricaoUso = descricaoUso;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}


public List<Remedio> ConsultarPorId(int IdUsuario) {
    List<Remedio> remedios = new RemedioDAO().ConsultarPorId(IdUsuario);
    return remedios;        
}
public boolean insert(){
	new RemedioDAO().add(this);
	return true;
}
public boolean delete(){
	new RemedioDAO().delete(IdRemedio);
	return true;
}
public boolean update(){
	new RemedioDAO().update(this);
	return true;
}


}

package Dados;

import javax.persistence.Entity;
import javax.persistence.Table;

import Persistencia.FarmaciaDAO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity(name="Farmacias")
@Table(name="Farmacias")
@NamedQueries({
	@NamedQuery(name="consultarFarmaciaPorIdU",query="From Farmacias f where "
			+ "f.usuario.IdUsuario = :idUsuario " )
})

public class Farmacia {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="IdFarmacia")
private int IdFarmacia;

@Column
private String NomeFarmacia;

@Column
private String LocalizacaoFarmacia;

@ManyToOne
@JoinColumn(name="IdUsuario")
private Usuario usuario;




public int getIdFarmacia() {
	return IdFarmacia;
}

public void setIdFarmacia(int idFarmacia) {
	IdFarmacia = idFarmacia;
}

public String getNomeFarmacia() {
	return NomeFarmacia;
}

public void setNomeFarmacia(String nomeFarmacia) {
	NomeFarmacia = nomeFarmacia;
}

public String getLocalizacaoFarmacia() {
	return LocalizacaoFarmacia;
}

public void setLocalizacaoFarmacia(String localizacaoFarmacia) {
	LocalizacaoFarmacia = localizacaoFarmacia;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}
public List<Farmacia> ConsultarPorId(int IdUsuario) {
    List<Farmacia> farmacias = new FarmaciaDAO().ConsultarPorId(IdUsuario);
    return farmacias;        
}
public boolean insert(){
	new FarmaciaDAO().add(this);
	return true;
}
public boolean delete(){
	new FarmaciaDAO().delete(IdFarmacia);
	return true;
}
public boolean update(){
	new FarmaciaDAO().update(this);
	return true;
}


}

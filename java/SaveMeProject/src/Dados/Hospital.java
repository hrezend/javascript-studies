package Dados;

import javax.persistence.Entity;
import javax.persistence.Table;

import Persistencia.HospitalDAO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity(name="Hospitais")
@Table(name="Hospitais")
@NamedQueries({
	@NamedQuery(name="consultarHospitalPorIdU",query="From Hospitais h where "
			+ "h.usuario.IdUsuario = :idUsuario " )
})

public class Hospital {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="IdHospital")
private int IdHospital;

@Column
private String NomeHospital;

@Column
private String LocalizacaoHospital;

@ManyToOne
@JoinColumn(name="IdUsuario")
private Usuario usuario;



public int getIdHospital() {
	return IdHospital;
}

public void setIdHospital(int idHospital) {
	IdHospital = idHospital;
}

public String getNomeHospital() {
	return NomeHospital;
}

public void setNomeHospital(String nomeHospital) {
	NomeHospital = nomeHospital;
}

public String getLocalizacaoHospital() {
	return LocalizacaoHospital;
}

public void setLocalizacaoHospital(String localizacaoHospital) {
	LocalizacaoHospital = localizacaoHospital;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}

public List<Hospital> ConsultarPorId(int IdUsuario) {
    List<Hospital> hospitais = new HospitalDAO().ConsultarPorId(IdUsuario);
    return hospitais;        
}
public boolean insert(){
	new HospitalDAO().add(this);
	return true;
}
public boolean delete(){
	new HospitalDAO().delete(IdHospital);
	return true;
}
public boolean update(){
	new HospitalDAO().update(this);
	return true;
}


}

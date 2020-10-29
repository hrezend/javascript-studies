package Dados;

import javax.persistence.Entity;
import javax.persistence.Table;

import Persistencia.ConsultaFuturaDAO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity(name="ConsultasFuturas")
@Table(name="ConsultasFuturas")
@NamedQueries({
	@NamedQuery(name="consultarConsultaFPorIdU",query="From ConsultasFuturas cf where "
			+ "cf.usuario.IdUsuario = :idUsuario " )
})

public class ConsultaFutura {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="IdConsultaFutura")
private int IdConsultaFutura;

@Column
private String DataConsultaFutura;

@Column
private String HospitalConsultaFutura;

@Column
private String EspecialidadeConsultaFutura;

@ManyToOne
@JoinColumn(name="IdUsuario")
private Usuario usuario;





public int getIdConsultaFutura() {
	return IdConsultaFutura;
}

public void setIdConsultaFutura(int idConsultaFutura) {
	IdConsultaFutura = idConsultaFutura;
}

public String getDataConsultaFutura() {
	return DataConsultaFutura;
}

public void setDataConsultaFutura(String dataConsultaFutura) {
	DataConsultaFutura = dataConsultaFutura;
}

public String getHospitalConsultaFutura() {
	return HospitalConsultaFutura;
}

public void setHospitalConsultaFutura(String hospitalConsultaFutura) {
	HospitalConsultaFutura = hospitalConsultaFutura;
}

public String getEspecialidadeConsultaFutura() {
	return EspecialidadeConsultaFutura;
}

public void setEspecialidadeConsultaFutura(String especialidadeConsultaFutura) {
	EspecialidadeConsultaFutura = especialidadeConsultaFutura;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}


public List<ConsultaFutura> ConsultarPorIdU(int IdUsuario){
    List<ConsultaFutura> consultasfuturas = new ConsultaFuturaDAO().ConsultarPorId(IdUsuario);
    return consultasfuturas;        
}
public boolean insert(){
	new ConsultaFuturaDAO().add(this);
	return true;
}
public boolean delete(){
	new ConsultaFuturaDAO().delete(IdConsultaFutura);
	return true;
}
public boolean update(){
	new ConsultaFuturaDAO().update(this);
	return true;
}



}

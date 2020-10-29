package Dados;

import javax.persistence.Entity;
import javax.persistence.Table;

import Persistencia.ConsultaRealizadaDAO;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity(name="ConsultasRealizadas")
@Table(name="ConsultasRealizadas")
@NamedQueries({
	@NamedQuery(name="consultarConsultaRPorIdU",query="From ConsultasRealizadas cr where "
			+ "cr.usuario.IdUsuario = :idUsuario " )
})

public class ConsultaRealizada {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="IdConsultaRealizada")
private int IdConsultaRealizada;

@Column
private String DataConsultaRealizada;

@Column
private String HospitalConsultaRealizada;

@Column
private String EspecialidadeConsultaRealizada;

@Column
private String DiagnosticoConsultaRealizada;

@ManyToOne
@JoinColumn(name="IdUsuario")
private Usuario usuario;




public int getIdConsultaRealizada() {
	return IdConsultaRealizada;
}

public void setIdConsultaRealizada(int idConsultaRealizada) {
	IdConsultaRealizada = idConsultaRealizada;
}

public String getDataConsultaRealizada() {
	return DataConsultaRealizada;
}

public void setDataConsultaRealizada(String dataConsultaRealizada) {
	DataConsultaRealizada = dataConsultaRealizada;
}

public String getHospitalConsultaRealizada() {
	return HospitalConsultaRealizada;
}

public void setHospitalConsultaRealizada(String hospitalConsultaRealizada) {
	HospitalConsultaRealizada = hospitalConsultaRealizada;
}

public String getEspecialidadeConsultaRealizada() {
	return EspecialidadeConsultaRealizada;
}

public void setEspecialidadeConsultaRealizada(String especialidadeConsultaRealizada) {
	EspecialidadeConsultaRealizada = especialidadeConsultaRealizada;
}

public String getDiagnosticoConsultaRealizada() {
	return DiagnosticoConsultaRealizada;
}

public void setDiagnosticoConsultaRealizada(String diagnosticoConsultaRealizada) {
	DiagnosticoConsultaRealizada = diagnosticoConsultaRealizada;
}

public Usuario getUsuario() {
	return usuario;
}

public void setUsuario(Usuario usuario) {
	this.usuario = usuario;
}


public List<ConsultaRealizada> ConsultarPorId(int IdUsuario) {
    List<ConsultaRealizada> consultasrealizadas = new ConsultaRealizadaDAO().ConsultarPorId(IdUsuario);
    return consultasrealizadas;        
}
public boolean insert(){
	new ConsultaRealizadaDAO().add(this);
	return true;
}
public boolean delete(){
	new ConsultaRealizadaDAO().delete(IdConsultaRealizada);
	return true;
}
public boolean update(){
	new ConsultaRealizadaDAO().update(this);
	return true;
}

}

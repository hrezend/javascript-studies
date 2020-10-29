package Dados;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import Persistencia.UsuarioDAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
@Table(name="Usuarios")

public class Usuario {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="IdUsuario")
private int IdUsuario;

@Column
private String NomeUsuario;

@Column(unique=true)
private String RgUsuario;

@Column(unique=true)
private String CpfUsuario;

@Column
private String DataNascUsuario;

@Column
private String TelefoneUsuario;

@Column
private String EnderecoUsuario;

@Column(unique=true, nullable=false)
private String LoginUsuario;

@Column(nullable=false)
private String SenhaUsuario;

@Column(unique=true)
private String EmailUsuario;

@Column
private String SexoUsuario;

@Column
private String EstCivilUsuario;

@Column
private String CidadeUsuario;

@Column
private String UfUsuario;

@Column
private String CepUsuario;

@Column
private String TipoSangueUsuario;

@Column
private String DiabeticoUsuario;

@Column 
private String DependenciaUsuario;

@Column
private String HipertensaoUsuario;

@Column
private String DoencaVenereaUsuario;

@Column
private String PesoUsuario;

@Column
private String AlturaUsuario;

@Column
private String ColesterolUsuario;

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="usuario")
private List<Alergia> alergias = new ArrayList<>();

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="usuario")
private List<Remedio> remedios = new ArrayList<>();

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="usuario")
private List<Hospital> hospitais = new ArrayList<>();

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="usuario")
private List<Farmacia> farmacias = new ArrayList<>();

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="usuario")
private List<ConsultaRealizada> consultasrealizadas = new ArrayList<>();

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="usuario")
private List<ConsultaFutura> consultasfuturas = new ArrayList<>();

@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="usuario")
private List<Contatos> contatos = new ArrayList<>();



public List<Contatos> getContatos() {
    return Collections.unmodifiableList(contatos);
}
public void addContatos(Contatos contatos) {
    this.contatos.add(contatos);
}
public List<ConsultaFutura> getConsultaFutura() {
    return Collections.unmodifiableList(consultasfuturas);
}
public void addConsultaFutura(ConsultaFutura consultasfuturas) {
    this.consultasfuturas.add(consultasfuturas);
}
public List<ConsultaRealizada> getConsultaRealizada() {
    return Collections.unmodifiableList(consultasrealizadas);
}
public void addConsultaRealizada(ConsultaRealizada consultasrealizadas) {
    this.consultasrealizadas.add(consultasrealizadas);
}
public List<Farmacia> getFarmacia() {
    return Collections.unmodifiableList(farmacias);
}
public void addFarmacia(Farmacia farmacias) {
    this.farmacias.add(farmacias);
}
public List<Hospital> getHospital() {
    return Collections.unmodifiableList(hospitais);
}
public void addHospital(Hospital hospitais) {
    this.hospitais.add(hospitais);
}
public List<Remedio> getRemedio() {
    return Collections.unmodifiableList(remedios);
}
public void addRemedio(Remedio remedios) {
    this.remedios.add(remedios);
}
public List<Alergia> getAlergia() {
    return Collections.unmodifiableList(alergias);
}
public void addAlergia(Alergia alergias) {
    this.alergias.add(alergias);
}
public String getDiabeticoUsuario() {
	return DiabeticoUsuario;
}
public void setDiabeticoUsuario(String diabeticoUsuario) {
	DiabeticoUsuario = diabeticoUsuario;
}
public String getDependenciaUsuario() {
	return DependenciaUsuario;
}
public void setDependenciaUsuario(String dependenciaUsuario) {
	DependenciaUsuario = dependenciaUsuario;
}
public String getHipertensaoUsuario() {
	return HipertensaoUsuario;
}
public void setHipertensaoUsuario(String hipertensaoUsuario) {
	HipertensaoUsuario = hipertensaoUsuario;
}
public String getTipoSangueUsuario() {
	return TipoSangueUsuario;
}
public void setTipoSangueUsuario(String tipoSangueUsuario) {
	TipoSangueUsuario = tipoSangueUsuario;
}
public String getDoencaVenereaUsuario() {
	return DoencaVenereaUsuario;
}
public void setDoencaVenereaUsuario(String doencaVenereaUsuario) {
	DoencaVenereaUsuario = doencaVenereaUsuario;
}
public String getPesoUsuario() {
	return PesoUsuario;
}
public void setPesoUsuario(String pesoUsuario) {
	PesoUsuario = pesoUsuario;
}
public String getAlturaUsuario() {
	return AlturaUsuario;
}
public void setAlturaUsuario(String alturaUsuario) {
	AlturaUsuario = alturaUsuario;
}
public String getColesterolUsuario() {
	return ColesterolUsuario;
}
public void setColesterolUsuario(String colesterolUsuario) {
	ColesterolUsuario = colesterolUsuario;
}
public String getEstCivilUsuario() {
	return EstCivilUsuario;
}
public void setEstCivilUsuario(String estCivilUsuario) {
	EstCivilUsuario = estCivilUsuario;
}
public String getCidadeUsuario() {
	return CidadeUsuario;
}
public void setCidadeUsuario(String cidadeUsuario) {
	CidadeUsuario = cidadeUsuario;
}
public String getUfUsuario() {
	return UfUsuario;
}
public void setUfUsuario(String ufUsuario) {
	UfUsuario = ufUsuario;
}
public String getCepUsuario() {
	return CepUsuario;
}
public void setCepUsuario(String cepUsuario) {
	this.CepUsuario = cepUsuario;
}
public String getNomeUsuario(){
	return NomeUsuario;
}
public void setNomeUsuario(String nomeUsuario) {
	NomeUsuario = nomeUsuario;
}
public String getRgUsuario() {
	return RgUsuario;
}
public void setRgUsuario(String rgUsuario) {
	RgUsuario = rgUsuario;
}
public String getDataNascUsuario() {
	return DataNascUsuario;
}
public void setDataNascUsuario(String dataNascUsuario) {
	DataNascUsuario = dataNascUsuario;
}
public String getTelefoneUsuario() {
	return TelefoneUsuario;
}
public void setTelefoneUsuario(String telefoneUsuario) {
	TelefoneUsuario = telefoneUsuario;
}
public String getEnderecoUsuario() {
	return EnderecoUsuario;
}
public void setEnderecoUsuario(String enderecoUsuario) {
	EnderecoUsuario = enderecoUsuario;
}
public String getLoginUsuario() {
	return LoginUsuario;
}
public void setLoginUsuario(String loginUsuario) {
	LoginUsuario = loginUsuario;
}
public String getSenhaUsuario() {
	return SenhaUsuario;
}
public void setSenhaUsuario(String senhaUsuario) {
	SenhaUsuario = senhaUsuario;
}
public String getEmailUsuario() {
	return EmailUsuario;
}
public void setEmailUsuario(String emailUsuario) {
	EmailUsuario = emailUsuario;
}
public String getSexoUsuario() {
	return SexoUsuario;
}
public void setSexoUsuario(String sexoUsuario) {
	SexoUsuario = sexoUsuario;
}
public String getCpfUsuario() {
	return CpfUsuario;
}
public void setCpfUsuario(String cpfUsuario) {
	CpfUsuario = cpfUsuario;
}
public int getIdUsuario() {
	return IdUsuario;
}
public void setIdUsuario(int Id) {
	IdUsuario = Id;
}

public boolean insert(){
	new UsuarioDAO().add(this);
	return true;
}

public boolean update(){
	new UsuarioDAO().update(this);
	return true;
}
public boolean delete(){
	new UsuarioDAO().delete(IdUsuario);
	return true;
}
public List<Usuario> getByLog(String login) {
	UsuarioDAO dao = new UsuarioDAO();
    List <Usuario> usuario = dao.getByLog(login);
    return usuario;
}

}

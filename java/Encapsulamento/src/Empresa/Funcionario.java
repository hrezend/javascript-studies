package Empresa;

public abstract class Funcionario {

	private double salario;
	private double horaExtra;
	private String nome;


	public void setSalario (double Salario){
		this.salario = salario;
	}
	public void setHoraExtra (double horaExtra){
		this.horaExtra = horaExtra;
	}
	public void setNome (String nome){
		this.nome = nome;
	}
	public double calculaSalario (){
		return salario + horaExtra;
	}

	public double getSalario (){
		return this.salario;
	}
	public double getHoraExtra (){
		return this.horaExtra;
	}
	public String getNome (){
		return this.nome;
	}


}
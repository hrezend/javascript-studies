package Empresa;

public class Gerente extends Funcionario {

	public double calculaSalario (){
		return (getSalario() + getHoraExtra() * 1.3); 
	}
	
	public double calculaDiferença (){
		return super.calculaSalario() - calculaSalario();
	}
}
package Empresa;

public class Principal {

	public static void main(String[] args) {

		Gerente g = new Gerente ();
		Diretor d = new Diretor ();
		
		System.out.println("Gerente: " + g.calculaSalario());
		System.out.println("Diretor: " + d.calculaSalario());
		
		g.setSalario(1000);
		d.setSalario(2000);
		g.setHoraExtra(10);
		d.setHoraExtra(10);
		
		System.out.println("Salario Gerente: "+ g.calculaSalario());
		System.out.println("Salario Diretor: "+ d.calculaSalario());
		System.out.println("Diferença dos Salarios: "+ g.calculaDiferença());
	}

}
package Project;

public class Main {

	public static void main(String[] args) {
		Funcionario f1 = new Funcionario();
		Funcionario	f2 = new Funcionario();
		
		f1. salario = 5000;
		f2. salario = 6000;
		
		f1.aplicaBonus(1000);
		f2.aplicaBonus(500);
		f1.aplicaBonus(500);

		System.out.println ("Salario de F1: "+ f1.salario);
		System.out.println  ("Salario de F2: "+ f2.salario);
	}


}

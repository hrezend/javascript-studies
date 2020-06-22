package Project; 
public class Funcionario {

	double salario;
	double hora_extra;
	private double ultimoBonus = 0;
	String nome;
	
	void aplicaBonus (double valor){
		if( valor >= ultimoBonus) {
			salario += valor;
			ultimoBonus = valor;			
		}
		else { 
			System.out.println ("Este bonus nao pode ser concedido a voce.");
		}
	}
}

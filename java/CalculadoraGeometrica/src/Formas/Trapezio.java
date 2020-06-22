package Formas;

public class Trapezio {
	
	double BaseMenor;
	double BaseMaior;
	double Altura;
	
	double calcularArea(){
		return ((BaseMenor+BaseMaior)*Altura / 2);
	}
}

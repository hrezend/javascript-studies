package Formas;

public class Calculadora {

	public static void main(String[] args) {

		Quadrado q1 = new Quadrado();
		Triangulo tri1 = new Triangulo();
		Trapezio tra1 = new Trapezio();
		Circunferencia c1 = new Circunferencia();
				
		q1.lado = 10;
		System.out.println(q1.calcularArea());
				
		tra1.BaseMenor = 5;
		tra1.BaseMaior = 15;
		tra1.Altura = 10;
		System.out.println(tra1.calcularArea());
	
		tri1.base = 5;
		tri1.altura = 3;
		System.out.println(tri1.calcularArea());
				
		c1.raio = 20;
		System.out.println(c1.calcularArea());
				

	}

}

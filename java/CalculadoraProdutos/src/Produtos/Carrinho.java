package Produtos;

public class Carrinho extends Produtos{

	public static void main(String[] args) {
		Produtos produto1 = new ProdutoImportado();
		Produtos produto2 = new ProdutoNacional();
		
		double Valor1, Valor2;
		
		produto1.nome = "iPhone XS";
		produto1.preco = 20.50;
		Valor1 = ((ProdutoImportado) produto1).calcularPreco();
	
		produto2.nome = "Xiaomi Mi 10";
		produto2.preco = 10.50;
		Valor2 = ((ProdutoNacional) produto2).calcularPreco();
		
		System.out.println("Preço total: " + (Valor1+Valor2));
	}
	
}
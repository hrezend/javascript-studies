package Produtos;

public class ProdutoNacional extends Produtos {
	
	double calcularPreco(){
		return (preco - (preco * 0.05));	
	}
}
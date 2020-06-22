package Produtos;

public class ProdutoImportado extends Produtos{

	double calcularPreco(){
		return (preco + (preco * 0.15));
	}
}

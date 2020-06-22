package Example1;
import java.util.Scanner;
import java.util.Vector;
public class ListAnimal {

	public static void main(String[] args) {
		Scanner he = new Scanner (System.in);
		Vector <DadosAnimal> animais = new Vector <DadosAnimal>();
		DadosAnimal animal = new DadosAnimal();
		
		for (int i = 0; i< 1; i++){
			System.out.println("Quantas patas tem o animal ?");
			animal.numPatas = he.nextInt();
			he.nextLine();
		
			System.out.println("Qual a idade do animal ?");
			animal.idade = he.nextInt();
			he.nextLine();
		
			System.out.println("Qual é a raça do animal ?");
			animal.raca = he.nextLine();
		
			System.out.println("Qual a descrição (tamanho, peso) do animal ?");
			animal.descricao = he.nextLine();
		
			System.out.println("Qual é o nome do animal ?");
			animal.nome = he.nextLine();
		
		
			animais.add(animal);
		}
		
		for(int i = 0; i<animais.size(); i++){
			System.out.println("Nome do Animal: " + animais.get(i).nome);
			System.out.println("Raça do Animal: " + animais.get(i).raca);
			System.out.println("Número de Patas: " + animais.get(i).numPatas);
			System.out.println("Idade: " + animais.get(i).idade);
			System.out.println("Descrição: " + animais.get(i).descricao);
		}
		
		//animais.insertElementAt(animal,X); ---------->Insere o elemento na posição X do vetor.
		//animais.remove(X); ----------->	Remove o elemento na posição X do vetor.				
		//animais.get(X).descricao; -------> Acessa o elemento na posição X do vetor.
		
	}

}
package Example2;

import java.util.Scanner;
import java.util.Vector;

public class ListPessoa {

	public static void main(String[] args) {
		Scanner hrz = new Scanner (System.in);
		Vector <DadosPessoa> pessoas = new Vector <DadosPessoa>();
		DadosPessoa pessoa = new DadosPessoa();
		
		System.out.println("Diga-me seu nome:");
		pessoa.nome = hrz.nextLine();
		
		System.out.println("Qual o seu gênero? Digite 1 para masculino, 2 para feminino, 3 para outros gêneros");
		pessoa.genero = hrz.nextInt();
		hrz.nextLine();
		
		System.out.println("Diga-me a sua idade:");
		pessoa.idade = hrz.nextInt();
		hrz.nextLine();
		
		System.out.println("Qual o seu estado civil?");
		pessoa.estadoCivil = hrz.nextLine();
		
		System.out.println("Em qual cidade você reside?");
		pessoa.cidade = hrz.nextLine();
		
		System.out.println("E essa cidade fica em qual estado?");
		pessoa.estado = hrz.nextLine();
		
		
		pessoas.add(pessoa);
		
		for(int i = 0; i < pessoas.size(); i++){
			if(pessoas.get(i).genero == 1){
				System.out.println("Bem vindo, " + pessoas.get(i).nome + ".");
				System.out.println("Somente para confirmar, você possui " + pessoas.get(i).idade + "anos e mora em " + pessoas.get(i).cidade + "/" + pessoas.get(i).estado);
				System.out.println("Hmmm.. pelos meus registros você é " + pessoas.get(i).estadoCivil + "...");
				System.out.println("Vem de Zap, rs!");
			}
			else if(pessoas.get(i).genero == 2){
				System.out.println("Bem vinda, " + pessoas.get(i).nome + ".");
				System.out.println("Somente para confirmar, você possui " + pessoas.get(i).idade + "anos e mora em " + pessoas.get(i).cidade + "/" + pessoas.get(i).estado);
				System.out.println("Hmmm.. pelos meus registros você é " + pessoas.get(i).estadoCivil + "...");
				System.out.println("Vem de Zap, rs!");
			}
			else if(pessoas.get(i).genero == 3){
				System.out.println("Olá, " + pessoas.get(i).nome + ".");
				System.out.println("Somente para confirmar, você possui " + pessoas.get(i).idade + "anos e mora em " + pessoas.get(i).cidade + "/" + pessoas.get(i).estado);
				System.out.println("Hmmm.. pelos meus registros você é " + pessoas.get(i).estadoCivil + "...");
				System.out.println("Vem de Zap, rs!");
			}
			else if(pessoas.get(i).genero != 3 || pessoas.get(i).genero != 2 || pessoas.get(i).genero != 1){
				System.out.println("Este gênero não existe no nosso sistema!");
			}
		}
	}

}

package Project;

import java.util.Scanner;

public class Locadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner he = new Scanner (System.in);
		String CPF;
		int opcao, indCliente = 0, cod, contador = 0, contador2 = 0, contador3 = 0, contador4 = 0, contador5 = 0;
		Cliente [] clientes = new Cliente [1000];
		char continuar = 'S', continuar2 = 'S', continuar3 ='S', continuar4 = 'S', continuar5 = 'S';
		
		do{ 
				System.out.println("-------------------------------");
				System.out.println("|            MENU             |");
				System.out.println("-------------------------------");
				System.out.println("| 1 - Cadastrar Cliente       |");
				System.out.println("| 2 - Lista de Filmes         |");
				System.out.println("| 3 - Locar Filme             |");
				System.out.println("| 4 - Devolver Filme          |");
				System.out.println("| 5 - Relatorio de Atraso     |");
				System.out.println("| 6 - Sair do Sistema         |");
				System.out.println("-------------------------------");
		
				System.out.print("Digite uma opcao do menu: ");
				opcao = he.nextInt();
				he.nextLine();
		
		//Cadastro de Clientes		
		
			while(opcao == 1 && continuar == 'S'){
			clientes[contador] = new Cliente();
				
				System.out.print("Nome do Cliente: ");
				clientes[contador].nome = he.nextLine();
						
				System.out.print("CPF do Cliente: ");
				clientes[contador].cpf = he.nextLine();
				
				System.out.print("Idade do Cliente: ");
				clientes[contador].idade = he.nextInt();
				
				System.out.println("Deseja continuar o cadastro de mais clientes ? Se sim, digite S");
				continuar = he.next().charAt(0);
				he.nextLine();
				
				if(continuar == 'S'){
					contador++;
				}
				else{
					System.out.println("Agora que j� se cadastrou, retorne ao menu e verifique a lista de filmes");
				}
										}
						
		
		//Lista de Filmes
		while(opcao == 2 && continuar2 == 'S'){
			Filme filmeum = new Filme();
			
			filmeum.Titulo = ("Homem nas Trevas");
			filmeum.Ano = (2016);
			filmeum.Genero = ("Suspense/Terror");
			filmeum.Classificacao = (18);
			filmeum.Idioma = ("Ingl�s");
			filmeum.Duracao = (88);
			filmeum.Sinopse = ("Tr�s adolescentes delinquentes de Detroit ganham a vida assaltando casas."
					+ " Eles descobrem que uma casa, que pertence a um velho veterano cego em um bairro pobre, est� cheia de dinheiro, pensando assim, que o assalto seria facilitado pelas condi��es do morador."
					+ " Por�m, o morador da casa n�o se mostra t�o impotente como eles imaginavam.");
			filmeum.Preco = (23.89);
			filmeum.Codigo = (0001);
			
			
			System.out.println("T�tulo do filme: " +filmeum.Titulo);
			System.out.println("Ano de lan�amento do filme:" +filmeum.Ano);
			System.out.println("G�nero do filme: " +filmeum.Genero);
			System.out.println("Classifica��o indicativa do filme: " +filmeum.Classificacao);
			System.out.println("Idioma do filme: " +filmeum.Idioma);
			System.out.println("Dura��o do filme em minutos: " +filmeum.Duracao);
			System.out.println("S�nopse do filme: " +filmeum.Sinopse);
			System.out.println("Pre�o de aluguel do filme: "+filmeum.Preco);
			System.out.println("C�digo do filme: "+filmeum.Codigo);
			
			
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("##########################################################################");
			System.out.println("--------------------------------------------------------------------------");
			
	Filme filmedois = new Filme();
			
			filmedois.Titulo = ("Warcraft - O Primeiro Encontro De Dois Mundos");
			filmedois.Ano = (2016);
			filmedois.Genero = ("Acao/Aventura/Fantasia epica");
			filmedois.Classificacao = (12);
			filmedois.Idioma = ("Ingles/Portugues");
			filmedois.Duracao = (123);
			filmedois.Sinopse = ("A regiao de Azeroth sempre viveu em paz, at� a chegada dos guerreiros Orc. "
					+ "Com a abertura de um portal, eles puderam chegar � nova Terra com a inten��o de destruir o povo inimigo. "
					+ "Cada lado da batalha possui um grande her�i, e os dois travam uma disputa pessoal, colocando em risco seu povo, sua fam�lia e todas as pessoas que amam");
			filmedois.Preco = (19.99);
			filmedois.Codigo = (0002);
			
			
			System.out.println("T�tulo do filme: " +filmedois.Titulo);
			System.out.println("Ano de lan�amento do filme: "+filmedois.Ano);
			System.out.println("G�nero do filme: " +filmedois.Genero);
			System.out.println("Classifica��o indicativa do filme: " +filmedois.Classificacao);
			System.out.println("Idioma do filme: " +filmedois.Idioma);
			System.out.println("Dura��o do filme em minutos: " +filmedois.Duracao);
			System.out.println("S�nopse do filme: " +filmedois.Sinopse);
			System.out.println("Pre�o de aluguel do filme: "+filmedois.Preco);
			System.out.println("C�digo do filme: "+filmedois.Codigo);
			
			
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("##########################################################################");
			System.out.println("--------------------------------------------------------------------------");
			
	Filme filmetres = new Filme();
			
			filmetres.Titulo = ("Procurando Dory");
			filmetres.Ano = (2016);
			filmetres.Genero = ("Anima��o/Com�dia");
			filmetres.Classificacao = (0);
			filmetres.Idioma = ("Ingl�s/Portugu�s");
			filmetres.Duracao = (100);
			filmetres.Sinopse = ("Um ano ap�s ajudar Marlin a reencontrar seu filho Nemo, Dory tem um insight e lembra de sua amada fam�lia."
					+ "Com saudades, ela decide fazer de tudo para reencontr�-los e na desenfreada busca esbarra com amigos do passado e vai parar nas perigosas m�os de humanos.");
			filmetres.Preco = (9.99);
			filmetres.Codigo = (0003);
			
			
			System.out.println("T�tulo do filme: " +filmetres.Titulo);
			System.out.println("Ano de lan�amento do filme: "+filmetres.Ano);
			System.out.println("G�nero do filme: " +filmetres.Genero);
			System.out.println("Classifica��o indicativa do filme: " +filmetres.Classificacao);
			System.out.println("Idioma do filme: " +filmetres.Idioma);
			System.out.println("Dura��o do filme em minutos: " +filmetres.Duracao);
			System.out.println("S�nopse do filme: " +filmetres.Sinopse);
			System.out.println("Pre�o de aluguel do filme: "+filmetres.Preco);
			System.out.println("C�digo do filme: "+filmetres.Codigo);	
			
			
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("##########################################################################");
			System.out.println("--------------------------------------------------------------------------");
			
	Filme filmequatro = new Filme();
			
			filmequatro.Titulo = ("Velozes e Furiosos 7");
			filmequatro.Ano = (2015);
			filmequatro.Genero = ("A��o/Corrida");
			filmequatro.Classificacao = (14);
			filmequatro.Idioma = ("Ingl�s/Portugu�s");
			filmequatro.Duracao = (140);
			filmequatro.Sinopse = ("Ap�s os aconcetimentos em Londres, Dom, Brian, Letty e o resto da equipe tiveram a chance de voltar para os Estados Unidos e recome�arem suas vidas."
					+ "Mas a tranquilidade do grupo � destru�da quando Deckard Sha, um assassino profissional, quer vingan�a pela morte de seu irm�o."
					+ "Agora, a equipe tem que se reunir para impedir este novo vil�o. Mas dessa vez, n�o � s� sobre ser veloz. A luta � pela sobreviv�ncia.");
			filmequatro.Preco = (14.99);
			filmequatro.Codigo = (0004);
			
			
			System.out.println("T�tulo do filme: " +filmequatro.Titulo);
			System.out.println("Ano de lan�amento do filme: "+filmequatro.Ano);
			System.out.println("G�nero do filme: " +filmequatro.Genero);
			System.out.println("Classifica��o indicativa do filme: " +filmequatro.Classificacao);
			System.out.println("Idioma do filme: " +filmequatro.Idioma);
			System.out.println("Dura��o do filme em minutos: " +filmequatro.Duracao);
			System.out.println("S�nopse do filme: " +filmequatro.Sinopse);
			System.out.println("Pre�o de aluguel do filme: "+filmequatro.Preco);
			System.out.println("C�digo do filme: "+filmequatro.Codigo);
			
			
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("##########################################################################");
			System.out.println("--------------------------------------------------------------------------");
			
	Filme filmecinco = new Filme();
			
			filmecinco.Titulo = ("Mama");
			filmecinco.Ano = (2013);
			filmecinco.Genero = ("Terror");
			filmecinco.Classificacao = (14);
			filmecinco.Idioma = ("Ingl�s/Portugu�s");
			filmecinco.Duracao = (100);
			filmecinco.Sinopse = ("Quando o pai de Victoria e Lilly mata a m�e das garotas, as crian�as fogem assustadas para uma floresta."
					+ "Durante cinco anos, ningu�m tem not�cia do paradeiro delas, at� o dia em que elas reaparecem, sem explicarem como sobreviveram sozinhas."
					+ "Os tios das duas, Lucas e Annabel adotam Victoria e Lilly e tentam dar uma vida tranquila �s duas, mas logo eles percebem que existe algo errado."
					+ "As duas conversam frequentemente com uma entidade invis�vel, que chamam de 'Mama'."
					+ "Lucas e Annabel n�o sabem se acreditam nas meninas, ou se devem culp�-las pelos estranhos acontecimentos na casa.");
			filmecinco.Preco = (9.99);
			filmecinco.Codigo = (0005);
			
			
			System.out.println("T�tulo do filme: " +filmecinco.Titulo);
			System.out.println("Ano de lan�amento do filme: "+ filmecinco.Ano);
			System.out.println("G�nero do filme: " +filmecinco.Genero);
			System.out.println("Classifica��o indicativa do filme: " +filmecinco.Classificacao);
			System.out.println("Idioma do filme: " +filmecinco.Idioma);
			System.out.println("Dura��o do filme em minutos: " +filmecinco.Duracao);
			System.out.println("S�nopse do filme: " +filmecinco.Sinopse);
			System.out.println("Pre�o de aluguel do filme: "+filmecinco.Preco);
			System.out.println("C�digo do filme: "+filmecinco.Codigo);	
			
			
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("##########################################################################");
			System.out.println("--------------------------------------------------------------------------");
			
			System.out.println("Deseja rever a lista de filmes ? Se sim, digite S");
			continuar2 = he.next().charAt(0);
			he.nextLine();
			
			if(continuar2 == 'S'){
				contador2++;
			}
			else{
				System.out.println("Agora que j� viu a lista de filmes, escolha um para locar!");
			}
									
		}
		
		
		//Locar Filme
		while(opcao == 3 && continuar3 == 'S'){
			System.out.print("Cliente, digite seu CPF para que possamos identificar-lo! Assim, liberaremos a loca��o do filme: ");
			CPF = he.nextLine();
			
			while (!clientes[indCliente].cpf.equals(CPF))
					indCliente++;
			
			if(clientes[indCliente].cpf.equals(CPF)){
				System.out.print("Ol�, "+ clientes[indCliente].nome + "! Digite o c�digo do filme que quer alugar: ");
				cod = he.nextInt();
				
				if(cod == 0001){
					System.out.println("Obrigado Cliente. Voc� alugou o filme 'Homem nas Trevas' com sucesso!");
					System.out.println("Valor: R$23.89");
					System.out.println("Acompanhe seu Relat�rio de Atraso atrav�s do menu!");
										}
				else if (cod == 0002){
					System.out.println("Obrigado Cliente. Voc� alugou o filme 'Warcraft- O Primeiro Encontro de Dois Mundos' com sucesso!");
					System.out.println("Valor: R$19.99");
					System.out.println("Acompanhe seu Relat�rio de Atraso atrav�s do menu!");
									}
				else if (cod == 0003){
					System.out.println("Obrigado Cliente. Voc� alugou o filme 'Procurando Dory' com sucesso!");
					System.out.println("Valor: R$9.99");
					System.out.println("Acompanhe seu Relat�rio de Atraso atrav�s do menu!");
									}
				else if(cod == 0004){
					System.out.println("Obrigado Cliente. Voc� alugou o filme 'Velozes e Furiosos 7' com sucesso!");
					System.out.println("Valor: R$14.99");
					System.out.println("Acompanhe seu Relat�rio de Atraso atrav�s do menu!");
									}
				else if(cod == 0005){
					System.out.println("Obrigado Cliente. Voc� alugou o filme 'Mama' com sucesso!");
					System.out.println("Valor: R$9.99");
					System.out.println("Acompanhe seu Relat�rio de Atraso atrav�s do menu!");
				}
													}
			
			
			else {
				System.out.println("Cliente nao encontrado.");
				}
			System.out.println("Deseja locar outro filme ? Se sim, digite S");
			continuar3 = he.next().charAt(0);
			he.nextLine();
			
			if(continuar3 == 'S'){
				contador3++;
			}
			else{
				System.out.println("Muito obrigado!");
			}
		
						}
		
		
		
		
		
		//Devolver Filme
		while(opcao == 4 && continuar4 == 'S') {
			System.out.print("Cliente, digite seu CPF para que possamos identificar-lo! Assim, liberaremos a devolucao do filme: ");
			CPF = he.nextLine();
			
			while (!clientes[indCliente].cpf.equals(CPF))
					indCliente++;
			
			if(clientes[indCliente].cpf.equals(CPF)){
				System.out.print("Ola, "+clientes[indCliente].nome +"! Digite o codigo do filme que quer devolver: ");
				cod = he.nextInt();
				
				if(cod == 0001){
					System.out.println("Obrigado Cliente. Voce devolveu o filme 'Homem nas Trevas' com sucesso!");
								}
				else if(cod == 0002){
					System.out.println("Obrigado Cliente. Voce devolveu o filme 'Warcraft - O Primeiro Encontro de Dois Mundos' com sucesso!");
									}
				else if(cod == 0003){
					System.out.println("Obrigado Cliente. Voce devolveu o filme 'Procurando Dory' com sucesso!");
									}
				else if(cod == 0004){
					System.out.println("Obrigado Cliente. Voce devolveu o filme 'Velozes e Furiosos 7' com sucesso!");
										}
				else if(cod == 0005){
					System.out.println("Obrigado Cliente. Voce devolveu o filme 'Mama' com sucesso!");
									}
													}
			
			
			else {
				System.out.println("Cliente nao encontrado.");
				}
			System.out.println("Deseja devolver outro filme ? Se sim, digite S");
			continuar3 = he.next().charAt(0);
			he.nextLine();
			
			if(continuar4 == 'S'){
				contador4++;
			}
			else{
				System.out.println("Muito obrigado!");
			}
			
						}
		
		
		
		//Relatorio de Atraso
		while(opcao == 5 && continuar5 == 'S'){
			System.out.print("Cliente, digite seu CPF para que possamos identificar-lo e imprimir o seu relatorio de Atraso: ");
			CPF = he.nextLine();
		
			while (!clientes[indCliente].cpf.equals(CPF))
					indCliente++;
			
			if(clientes[indCliente].cpf.equals(CPF)){
				System.out.println("Ola "+ clientes[indCliente].nome +",voce alugou um dos nossos filmes, e tem ate 7 (Sete) dias para efetuar a devolucao, caso contrario, pagara uma multa no valor de R$1,99 por dia de atraso, alem de ter o registro na locadora congelado por 14 dias!");
			}
			
			else{
				System.out.println("Cliente nao encontrado.");
			}
			System.out.println("Deseja ver outro relatorio ? Se sim, digite S");
			continuar5 = he.next().charAt(0);
			he.nextLine();
			
			if(continuar5 == 'S'){
				contador5++;
			}
			else{
				System.out.println("Muito obrigado!");
			}
		}
		
		
		
		//Sair do Sistema
		if(opcao == 6){
			System.out.println("Obrigado Cliente. Volte Sempre!");
		}
		
	
		
		
		}while(opcao != 6);
	}
}

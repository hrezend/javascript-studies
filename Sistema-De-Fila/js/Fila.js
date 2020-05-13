//Cria o Array e Inicializa.
var queue = [];
queue.push({name: "Antonio figueiredo", amount: 3});
queue.push({name: "Maria Carolina", amount: 1});
queue.push({name: "João Vitor", amount: 2});
queue.push({name: "Andressa Silva", amount: 27});

var tamanhoQueue = queue.length;

//Função para carregar o array de pessoas na fila.
function Load(){	
	var Fila = document.getElementById('divfila');
	var Unidade = document.createElement('div');
	var Nome = document.createElement('h2');
	var Quantidade = document.createElement('h3');
	
	var indice = 0;

	var ConteudoNome = queue[indice].name;
	var ConteudoQuantidade = queue[indice].amount;

	Nome.appendChild(document.createTextNode(ConteudoNome));
	Quantidade.appendChild(document.createTextNode(ConteudoQuantidade));
	
	if(ConteudoQuantidade % 2 == 0){
		Unidade.setAttribute('name', 'par');
	}
	else{
		Unidade.setAttribute('name', 'impar');
	}

	Unidade.appendChild(Nome);
	Unidade.appendChild(Quantidade);
	Unidade.setAttribute('id', 'unidade');

	Fila.appendChild(Unidade);
}

//Função para adicionar uma nova pessoa no array da fila.
function Add(){
	var GetName = "";
	var GetAmount = "";
	
	GetName = document.getElementById('name').value;	
	GetAmount = document.getElementById('amount').value;	
	
	if(GetAmount != 71){
		queue.push({name: GetName, amount: GetAmount});
		tamanhoQueue++;
	}
	else{
		queue.push({name: GetName, amount: GetAmount});
		tamanhoQueue++;
		setTimeout(RemoveAmountPair, 1);		
	}
}

//Função que remove pessoas do array.
function Remove(){
	queue.shift();
	if(tamanhoQueue > 0){
		tamanhoQueue--;
	}
}

//Função que remove pessoas do HTML.
function RemoveFila(){
	//document.getElementsByTagName('h2')[0].remove();
	//document.getElementsByTagName('h3')[0].remove();
	document.getElementById('unidade').remove();
}

//Função que remove pessoas do HTML quando a quantidade pão é par.
function RemoveAmountPair(){
	var i = 0;
	var tamanho = document.querySelectorAll('#unidade').length;
	for(i = 0; i < tamanho; i++){
		document.getElementsByName('par')[0].remove();
	}
}

//Intervalos para as funções rodarem automaticamente.
setInterval(Load, 100);
setInterval(Remove, 100);
setInterval(RemoveFila, 10000);

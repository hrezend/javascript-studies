function ValidarNome(){
			
	var nome;
	nome = document.forms[0].nome.value;
	
	if(nome.match(/([!,@,#,$,%,^,&,*,?,_,~])/) || nome.match(/(.*[0-9])/) ){
		alert('Seu nome não deve conter números ou caracteres especiais.');
		document.forms[0].nome.value="";
		document.getElementById('nome').focus();
	}
	
}

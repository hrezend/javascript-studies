function ValidaNome(){
			
	var nome;
	nome=document.forms[0].nome.value;
	

	if(nome.match(/([!,@,#,$,%,^,&,*,?,_,~])/) || nome.match(/(.*[0-9])/) ){
		alert('Seu nome não deve conter caracteres especiais ou números.');
		document.forms[0].nome.value="";
		document.getElementById('nome').focus();
	}


	
}
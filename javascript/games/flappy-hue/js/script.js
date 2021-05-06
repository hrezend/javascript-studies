var posy = 0, posx = 0, pontos = 0;
var t1 = setInterval(anda,20);
var BarraAlt1, BarraAlt2, BarraAlt3; // altura das aberturas das barras
var Altura = 150;
var colide = false;
			
function move(){
	var peca = document.getElementById("peca");
			tecla = event.keyCode;

	if(tecla == 38){
		posy-=15;
		if(posy < 0){
			posy = 0;
		}
	} 
	else if(tecla == 40){
		posy+=15;
		if(posy > 800){
			posy = 800;
		}
	}

	peca.style = "left: " + posx + "px;top: " + posy + "px";
	colisao();
}

function anda(){
	var peca = document.getElementById("peca");
	posx += 3;
				
	peca.style = "left: " + posx + "px;top: " + posy + "px";
	colisao();
				
	pontos++;
	document.getElementById("pontos").value = pontos;
				
	if(posx > 950){
		posx = 0;
		pontos += 100;
		barras();
	}
}
			
function barras(){
	BarraAlt1 = Math.floor(Math.random() * 350);
	BarraAlt2 = Math.floor(Math.random() * 350);
	BarraAlt3 = Math.floor(Math.random() * 350);
					
	document.getElementById("BTop1").style = "left:300px; top:0px; height: " + BarraAlt1 + "px";
	document.getElementById("BBase1").style = "left:300px; top:" + (BarraAlt1 + Altura) + "px; height: " + "calc(100vh - " + (BarraAlt1 + Altura) + "px)";
	document.getElementById("BTop2").style = "left:600px; top:0px; height: " + BarraAlt2 + "px";
	document.getElementById("BBase2").style = "left:600px; top:" + (BarraAlt2 + Altura) + "px; height: " + "calc(100vh - " + (BarraAlt2 + Altura) + "px)";
	document.getElementById("BTop3").style = "left:900px; top:0px; height: " + BarraAlt3 + "px";
	document.getElementById("BBase3").style = "left:900px; top:" + (BarraAlt3 + Altura) + "px; height: " + "calc(100vh - " + (BarraAlt3 + Altura) + "px)";
}
			
function colisao(){
	if(posx >= 250 && posx <= 350 && posy >= 0 && posy <= BarraAlt1) // Detecção de colisão da primeira barra do topo
			colide = true;
	if(posx >= 250 && posx <= 350 && posy >= (BarraAlt1 + Altura) - 50 && posy <= 2000) // Detecção de colisão da primeira barra da base
			colide = true;
	if(posx >= 550 && posx <= 650 && posy >= 0 && posy <= BarraAlt2) // Detecção de colisão da segunda barra do topo
			colide = true;
	if(posx >= 550 && posx <= 650 && posy >= (BarraAlt2 + Altura) - 50 && posy <= 2000) // Detecção de colisão da segunda barra da base
			colide = true;
	if(posx >= 850 && posx <= 950 && posy >= 0 && posy <= BarraAlt3) // Detecção de colisão da terceira barra do topo
			colide = true;
	if(posx >= 850 && posx <= 950 && posy >= (BarraAlt3 + Altura) - 50 && posy <= 2000) // Detecção de colisão da terceira barra da base
			colide = true;
				
	if(colide){
			document.getElementById("peca").style = "background-color:red;";
			document.getElementById("fundo").style = "background-image:url('assets/huebackg.jpg');";
			setTimeout(alertGO, 1000);		
			clearInterval(t1);
	}
}

function alertGO(){
	alert('Game Over! Press F5 to play again. Your score: ' + pontos);
}

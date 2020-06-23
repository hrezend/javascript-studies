let imagemCenario;
let imagemHypsta;
let cenario;
let hypsta;
let trilhaSonora;

function preload(){
  imagemCenario = loadImage('../images/cenario/floresta.png');
  imagemHypsta = loadImage('../images/personagem/hypsta/sprite.png');
  trilhaSonora = loadSound('../sounds/trilha_sonora_jogo.mp3');
}

function setup(){
  createCanvas(windowWidth, windowHeight);
  cenario = new Cenario(imagemCenario, 3);
  hypsta = new Hypsta(imagemHypsta);
  trilhaSonora.loop();
  frameRate(30);
}

function draw(){
  //Exibe e faz o efeito de movimento do cenário
  cenario.exibe();
  cenario.move();
  //Exibe e faz o efeito de movimentação do nosso herói
  hypsta.exibe();
  hypsta.animacao();
}

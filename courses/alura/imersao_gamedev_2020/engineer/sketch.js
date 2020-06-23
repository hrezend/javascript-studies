let imagemCenario;
let imagemHypsta;
let imagemAzuring;
let cenario;
let hypsta;
let azuring;
let soundGame;
let soundJump

const matrizAzuring = [
  [0, 0],
  [105, 0],
  [210, 0],
  [315, 0],
  [0, 104],
  [105, 104],
  [210, 104],
  [315, 104],
  [0, 208],
  [105, 208],
  [210, 208],
  [315, 208],
  [0, 312],
  [105, 312],
  [210, 312],
  [315, 312],
  [0, 409],
  [105, 409],
  [210, 409],
  [315, 409],
  [0, 503],
  [105, 503],
  [210, 503],
  [315, 503],
  [0, 609],
  [105, 609],
  [210, 609],
  [315, 609],
];

const matrizHypsta = [
  [0, 0],
  [220, 0],
  [440, 0],
  [660, 0],
  [0, 270],
  [220, 270],
  [440, 270],
  [660, 270],
  [0, 540],
  [220, 540],
  [440, 540],
  [660, 540],
  [0, 810],
  [220, 810],
  [440, 810],
  [660, 810],
];

function preload(){
  imagemCenario = loadImage('../images/cenario/floresta.png');
  imagemHypsta = loadImage('../images/personagem/hypsta/sprite.png');
  imagemAzuring = loadImage('../images/inimigos/azuring/sprite.png');
  soundGame = loadSound('../sounds/trilha_sonora_jogo.mp3');
  soundJump = loadSound('../sounds/effect_jump.mp3');
}

function setup(){
  createCanvas(windowWidth, windowHeight);
  cenario = new Cenario(imagemCenario, 3);
  hypsta = new Hero(matrizHypsta, imagemHypsta, 0, 220, 270, 220, 270);
  azuring = new Enemy(matrizAzuring, imagemAzuring, width-105, 104, 104, 104, 104);
  soundGame.loop();
  frameRate(30);
}

function keyPressed(){
  if(key === 'ArrowUp'){
    soundJump.play();
    hypsta.jump();
  }
}

function draw(){
  //Exibe e faz o efeito de movimento do cenário
  cenario.exibe();
  cenario.move();
  //Exibe e faz o efeito de movimentação do nosso herói
  hypsta.show();
  hypsta.gravit();
  //Exibe e faz o efeito de movimentação do inimigo
  azuring.show();
  azuring.walk();

  if(hypsta.colliding(azuring)){
    noLoop();
  }
}

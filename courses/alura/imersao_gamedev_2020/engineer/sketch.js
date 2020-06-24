let imagemCenario;
let imagemGameOver;
let imagemHypsta;
let imagemAzuring;
let imagemFlyzuring;
let imagemTroll;
let cenario;
let pontuacao;
let hypsta;
let azuring;
let flyzuring;
let troll;
let soundGame;
let soundJump;
let randomEnemy;
let enemy;

const enemies = [];

function preload(){
  imagemCenario = loadImage('../images/cenario/floresta.png');
  imagemGameOver = loadImage('../images/assets/gameOver.png');
  imagemHypsta = loadImage('../images/personagem/hypsta/sprite.png');
  imagemAzuring = loadImage('../images/inimigos/azuring/sprite.png');
  imagemFlyzuring = loadImage('../images/inimigos/flyzuring/sprite.png');
  imagemTroll = loadImage('../images/inimigos/troll/sprite.png');
  soundGame = loadSound('../sounds/trilha_sonora_jogo.mp3');
  soundJump = loadSound('../sounds/effect_jump.mp3');
}

function setup(){
  createCanvas(windowWidth, windowHeight);
  cenario = new Cenario(imagemCenario, 3);
  pontuacao = new Punctuation();
  hypsta = new Hero(matrizHypsta, imagemHypsta, 0, 30, 220, 270, 220, 270);
  const azuring = new Enemy(matrizAzuring, imagemAzuring, width-105, 25, 104, 104, 104, 104, 20, 100);
  const troll = new Enemy(matrizTroll, imagemTroll, width, 0, 200, 200, 400, 400, 30, 100);
  const flyzuring = new Enemy(matrizFlyzuring, imagemFlyzuring, width, 150, 150, 125, 200, 150, 50, 100);
  soundGame.loop();
  frameRate(30);

  enemies.push(azuring);
  enemies.push(troll);
  enemies.push(flyzuring);
  randomEnemy = Math.floor(Math.random() * enemies.length);
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
  //Exibe a pontuacao
  pontuacao.show();
  pontuacao.incrementPoints();
  //Exibe e faz o efeito de movimentação do nosso herói
  hypsta.show();
  hypsta.gravit();
  //Exibe e faz o efeito de movimentação do inimigo
  enemie = enemies[randomEnemy];
  enemie.show();
  enemie.walk();  
  if(hypsta.colliding(enemie)){
    console.log('Colidiu!');
    pontuacao.decrementPoints(2);
    if(pontuacao.gameOver()){
      image(imagemGameOver, width/2 - 200, height/3);
      noLoop();
    }
  }
  if(enemie.passed()){
    randomEnemy = Math.floor(Math.random() * enemies.length);
  }
}

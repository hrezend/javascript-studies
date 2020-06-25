function preload(){
  font = loadFont('../fonts/fontMenu.otf');
  imagemMenu = loadImage('../images/cenario/start.png');
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
  soundGame.loop();
  frameRate(30);
  jogo = new Jogo();
  menu = new Menu();
  buttonGerenciador = new ButtonGerenciador('New Game', width/2, height/2);
  jogo.setup();
  cenas = {
    jogo: jogo,
    menu: menu,
  };
}

function keyPressed(){
  jogo.keyPressed(key);
}

function draw(){
  cenas[cenaAtual].draw();
}

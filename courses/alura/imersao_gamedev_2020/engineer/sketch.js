function preload(){
  fita = loadJSON('../scripts/map/fita.json');
  font = loadFont('../fonts/fontMenu.otf');
  imagemLife = loadImage('../images/assets/heart.png');
  imagemMenu = loadImage('../images/cenario/start.png');
  imagemCenario = loadImage('../images/cenario/floresta.png');
  imagemGameOver = loadImage('../images/assets/gameOver.png');
  imagemHypsta = loadImage('../images/personagem/hypsta/sprite.png');
  imagemAzuring = loadImage('../images/inimigos/azuring/sprite.png');
  imagemFlyzuring = loadImage('../images/inimigos/flyzuring/sprite.png');
  imagemTroll = loadImage('../images/inimigos/troll/sprite.png');
  soundGame = loadSound('../sounds/trilha_sonora_jogo.mp3');
  soundJump = loadSound('../sounds/effect_jump.mp3');
  soundDamage = loadSound('../sounds/effect_damage.mp3');
  soundGameOver = loadSound('../sounds/effect_game_over.mp3');
}

function setup(){
  createCanvas(windowWidth, windowHeight);
  soundGame.loop();
  frameRate(30);
  florest = new Florest();
  menu = new Menu();
  buttonGerenciador = new ButtonGerenciador('New Game', width/2, height/2);
  florest.setup();
  cenas = {
    florest: florest,
    menu: menu,
  };
}

function keyPressed(){
  florest.keyPressed(key);
}

function draw(){
  cenas[cenaAtual].draw();
}

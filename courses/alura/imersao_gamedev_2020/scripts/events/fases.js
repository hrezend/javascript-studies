class Jogo{
    keyPressed(key){
        if(key === 'ArrowUp'){
            soundJump.play();
            hypsta.jump();
        }
    }
    setup(){
        cenario = new Cenario(imagemCenario, 3);
        pontuacao = new Punctuation();
        hypsta = new Hero(matrizHypsta, imagemHypsta, 0, 30, 220, 270, 220, 270);
        const azuring = new Enemy(matrizAzuring, imagemAzuring, width-105, 25, 104, 104, 104, 104, 20, 100);
        const troll = new Enemy(matrizTroll, imagemTroll, width, 0, 200, 200, 400, 400, 30, 100);
        const flyzuring = new Enemy(matrizFlyzuring, imagemFlyzuring, width, 150, 150, 125, 200, 150, 50, 100);
        enemies.push(azuring);
        enemies.push(troll);
        enemies.push(flyzuring);
        randomEnemy = Math.floor(Math.random() * enemies.length);
    }
    draw(){
        cenario.exibe();
        cenario.move();
        pontuacao.show();
        pontuacao.incrementPoints();
        hypsta.show();
        hypsta.gravit();
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
}
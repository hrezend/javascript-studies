class Florest{
    constructor(){
        this.indice = 0;
        this.mapa = fita.mapa;
    }
    keyPressed(key){
        if(key === 'ArrowUp'){
            hypsta.jump();
        }
    }
    setup(){
        cenario = new Cenario(imagemCenario, 3);
        pontuacao = new Punctuation();
        life = new Life(fita.configs.vidaMax, fita.configs.vidaInicial);
        hypsta = new Hero(matrizHypsta, imagemHypsta, 0, 30, 220, 270, 220, 270);
        const azuring = new Enemy(matrizAzuring, imagemAzuring, width-105, 25, 104, 104, 104, 104, 20);
        const troll = new Enemy(matrizTroll, imagemTroll, width, 0, 200, 200, 400, 400, 20);
        const flyzuring = new Enemy(matrizFlyzuring, imagemFlyzuring, width, 150, 150, 125, 200, 150, 20);
        enemies.push(azuring);
        enemies.push(troll);
        enemies.push(flyzuring);
    }
    draw(){
        cenario.exibe();
        cenario.move();
        life.draw();
        pontuacao.show();
        pontuacao.incrementPoints();
        hypsta.show();
        hypsta.gravit();

        const linhaAtual = this.mapa[this.indice];
        const enemie = enemies[linhaAtual.inimigo];
        const visibleEnemie = enemie.x < - enemie.largura;
        enemie.velocidade = linhaAtual.velocidade;
        enemie.show();
        enemie.walk(); 

        if(visibleEnemie){
            this.indice++;
            enemie.back();
            if(this.indice >= this.mapa.length){
                this.indice = 0;
            }
        }
 
        if(hypsta.colliding(enemie)){
            soundDamage.play();
            pontuacao.decrementPoints(2);
            life.decrementLife();
            hypsta.invincibility();
            if(life.qtd_vidas === 0){
                soundGame.stop();
                soundGameOver.play();
                image(imagemGameOver, width/2 - 200, height/3);
                noLoop();
                alert('Você perdeu todas as suas vidas. Sua pontuação restante foi: ' + pontuacao.progress() + '!');
            }
        }
    }
}
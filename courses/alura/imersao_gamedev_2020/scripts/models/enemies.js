class Enemy extends Animacao{
    constructor(matriz, imagem, x, variacaoY, largura, altura, larguraSprite, alturaSprite, velocidade){
        super(matriz, imagem, x, variacaoY, largura, altura, larguraSprite, alturaSprite);
        this.velocidade = velocidade;
        this.x = width;
    }
    walk(){
        this.x = this.x - this.velocidade;
    }
    back(){
        this.x = width;
    }
}
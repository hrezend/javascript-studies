class Hero extends Animacao{
    constructor(matriz, imagem, x, variacaoY, largura, altura, larguraSprite, alturaSprite){
        super(matriz, imagem, x, variacaoY, largura, altura, larguraSprite, alturaSprite);
        this.variacaoY = variacaoY;
        this.yBase = height - this.altura - this.variacaoY;
        this.y = this.yBase;
        this.gravity = 3;
        this.speedJump = 0;
        this.jumpHeight = 30;
        this.amount_jumps = 0;
        this.invencivel = false;
    }
    jump(){
        if(this.amount_jumps != 2){
            this.speedJump =- this.jumpHeight;
            this.amount_jumps++;
            soundJump.play();
        }
    }
    gravit(){
        this.y = this.y + this.speedJump;
        this.speedJump = this.speedJump + this.gravity;
        if(this.y > this.yBase){
            this.y = this.yBase;
            this.amount_jumps = 0;
        }
    }
    colliding(enemy){
        //noFill();
        //ellipse(this.largura/2, this.y*1.5, this.largura);
        //ellipse(enemy.x/0.7, enemy.y*1.1, enemy.largura);
        if(this.invencivel){
            return false;
        }
        const collid = collideCircleCircle(
            this.largura/2,
            this.y*1.5,
            this.largura,
            enemy.x/0.7,
            enemy.y*1.1,
            enemy.largura,
        );
        return collid;
    }
    invincibility(){
        this.invencivel = true;
        setTimeout(() => {
            this.invencivel = false;
        }, 3000);
    }
}
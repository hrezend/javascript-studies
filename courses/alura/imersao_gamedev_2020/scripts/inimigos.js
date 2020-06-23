const width_azuring = 105;
const height_azuring = 105;

class Azuring{
    constructor(imagem){
        this.imagem = imagem;
        this.matriz = [
            [0, 0],
            [105, 0],
            [210, 0],
            [315, 0],
            [0, 105],
            [105, 105],
            [210, 105],
            [315, 105],
            [0, 210],
            [105, 210],
            [210, 210],
            [315, 210],
        ];
        this.pontoMatrizAtual = 0;
        this.imageWidth = 105;
        this.imageHeight = 105;
    }
    exibe(){
        image(this.imagem, width - 105, height - 105, width_azuring, height_azuring, this.matriz[this.pontoMatrizAtual][0], this.matriz[this.pontoMatrizAtual][1], this.imageWidth, this.imageHeight);
        this.animacao();
    }
    animacao(){
        this.pontoMatrizAtual++;
        if(this.pontoMatrizAtual >= this.matriz.length - 1){
            this.pontoMatrizAtual = 0;
        }
    }
}

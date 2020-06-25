class Menu{
    draw(){
        this._imagemDeFundo();
        this._texto();
        this._button();
    }
    _imagemDeFundo(){
        image(imagemMenu, 0, 0, width, height);
    }
    _texto(){
        textAlign(CENTER);
        textFont(font);
        textSize(54);
        text('As aventuras de', width/2, height/3);
        textSize(74);
        text('Hypsta', width/2, height / 5 * 3);
    }
    _button(){
        buttonGerenciador.y = height / 7 * 5;
        buttonGerenciador.draw();
    }
}
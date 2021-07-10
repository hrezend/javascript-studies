function sound(src) {        
    this.sound = document.createElement("audio");
    this.sound.src = src;
    this.sound.setAttribute("preload", "auto");
    this.sound.setAttribute("controls", "none");
    this.sound.style.display = "none";
    document.body.appendChild(this.sound);
    this.play = function(){
        this.sound.play();
    }
    this.stop = function(){
        this.sound.pause();
    }    
}

const audios = {
    newPlayer: new sound("./sounds/newPlayer.mp3"),
    newFruit: new sound("./sounds/newFruit.mp3"),
    collect: new sound("./sounds/collect.mp3"),
}

export {audios, sound}
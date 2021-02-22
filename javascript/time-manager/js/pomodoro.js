var time;
var stopTime;

function restart(){
    clearTimeout(stopTime);
    time = 60*30;
    Chronometer();
}

function Chronometer(){
    var button = document.getElementById('button-timer-pomodoro');

    if(time-1 >= 0){
        var min = parseInt(time/60);
        min = min % 60;
        var seg = time % 60;

        if(min < 10){
            min = "0"+min;
            min = min.substr(0,2);
        }
        if(seg <= 9){
            seg = "0"+seg;
        }

        var out = min+':'+seg;

        button.innerHTML = out;

        if(time <= 60*5){
            button.style.backgroundColor = '#FFC107';
            document.getElementById('sound-rest-pomodoro').play();
        }

        stopTime = setTimeout(Chronometer,1000);
        time--;
    }	
	else{
	    button.innerHTML = 'Restart!';
        button.style.backgroundColor = '#008EE2';

        clearTimeout(stopTime);
	}
}
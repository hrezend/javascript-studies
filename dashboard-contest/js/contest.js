var hs = 3;
var time = 3600*hs;
var countCompetitor = 0;

function submitAccepted(obj){
    var myColors = ['#40E0D0', '#D0D0D0'];
    var Random = myColors[Math.floor(Math.random() * myColors.length)];
    var Button = document.getElementById(obj.id);
    Button.style.backgroundColor = Random;
}

function AddCompetitor(){
    var GetName = prompt("Please, enter with the name competitor:");
    
    if(GetName != null && GetName != ""){
        var Element = document.getElementById('table');
        var Linha = document.createElement('tr');
        var ColunaName = document.createElement('td');
        var Buttons = document.createElement('td');
        ColunaName.appendChild(document.createTextNode(GetName));

        for(var i = 1; i <= 10; i++){
            var Button = document.createElement('button');
            Button.appendChild(document.createTextNode(i));
            Button.setAttribute('onclick','submitAccepted(this)');
            Button.setAttribute('id', 'u'+countCompetitor+'button'+i);
            Buttons.appendChild(Button);
        }

        Linha.appendChild(ColunaName);
        Linha.appendChild(Buttons);
        Element.appendChild(Linha);
        countCompetitor++;
    }
    else{
        alert('Invalid name!');
    }
}

function AddContest(){
    var GetAmount = confirm("The number of questions of the conquest is 10.");
    if(GetAmount){
        alert('Conquest will be inicialized when you inicialize the chronometer.');
    }
    else{
        alert('Confirm Conquest!');
    }
}

function Timer(){
    var GetTime = confirm("The contest will be duration of 3 hours. Starting... now!");
    if(GetTime){
        Chronometer();
    }
    else{
        alert('Confirm timer is necessary.');
    }
}

function Chronometer(){
    if(time-1 >= 0){
        var min = parseInt(time/60);
        var hor = parseInt(min/60);
        min = min % 60;
        var seg = time % 60;

        if(min < 10){
            min = "0"+min;
            min = min.substr(0,2);
        }
        if(seg <= 9){
            seg = "0"+seg;
        }
        if(hor <= 9){
            hor = "0"+hor;
        }

        var hourOut = hor+':'+min+':'+seg;
        var Div = document.getElementById('chr');
        Div.innerHTML = hourOut;

        setTimeout(Chronometer,1000);
        time--;
    }
}
/*** General Functions ***/
function zeroFill(n){
    return ('0' + n).slice(-2);
}
function getMinTimeRespawn(min, time){
    var splits = time.split(':');
    var hour_death = parseInt(splits[0]);
    var minute_death = parseInt(splits[1]);

    var buffer = parseInt((min*60).toFixed(0));
    var mpr = parseInt(minute_death);
    var hpr = parseInt(hour_death);

    var div_buffer = parseInt(buffer/60);
    var rest_buffer = parseInt(buffer%60);
    hpr += div_buffer;
    mpr += rest_buffer;

    if(mpr >= 60){
        hpr++;
        mpr = mpr - 60;
    }
    if(hpr >= 24){
        hpr = (hpr-24);
    }

    var hour_probably_respawn = zeroFill(hpr.toString());
    var minute_probably_respawn = zeroFill(mpr.toString());

    return (hour_probably_respawn + ':' + minute_probably_respawn);
}
function getMaxTimeRespawn(max, time){
    var splits = time.split(':');
    var hour_death = parseInt(splits[0]);
    var minute_death = parseInt(splits[1]);

    var buffer = parseInt((max*60).toFixed(0));
    var mcr = parseInt(minute_death);
    var hcr = parseInt(hour_death);

    var div_buffer = parseInt(buffer/60);
    var rest_buffer = parseInt(buffer%60);
    hcr += div_buffer;
    mcr += rest_buffer;

    if(mcr >= 60){
        hcr++;
        mcr = mcr - 60;
    }
    if(hcr >= 24){
        hcr = (hcr - 24);
    }   

    var hour_certainly_respawn = zeroFill(hcr.toString());
    var minute_certainly_respawn = zeroFill(mcr.toString());

    return (hour_certainly_respawn + ':' + minute_certainly_respawn);
}
/********************************************************************************/

/**
 * Ghostring (1120)
 * treasure02 (33 à 53 minutos)
*/
var handleInterval11201;
function initTimer11201(){
    document.getElementById('1120-treasure-state').style.color = '#FEFEFE';
    document.getElementById('1120-treasure-state').style.background = '#FF2300';
    document.getElementById('1120-treasure-state').value = 'Dead';
    clearInterval(handleInterval11201);
    timer11201();
}
function timer11201(){
    var min_respawn = 0.6;
    var max_respawn = 0.9;
    var time = document.getElementById('1120-treasure-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1120-treasure-preborn').value = probably_respawn;
    document.getElementById('1120-treasure-creborn').value = certainly_respawn;

    handleInterval11201 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1120-treasure-state').style.color = '#FEFEFE';
            document.getElementById('1120-treasure-state').style.background = '#34CB79';
            document.getElementById('1120-treasure-state').value = 'Alive';
            document.getElementById('sound-gr-treasure').play();
            alert('Ghostring está vivo.');
            clearInterval(handleInterval11201);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1120-treasure-state').style.color = '#FEFEFE';
            document.getElementById('1120-treasure-state').style.background = '#008EE2';
            document.getElementById('1120-treasure-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Ghostring (1120)
 * pay_fild04 (1 à 1.5 horas)
*/
var handleInterval11202;
function initTimer11202(){
    document.getElementById('1120-pay-state').style.color = '#FEFEFE';
    document.getElementById('1120-pay-state').style.background = '#FF2300';
    document.getElementById('1120-pay-state').value = 'Dead';
    clearInterval(handleInterval11202);
    timer11202();
}
function timer11202(){
    var min_respawn = 1;
    var max_respawn = 1.5;
    var time = document.getElementById('1120-pay-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1120-pay-preborn').value = probably_respawn;
    document.getElementById('1120-pay-creborn').value = certainly_respawn;

    handleInterval11202 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1120-pay-state').style.color = '#FEFEFE';
            document.getElementById('1120-pay-state').style.background = '#34CB79';
            document.getElementById('1120-pay-state').value = 'Alive';
            document.getElementById('sound-gr-pay').play();
            alert('Ghostring está vivo.');
            clearInterval(handleInterval11202);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1120-pay-state').style.color = '#FEFEFE';
            document.getElementById('1120-pay-state').style.background = '#008EE2';
            document.getElementById('1120-pay-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Ghostring (1120)
 * prt_maze03 (1.9 à 2.8 horas)
*/
var handleInterval11203;
function initTimer11203(){
    document.getElementById('1120-prt-state').style.color = '#FEFEFE';
    document.getElementById('1120-prt-state').style.background = '#FF2300';
    document.getElementById('1120-prt-state').value = 'Dead';
    clearInterval(handleInterval11203);
    timer11203();
}
function timer11203(){
    var min_respawn = 1.9;
    var max_respawn = 2.8;
    var time = document.getElementById('1120-prt-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1120-prt-preborn').value = probably_respawn;
    document.getElementById('1120-prt-creborn').value = certainly_respawn;

    handleInterval11203 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1120-prt-state').style.color = '#FEFEFE';
            document.getElementById('1120-prt-state').style.background = '#34CB79';
            document.getElementById('1120-prt-state').value = 'Alive';
            document.getElementById('sound-gr-prt').play();
            alert('Ghostring está vivo.');
            clearInterval(handleInterval11203);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1120-prt-state').style.color = '#FEFEFE';
            document.getElementById('1120-prt-state').style.background = '#008EE2';
            document.getElementById('1120-prt-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Deviling (1582)
 * yuno_fild03 (1 à 1.5 horas)
*/
var handleInterval15821;
function initTimer15821(){
    document.getElementById('1582-yuno-state').style.color = '#FEFEFE';
    document.getElementById('1582-yuno-state').style.background = '#FF2300';
    document.getElementById('1582-yuno-state').value = 'Dead';
    clearInterval(handleInterval15821);
    timer15821();
}
function timer15821(){
    var min_respawn = 1;
    var max_respawn = 1.5;
    var time = document.getElementById('1582-yuno-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1582-yuno-preborn').value = probably_respawn;
    document.getElementById('1582-yuno-creborn').value = certainly_respawn;

    handleInterval15821 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1582-yuno-state').style.color = '#FEFEFE';
            document.getElementById('1582-yuno-state').style.background = '#34CB79';
            document.getElementById('1582-yuno-state').value = 'Alive';
            document.getElementById('sound-deviling-yuno').play();
            alert('Deviling está vivo.');
            clearInterval(handleInterval15821);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1582-yuno-state').style.color = '#FEFEFE';
            document.getElementById('1582-yuno-state').style.background = '#008EE2';
            document.getElementById('1582-yuno-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Deviling (1582)
 * pay_fild04 (2 à 3 horas)
*/
var handleInterval15822;
function initTimer15822(){
    document.getElementById('1582-pay-state').style.color = '#FEFEFE';
    document.getElementById('1582-pay-state').style.background = '#FF2300';
    document.getElementById('1582-pay-state').value = 'Dead';
    clearInterval(handleInterval15822);
    timer15822();
}
function timer15822(){
    var min_respawn = 2;
    var max_respawn = 3;
    var time = document.getElementById('1582-pay-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1582-pay-preborn').value = probably_respawn;
    document.getElementById('1582-pay-creborn').value = certainly_respawn;

    handleInterval15822 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1582-pay-state').style.color = '#FEFEFE';
            document.getElementById('1582-pay-state').style.background = '#34CB79';
            document.getElementById('1582-pay-state').value = 'Alive';
            document.getElementById('sound-deviling-pay').play();
            alert('Deviling está vivo.');
            clearInterval(handleInterval15822);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1582-pay-state').style.color = '#FEFEFE';
            document.getElementById('1582-pay-state').style.background = '#008EE2';
            document.getElementById('1582-pay-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Stormy Knight (1251)
 * xmas_dun02 (1 à 1.2 horas)
*/
var handleInterval1251;
function initTimer1251(){
    document.getElementById('1251-state').style.color = '#FEFEFE';
    document.getElementById('1251-state').style.background = '#FF2300';
    document.getElementById('1251-state').value = 'Dead';
    clearInterval(handleInterval1251);
    timer1251();
}
function timer1251(){
    var min_respawn = 1;
    var max_respawn = 1.2;
    var time = document.getElementById('1251-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1251-preborn').value = probably_respawn;
    document.getElementById('1251-creborn').value = certainly_respawn;

    handleInterval1251 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1251-state').style.color = '#FEFEFE';
            document.getElementById('1251-state').style.background = '#34CB79';
            document.getElementById('1251-state').value = 'Alive';
            document.getElementById('sound-sk').play();
            alert('Stormy Knight está vivo.');
            clearInterval(handleInterval1251);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1251-state').style.color = '#FEFEFE';
            document.getElementById('1251-state').style.background = '#008EE2';
            document.getElementById('1251-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Evil Snake Lord (1418)
 * gon_dun03 (1.8 à 2 horas)
*/
var handleInterval1418;
function initTimer1418(){
    document.getElementById('1418-state').style.color = '#FEFEFE';
    document.getElementById('1418-state').style.background = '#FF2300';
    document.getElementById('1418-state').value = 'Dead';
    clearInterval(handleInterval1418);
    timer1418();
}
function timer1418(){
    var min_respawn = 1.8;
    var max_respawn = 2;
    var time = document.getElementById('1418-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1418-preborn').value = probably_respawn;
    document.getElementById('1418-creborn').value = certainly_respawn;

    handleInterval1418 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1418-state').style.color = '#FEFEFE';
            document.getElementById('1418-state').style.background = '#34CB79';
            document.getElementById('1418-state').value = 'Alive';
            document.getElementById('sound-ss').play();
            alert('Evil Snake Lord está vivo.');
            clearInterval(handleInterval1418);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1418-state').style.color = '#FEFEFE';
            document.getElementById('1418-state').style.background = '#008EE2';
            document.getElementById('1418-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Mob Bio3 (1947 à 1951)
 * kh_dun02 (2 à 2.2 horas)
*/
var handleInterval1947a1951;
function initTimer1947a1951(){
    document.getElementById('1947-1951-state').style.color = '#FEFEFE';
    document.getElementById('1947-1951-state').style.background = '#FF2300';
    document.getElementById('1947-1951-state').value = 'Dead';
    clearInterval(handleInterval1734);
    timer1947a1951();
}
function timer1947a1951(){
    var min_respawn = 2;
    var max_respawn = 2.2;
    var time = document.getElementById('1947-1951-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1947-1951-preborn').value = probably_respawn;
    document.getElementById('1947-1951-creborn').value = certainly_respawn;

    handleInterval1947a1951 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1947-1951-state').style.color = '#FEFEFE';
            document.getElementById('1947-1951-state').style.background = '#34CB79';
            document.getElementById('1947-1951-state').value = 'Alive';
            document.getElementById('sound-lhz').play();
            alert('Mob Bio3 está vivo.');
            clearInterval(handleInterval1947a1951);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1947-1951-state').style.color = '#FEFEFE';
            document.getElementById('1947-1951-state').style.background = '#008EE2';
            document.getElementById('1947-1951-state').value = 'At Time';
        }
    }, 1000);
}


/**
 * Kiel-D01 (1734)
 * kh_dun02 (2 à 3 horas)
*/
var handleInterval1734;
function initTimer1734(){
    document.getElementById('1734-state').style.color = '#FEFEFE';
    document.getElementById('1734-state').style.background = '#FF2300';
    document.getElementById('1734-state').value = 'Dead';
    clearInterval(handleInterval1734);
    timer1734();
}
function timer1734(){
    var min_respawn = 2;
    var max_respawn = 3;
    var time = document.getElementById('1734-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1734-preborn').value = probably_respawn;
    document.getElementById('1734-creborn').value = certainly_respawn;

    handleInterval1734 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1734-state').style.color = '#FEFEFE';
            document.getElementById('1734-state').style.background = '#34CB79';
            document.getElementById('1734-state').value = 'Alive';
            document.getElementById('sound-kiel').play();
            alert('Kiel-D01 está vivo.');
            clearInterval(handleInterval1734);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1734-state').style.color = '#FEFEFE';
            document.getElementById('1734-state').style.background = '#008EE2';
            document.getElementById('1734-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Fallen Bishop (1871)
 * abbey02 (2 à 2.2 horas)
*/
var handleInterval1871;
function initTimer1871(){
    document.getElementById('1871-state').style.color = '#FEFEFE';
    document.getElementById('1871-state').style.background = '#FF2300';
    document.getElementById('1871-state').value = 'Dead';
    clearInterval(handleInterval1871);
    timer1871();
}
function timer1871(){
    var min_respawn = 2;
    var max_respawn = 2.2;
    var time = document.getElementById('1871-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1871-preborn').value = probably_respawn;
    document.getElementById('1871-creborn').value = certainly_respawn;

    handleInterval1871 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1871-state').style.color = '#FEFEFE';
            document.getElementById('1871-state').style.background = '#34CB79';
            document.getElementById('1871-state').value = 'Alive';
            document.getElementById('sound-bispo').play();
            alert('Fallen Bishop está vivo.');
            clearInterval(handleInterval1871);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1871-state').style.color = '#FEFEFE';
            document.getElementById('1871-state').style.background = '#008EE2';
            document.getElementById('1871-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Vesper (1685)
 * jupe_core (2 à 2.2 horas)
*/
var handleInterval1685;
function initTimer1685(){
    document.getElementById('1685-state').style.color = '#FEFEFE';
    document.getElementById('1685-state').style.background = '#FF2300';
    document.getElementById('1685-state').value = 'Dead';
    clearInterval(handleInterval1685);
    timer1685();
}
function timer1685(){
    var min_respawn = 2;
    var max_respawn = 2.2;
    var time = document.getElementById('1685-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1685-preborn').value = probably_respawn;
    document.getElementById('1685-creborn').value = certainly_respawn;

    handleInterval1685 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1685-state').style.color = '#FEFEFE';
            document.getElementById('1685-state').style.background = '#34CB79';
            document.getElementById('1685-state').value = 'Alive';
            document.getElementById('sound-vesper').play();
            alert('Vesper está vivo.');
            clearInterval(handleInterval1685);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1685-state').style.color = '#FEFEFE';
            document.getElementById('1685-state').style.background = '#008EE2';
            document.getElementById('1685-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Maya Macho (1289)
 * anthell01 (2 à 3 horas)
*/
var handleInterval1289;
function initTimer1289(){
    document.getElementById('1289-state').style.color = '#FEFEFE';
    document.getElementById('1289-state').style.background = '#FF2300';
    document.getElementById('1289-state').value = 'Dead';
    clearInterval(handleInterval1289);
    timer1289();
}
function timer1289(){
    var min_respawn = 2;
    var max_respawn = 3;
    var time = document.getElementById('1289-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1289-preborn').value = probably_respawn;
    document.getElementById('1289-creborn').value = certainly_respawn;

    handleInterval1289 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1289-state').style.color = '#FEFEFE';
            document.getElementById('1289-state').style.background = '#34CB79';
            document.getElementById('1289-state').value = 'Alive';
            document.getElementById('sound-mm').play();
            alert('Maya Purple está vivo.');
            clearInterval(handleInterval1289);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1289-state').style.color = '#FEFEFE';
            document.getElementById('1289-state').style.background = '#008EE2';
            document.getElementById('1289-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * White Lady (1630)
 * lou_dun03 (2 à 2.2 horas)
*/
var handleInterval1630;
function initTimer1630(){
    document.getElementById('1630-state').style.color = '#FEFEFE';
    document.getElementById('1630-state').style.background = '#FF2300';
    document.getElementById('1630-state').value = 'Dead';
    clearInterval(handleInterval1630);
    timer1630();
}
function timer1630(){
    var min_respawn = 2;
    var max_respawn = 2.2;
    var time = document.getElementById('1630-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1630-preborn').value = probably_respawn;
    document.getElementById('1630-creborn').value = certainly_respawn;

    handleInterval1630 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1630-state').style.color = '#FEFEFE';
            document.getElementById('1630-state').style.background = '#34CB79';
            document.getElementById('1630-state').value = 'Alive';
            document.getElementById('sound-lady').play();
            alert('White Lady está viva.');
            clearInterval(handleInterval1630);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1630-state').style.color = '#FEFEFE';
            document.getElementById('1630-state').style.background = '#008EE2';
            document.getElementById('1630-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Hatii (1252)
 * xmas_fild01 (2 à 2.2 horas)
*/
var handleInterval1252;
function initTimer1252(){
    document.getElementById('1252-state').style.color = '#FEFEFE';
    document.getElementById('1252-state').style.background = '#FF2300';
    document.getElementById('1252-state').value = 'Dead';
    clearInterval(handleInterval1252);
    timer1252();
}
function timer1252(){
    var min_respawn = 2;
    var max_respawn = 2.2;
    var time = document.getElementById('1252-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1252-preborn').value = probably_respawn;
    document.getElementById('1252-creborn').value = certainly_respawn;

    handleInterval1252 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1252-state').style.color = '#FEFEFE';
            document.getElementById('1252-state').style.background = '#34CB79';
            document.getElementById('1252-state').value = 'Alive';
            document.getElementById('sound-hatii').play();
            alert('Hatii está vivo.');
            clearInterval(handleInterval1252);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1252-state').style.color = '#FEFEFE';
            document.getElementById('1252-state').style.background = '#008EE2';
            document.getElementById('1252-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * RSX-0806 (1623)
 * ein_dun02 (2 à 2.2 horas)
*/
var handleInterval1623;
function initTimer1623(){
    document.getElementById('1623-state').style.color = '#FEFEFE';
    document.getElementById('1623-state').style.background = '#FF2300';
    document.getElementById('1623-state').value = 'Dead';
    clearInterval(handleInterval1623);
    timer1623();
}
function timer1623(){
    var min_respawn = 2;
    var max_respawn = 2.2;
    var time = document.getElementById('1623-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1623-preborn').value = probably_respawn;
    document.getElementById('1623-creborn').value = certainly_respawn;

    handleInterval1623 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1623-state').style.color = '#FEFEFE';
            document.getElementById('1623-state').style.background = '#34CB79';
            document.getElementById('1623-state').value = 'Alive';
            document.getElementById('sound-rsx').play();
            alert('RSX-0806 está vivo.');
            clearInterval(handleInterval1623);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1623-state').style.color = '#FEFEFE';
            document.getElementById('1623-state').style.background = '#008EE2';
            document.getElementById('1623-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Cenia [Chefe] (1658)
 * lhz_dun02 (2 à 2.2 horas)
*/
var handleInterval1658;
function initTimer1658(){
    document.getElementById('1658-state').style.color = '#FEFEFE';
    document.getElementById('1658-state').style.background = '#FF2300';
    document.getElementById('1658-state').value = 'Dead';
    clearInterval(handleInterval1658);
    timer1658();
}
function timer1658(){
    var min_respawn = 2;
    var max_respawn = 2.2;
    var time = document.getElementById('1658-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1658-preborn').value = probably_respawn;
    document.getElementById('1658-creborn').value = certainly_respawn;

    handleInterval1658 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1658-state').style.color = '#FEFEFE';
            document.getElementById('1658-state').style.background = '#34CB79';
            document.getElementById('1658-state').value = 'Alive';
            document.getElementById('sound-cenia').play();
            alert('Cenia [Chefe] está viva.');
            clearInterval(handleInterval1658);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1658-state').style.color = '#FEFEFE';
            document.getElementById('1658-state').style.background = '#008EE2';
            document.getElementById('1658-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Tao Gunka (1583)
 * beach_dun (5 à 5.2 horas)
*/
var handleInterval1583;
function initTimer1583(){
    document.getElementById('1583-state').style.color = '#FEFEFE';
    document.getElementById('1583-state').style.background = '#FF2300';
    document.getElementById('1583-state').value = 'Dead';
    clearInterval(handleInterval1583);
    timer1583();
}
function timer1583(){
    var min_respawn = 5;
    var max_respawn = 5.2;
    var time = document.getElementById('1583-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1583-preborn').value = probably_respawn;
    document.getElementById('1583-creborn').value = certainly_respawn;

    handleInterval1583 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1583-state').style.color = '#FEFEFE';
            document.getElementById('1583-state').style.background = '#34CB79';
            document.getElementById('1583-state').value = 'Alive';
            document.getElementById('sound-tg').play();
            alert('Tao Gunka está vivo.');
            clearInterval(handleInterval1583);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1583-state').style.color = '#FEFEFE';
            document.getElementById('1583-state').style.background = '#008EE2';
            document.getElementById('1583-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Gloom Under Night (1768)
 * ra_san05 (5 à 5.2 horas)
*/
var handleInterval1768;
function initTimer1768(){
    document.getElementById('1768-state').style.color = '#FEFEFE';
    document.getElementById('1768-state').style.background = '#FF2300';
    document.getElementById('1768-state').value = 'Dead';
    clearInterval(handleInterval1768);
    timer1768();
}
function timer1768(){
    var min_respawn = 5;
    var max_respawn = 5.2;
    var time = document.getElementById('1768-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1768-preborn').value = probably_respawn;
    document.getElementById('1768-creborn').value = certainly_respawn;

    handleInterval1768 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1768-state').style.color = '#FEFEFE';
            document.getElementById('1768-state').style.background = '#34CB79';
            document.getElementById('1768-state').value = 'Alive';
            document.getElementById('sound-pesar').play();
            alert('Gloom Under Night está vivo.');
            clearInterval(handleInterval1768);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1768-state').style.color = '#FEFEFE';
            document.getElementById('1768-state').style.background = '#008EE2';
            document.getElementById('1768-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Golden Thief Bug (1086)
 * prt_sewb4 (6 à 6.2 horas)
*/
var handleInterval1086;
function initTimer1086(){
    document.getElementById('1086-state').style.color = '#FEFEFE';
    document.getElementById('1086-state').style.background = '#FF2300';
    document.getElementById('1086-state').value = 'Dead';
    clearInterval(handleInterval1086);
    timer1086();
}
function timer1086(){
    var min_respawn = 6;
    var max_respawn = 6.2;
    var time = document.getElementById('1086-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1086-preborn').value = probably_respawn;
    document.getElementById('1086-creborn').value = certainly_respawn;

    handleInterval1086 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1086-state').style.color = '#FEFEFE';
            document.getElementById('1086-state').style.background = '#34CB79';
            document.getElementById('1086-state').value = 'Alive';
            document.getElementById('sound-gtb').play();
            alert('Golden Thief Bug está vivo.');
            clearInterval(handleInterval1086);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1086-state').style.color = '#FEFEFE';
            document.getElementById('1086-state').style.background = '#008EE2';
            document.getElementById('1086-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Valkyrie Randgris (1751)
 * odin_tem03 (8 à 8.2 horas)
*/
var handleInterval1751;
function initTimer1751(){
    document.getElementById('1751-state').style.color = '#FEFEFE';
    document.getElementById('1751-state').style.background = '#FF2300';
    document.getElementById('1751-state').value = 'Dead';
    clearInterval(handleInterval1751);
    timer1751();
}
function timer1751(){
    var min_respawn = 8;
    var max_respawn = 8.2;
    var time = document.getElementById('1751-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1751-preborn').value = probably_respawn;
    document.getElementById('1751-creborn').value = certainly_respawn;

    handleInterval1751 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1751-state').style.color = '#FEFEFE';
            document.getElementById('1751-state').style.background = '#34CB79';
            document.getElementById('1751-state').value = 'Alive';
            document.getElementById('sound-valk').play();
            alert('Valkyrie Randgris está viva.');
            clearInterval(handleInterval1751);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1751-state').style.color = '#FEFEFE';
            document.getElementById('1751-state').style.background = '#008EE2';
            document.getElementById('1751-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Ifrit (1832)
 * thor_v03 (11 à 11.2 horas)
*/
var handleInterval1832;
function initTimer1832(){
    document.getElementById('1832-state').style.color = '#FEFEFE';
    document.getElementById('1832-state').style.background = '#FF2300';
    document.getElementById('1832-state').value = 'Dead';
    clearInterval(handleInterval1832);
    timer1832();
}
function timer1832(){
    var min_respawn = 11;
    var max_respawn = 11.2;
    var time = document.getElementById('1832-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1832-preborn').value = probably_respawn;
    document.getElementById('1832-creborn').value = certainly_respawn;

    handleInterval1832 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1832-state').style.color = '#FEFEFE';
            document.getElementById('1832-state').style.background = '#34CB79';
            document.getElementById('1832-state').value = 'Alive';
            document.getElementById('sound-ifrit').play();
            alert('Ifrit está vivo.');
            clearInterval(handleInterval1832);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1832-state').style.color = '#FEFEFE';
            document.getElementById('1832-state').style.background = '#008EE2';
            document.getElementById('1832-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Beelzebub (1873)
 * abbey03 (12 à 12.2 horas)
*/
var handleInterval1873;
function initTimer1873(){
    document.getElementById('1873-state').style.color = '#FEFEFE';
    document.getElementById('1873-state').style.background = '#FF2300';
    document.getElementById('1873-state').value = 'Dead';
    clearInterval(handleInterval1873);
    timer1873();
}
function timer1873(){
    var min_respawn = 12;
    var max_respawn = 12.2;
    var time = document.getElementById('1873-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1873-preborn').value = probably_respawn;
    document.getElementById('1873-creborn').value = certainly_respawn;

    handleInterval1873 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if((currentTime >= certainly_respawn)){
            document.getElementById('1873-state').style.color = '#FEFEFE';
            document.getElementById('1873-state').style.background = '#34CB79';
            document.getElementById('1873-state').value = 'Alive';
            document.getElementById('sound-belzebu').play();
            alert('Beelzebub está vivo.');
            clearInterval(handleInterval1873);
        }
        else if((currentTime >= probably_respawn)){
            document.getElementById('1873-state').style.color = '#FEFEFE';
            document.getElementById('1873-state').style.background = '#008EE2';
            document.getElementById('1873-state').value = 'At Time';
        }
    }, 1000);
}

/**
 * Morroc Ferido (1917)
 * moc_fild22 (12 à 12.2 horas)
*/
var handleInterval1917;
function initTimer1917(){
    document.getElementById('1917-state').style.color = '#FEFEFE';
    document.getElementById('1917-state').style.background = '#FF2300';
    document.getElementById('1917-state').value = 'Dead';
    clearInterval(handleInterval1917);
    timer1917();
}
function timer1917(){
    var min_respawn = 12;
    var max_respawn = 12.2;
    var time = document.getElementById('1917-death').value;
    var probably_respawn = getMinTimeRespawn(min_respawn, time);
    var certainly_respawn = getMaxTimeRespawn(max_respawn, time);

    document.getElementById('1917-preborn').value = probably_respawn;
    document.getElementById('1917-creborn').value = certainly_respawn;

    handleInterval1917 = setInterval(() => {
        const now = new Date();
        const currentTime = zeroFill(now.getHours()) + ':' + zeroFill(now.getMinutes());

        if( (currentTime >= certainly_respawn) ){
            document.getElementById('1917-state').style.color = '#FEFEFE';
            document.getElementById('1917-state').style.background = '#34CB79';
            document.getElementById('1917-state').value = 'Alive';
            document.getElementById('sound-morroc').play();
            alert('Morroc está vivo.');
            clearInterval(handleInterval1917);
        }
        else if( (currentTime >= probably_respawn) ){
            document.getElementById('1917-state').style.color = '#FEFEFE';
            document.getElementById('1917-state').style.background = '#008EE2';
            document.getElementById('1917-state').value = 'At Time';
        }
    }, 1000);
}
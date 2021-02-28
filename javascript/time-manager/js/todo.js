function pageRefresh(){
    setTimeout(function(){
        window.location.reload(1);
    }, 1000);
}

function sortDatabase(a, b){
    let dateA = a.date;
    let diaA = dateA[0] + dateA[1];
    let mesA = dateA[3] + dateA[4];
    let anoA = dateA[6] + dateA[7] + dateA[8] + dateA[9];

    let dateB = b.date;
    let diaB = dateB[0] + dateB[1];
    let mesB = dateB[3] + dateB[4];
    let anoB = dateB[6] + dateB[7] + dateB[8] + dateB[9];

    //return ( (anoA < anoB) || (anoA == anoB && mesA < mesB) || (anoA == anoB && mesA == mesB && diaA > diaB) );
    return (anoA < anoB ? -1 : mesA < mesB ? -1 : diaA > diaB ? 0 : 1);
}

function verifyEventDeadline(eventDate){
    let date = new Date();
    let year = date.getFullYear();
    let month = date.getMonth() + 1; //+1 pois os meses são dados pela função em números de 0 a 11
    let day = date.getDate();

    let diaEvent = eventDate[0] + eventDate[1];
    let mesEvent = eventDate[3] + eventDate[4];
    let anoEvent = eventDate[6] + eventDate[7] + eventDate[8] + eventDate[9];

    let deadline = (Number(day) - Number(diaEvent));

    if(Number(year) >= Number(anoEvent)){
        if(Number(month) >= Number(mesEvent)){
            if(deadline <= 7){
                 return 0;
            }
        }
    }

    return 1;
}

function setTodoList(){
    dbTodo.sort(sortDatabase);

    for(var i = 0; i < dbTodo.length; i++){

        var divDate = document.getElementById('todo-date');
        var divDescription = document.getElementById('todo-description');

        var divEventDate = document.createElement('div');
        var divEventDescription = document.createElement('div');

        var eventDesc = document.createElement('div');
        var eventDate = document.createElement('div');

        if(verifyEventDeadline(dbTodo[i].date)){
            divEventDate.setAttribute('class', 'event');
            divEventDescription.setAttribute('class', 'event');
        }
        else{
            divEventDate.setAttribute('class', 'event-deadline');
            divEventDescription.setAttribute('class', 'event-deadline');
        }

        eventDate.setAttribute('class', 'event-date');
        eventDesc.setAttribute('class', 'event-desc');

        eventDate.appendChild(document.createTextNode(dbTodo[i].date));
        eventDesc.appendChild(document.createTextNode(dbTodo[i].description));

        divEventDate.appendChild(eventDate);
        divEventDescription.appendChild(eventDesc);

        divDate.appendChild(divEventDate);
        divDescription.appendChild(divEventDescription);
    }
}

setTimeout(setTodoList, 100);
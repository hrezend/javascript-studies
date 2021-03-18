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

    //console.log('Data 1: ' + diaA + '/' + mesA + '/' + anoA + ' Data 2: ' + diaB + '/' + mesB + '/' + anoB);
    return ( (Number(anoA) > Number(anoB)) || (Number(anoA) == Number(anoB) && Number(mesA) > Number(mesB)) || (Number(anoA) == Number(anoB) && Number(mesA) == Number(mesB) && Number(diaA) > Number(diaB)) );
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
    console.log(deadline)

    if(Number(year) >= Number(anoEvent)){
        if(Number(month) >= Number(mesEvent)){
            if(deadline == 0){
                return 'at';
            }
        }
    }
    if(Number(year) >= Number(anoEvent)){
        if(Number(month) >= Number(mesEvent)){
            if(deadline > 0){
                return 'after';
            }
        }
    }
    if(Number(year) >= Number(anoEvent)){
        if(Number(month) >= Number(mesEvent)){
            if(deadline <= 7){
                 return 'during';
            }
        }
    }

    return 'before';
}

function setTodoList(){
    dbTodo.sort(sortDatabase);

    for(var i = 0; i < dbTodo.length; i++){

        var divDate = document.getElementById('todo-date');
        var divTitle = document.getElementById('todo-title');
        var divDescription = document.getElementById('todo-description');
        var divState = document.getElementById('todo-state');

        var divEventDate = document.createElement('div');
        var divEventTitle = document.createElement('div');
        var divEventDescription = document.createElement('div');
        var divEventState = document.createElement('div');

        var eventDate = document.createElement('div');
        var eventTitle = document.createElement('div');
        var eventDesc = document.createElement('div');
        var eventState = document.createElement('div');

        //console.log(verifyEventDeadline(dbTodo[i].date));

        if(verifyEventDeadline(dbTodo[i].date) === 'before'){
            divEventDate.setAttribute('class', 'event-before-deadline');
            divEventTitle.setAttribute('class', 'event-before-deadline');
            divEventDescription.setAttribute('class', 'event-before-deadline');
            divEventState.setAttribute('class', 'event-before-deadline');
        }
        if(verifyEventDeadline(dbTodo[i].date) === 'at'){
            divEventDate.setAttribute('class', 'event-at');
            divEventTitle.setAttribute('class', 'event-at');
            divEventDescription.setAttribute('class', 'event-at');
            divEventState.setAttribute('class', 'event-at');
        }
        if(verifyEventDeadline(dbTodo[i].date) === 'during'){
            divEventDate.setAttribute('class', 'event-during-deadline');
            divEventTitle.setAttribute('class', 'event-during-deadline');
            divEventDescription.setAttribute('class', 'event-during-deadline');
            divEventState.setAttribute('class', 'event-during-deadline');
        }
        if(verifyEventDeadline(dbTodo[i].date) === 'after'){
            divEventDate.setAttribute('class', 'event-after-deadline');
            divEventTitle.setAttribute('class', 'event-after-deadline');
            divEventDescription.setAttribute('class', 'event-after-deadline');
            divEventState.setAttribute('class', 'event-after-deadline');
        }

        eventDate.setAttribute('class', 'event-card');
        eventTitle.setAttribute('class', 'event-card');
        eventDesc.setAttribute('class', 'event-card');
        eventState.setAttribute('class', 'event-card');

        eventDate.appendChild(document.createTextNode(dbTodo[i].date));
        eventTitle.appendChild(document.createTextNode(dbTodo[i].title));
        eventDesc.appendChild(document.createTextNode(dbTodo[i].description));

        if(dbTodo[i].state == 0){
            eventState.appendChild(document.createTextNode('To Do'));
        }
        else if(dbTodo[i].state == 1){
            eventState.appendChild(document.createTextNode('Done'));
        }

        divEventDate.appendChild(eventDate);
        divEventTitle.appendChild(eventTitle);
        divEventDescription.appendChild(eventDesc);
        divEventState.appendChild(eventState);

        divDate.appendChild(divEventDate);
        divTitle.appendChild(divEventTitle);
        divDescription.appendChild(divEventDescription);
        divState.appendChild(divEventState);
    }
}

setTimeout(setTodoList, 100);
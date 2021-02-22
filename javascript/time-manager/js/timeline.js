function pageRefresh(){
    setTimeout(function(){
        window.location.reload(1);
    }, 1000);
}

function setTimeline(){
    for(var i = 0; i < dbTimeline.length; i++){

        if(dbTimeline[i].day == 'Sunday'){
            var day = document.getElementById('d-sunday');
        }
        else if(dbTimeline[i].day == 'Monday'){
            var day = document.getElementById('d-monday');
        }
        else if(dbTimeline[i].day == 'Tuesday'){
            var day = document.getElementById('d-tuesday');
        }
        else if(dbTimeline[i].day == 'Wednesday'){
            var day = document.getElementById('d-wednesday');
        }
        else if(dbTimeline[i].day == 'Thursday'){
            var day = document.getElementById('d-thursday');
        }
        else if(dbTimeline[i].day == 'Friday'){
            var day = document.getElementById('d-friday');
        }
        else if(dbTimeline[i].day == 'Saturday'){
            var day = document.getElementById('d-saturday');
        }

        var event = document.createElement('div');
        var eventDesc = document.createElement('div');
        var eventTime = document.createElement('div');
        var eventLink = document.createElement('div');

        event.setAttribute('class', 'event');
        eventDesc.setAttribute('class', 'event-desc');
        eventTime.setAttribute('class', 'event-time');
        eventLink.setAttribute('class', 'event-link');

        eventDesc.appendChild(document.createTextNode(dbTimeline[i].description));
        eventTime.appendChild(document.createTextNode(dbTimeline[i].time));
        eventLink.appendChild(document.createTextNode(dbTimeline[i].link));

        event.appendChild(eventDesc);
        event.appendChild(eventTime);
        event.appendChild(eventLink);

        day.appendChild(event);
    }
}

setTimeout(setTimeline, 100);
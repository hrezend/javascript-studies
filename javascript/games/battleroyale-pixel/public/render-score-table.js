function updateScoreTable(){
    const scoreTable = document.getElementById('score');
    const maxResults = 10;

    let scoreTableInnerHTML = `
        <tr class="header">
            <td>Top 10 Jogadores |</td>
            <td>Pontos</td>
        </tr>
    `
    const scoreArray = [];

    for(socketId in game.players){
        const player = game.players[socketId];
        scoreArray.push({
            socketId: socketId,
            score: player.score
        });
    }

    const scoreArraySorted = scoreArray.sort((first, second) => {
        if (first.score < second.score){
            return 1
        }

        if (first.score > second.score){
            return -1
        }

        return 0
    });

    const scoreSliced = scoreArraySorted.slice(0, maxResults);

    scoreSliced.forEach((score) => {
        scoreTableInnerHTML += `
            <tr class="${ socket.id === score.socketId ? 'current-player' : ''}">
                <td class="socket-id">${score.socketId}</td>
                <td class="score-value">${score.score}</td>
            </tr>
        `
    });

    let playerNotInTop10 = true;

    for(const score of scoreSliced){
        if(socket.id === score.socketId){
            playerNotInTop10 = false;
            break;
        }

        playerNotInTop10 = true;
    }

    if (playerNotInTop10){
        scoreTableInnerHTML += `
            <tr class="current-player bottom">
                <td class="socket-id">${socket.id}</td>
                <td class="score-value">${game.players[socket.id].score}</td>
            </tr>
        `
    }

    scoreTableInnerHTML += `
        <tr class="footer">
            <td>Total de jogadores</td>
            <td align="right">${totalPlayersCount}</td>
        </tr>
    `

    scoreTable.innerHTML = scoreTableInnerHTML;
}
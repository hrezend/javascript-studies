export function setupScreen(canvas, game) {
    const { screen: {width, height, pixelsPerFields} } = game.state;
    canvas.width = width * pixelsPerFields;
    canvas.height = height * pixelsPerFields;
}

export default function renderScreen(screen, scoreTable, game, requestAnimationFrame, currentPlayerId){
    const context = screen.getContext('2d');
    context.fillStyle = 'white';
    const { screen: { width, height, pixelsPerFields }} = game.state;
    context.clearRect(0, 0, width*pixelsPerFields, height*pixelsPerFields);

    for (const playerId in game.state.players){
        const player = game.state.players[playerId];
        drawPlayer(context, player, game);
    }

    for (const fruitId in game.state.fruits){
        const fruit = game.state.fruits[fruitId];
        drawFruit(context, fruit, game);
    }

    const currentPlayer = game.state.players[currentPlayerId];
    if(currentPlayer){
        const isCurrentPlayer = true;
        drawPlayer(context, currentPlayer, game, isCurrentPlayer);
    }

    updateScoreTable(scoreTable, game, currentPlayerId);

    requestAnimationFrame(() => {
        renderScreen(screen, scoreTable, game, requestAnimationFrame, currentPlayerId);
    });
}

function drawPlayer(screenContext, player, game, isCurrentPlayer = false){
    const { screen: { pixelsPerFields }} = game.state;

    let { x, y } = player;
    x *= pixelsPerFields;
    y *= pixelsPerFields;

    const shield = './images/shield.png';
    const daggers = './images/daggers.png';
    const plus =  './images/heal.png';

    const tank = new Image();
    tank.src = shield;

    if(isCurrentPlayer){
        tank.src = daggers;
    }

    screenContext.drawImage(tank, x, y, pixelsPerFields, pixelsPerFields);
}

function drawFruit(screenContext, fruit, game) {
    const { screen: { pixelsPerFields }} = game.state;
    screenContext.globalAlpha = 1;
    
    let { x, y } = fruit;
    x *= pixelsPerFields;
    y *= pixelsPerFields;
    
    // Draw burguer   
    const hamburguer = './images/hamburguer.png';
    const burguer = new Image();
    burguer.src = hamburguer;
    screenContext.drawImage(burguer, x, y, pixelsPerFields, pixelsPerFields);
}

function updateScoreTable(scoreTable, game, currentPlayerId){
    const maxResults = 10;

    let scoreTableInnerHTML = `
        <tr class="header">
            <td>Ranking</td>
            <td>Score</td>
        </tr>
    `;

    const playersArray = [];

    for(let socketId in game.state.players){
        const player = game.state.players[socketId];
        playersArray.push({
            playerId: socketId,
            playerName: player.playerName,
            score: player.score,
        });
    }
    
    const playersSortedByScore = playersArray.sort( (first, second) => {
        if (first.score < second.score){
            return 1
        }

        if (first.score > second.score){
            return -1
        }

        return 0
    });

    const scoreSliced = playersSortedByScore.slice(0, maxResults);

    scoreSliced.forEach((score) => {
        scoreTableInnerHTML += `
            <tr class="${ score.playerId === currentPlayerId ? 'current-player' : ''}">
                <td class="socket-id">${score.playerName}</td>
                <td class="score-value">${score.score}</td>
            </tr>
        `
    });

    let playerInTop10 = false;
    for (const player of scoreSliced){
        if (player.playerId === currentPlayerId){
            playerInTop10 = true;
            break;
        }
    }

    if(!playerInTop10){
        const currentPlayerFromTopScore = game.state.players[currentPlayerId];

        if(!currentPlayerFromTopScore){
            return;
        }

        scoreTableInnerHTML += `
            <tr class="current-player">
                <td class="socket-id">${game.state.players[socketId].playerName}</td>
                <td class="score-value">${currentPlayerFromTopScore.score}</td>
            </tr>
        `
    }

    scoreTable.innerHTML = scoreTableInnerHTML;
}
export function setupScreen(canvas, game) {
    const { screen: {width, height, pixelsPerFields} } = game.state;
    canvas.width = width * pixelsPerFields;
    canvas.height = height * pixelsPerFields;
}

export default function renderScreen(screen, scoreTable, game, requestAnimationFrame, currentPlayerId){
    const context = screen.getContext('2d');
    const { screen: { width, height, pixelsPerFields }} = game.state;
    context.fillStyle = 'white';
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

    let colorFill = 'pink';

    if(isCurrentPlayer){
        colorFill = 'red';
    }

    screenContext.fillStyle = colorFill;
    screenContext.fillRect(x, y, pixelsPerFields, pixelsPerFields);

    screenContext.fillStyle = 'black';
    screenContext.fillRect(x+1,y+1,1,1);
    screenContext.fillRect(x+3,y+1,1,1);
    screenContext.fillRect(x+1,y+3,3,1);
}

function drawFruit(screenContext, fruit, game) {
    const { screen: { pixelsPerFields }} = game.state;
    screenContext.globalAlpha = 1;
    
    let { x, y } = fruit;
    x *= pixelsPerFields;
    y *= pixelsPerFields;
    
    // Draw strawberry body
    screenContext.fillStyle = '#ff0000';
    screenContext.fillRect(x, y+1, 1, 2);
    screenContext.fillRect(x+4, y+1, 1, 2);
    screenContext.fillRect(x+1, y+1, 1, 3);
    screenContext.fillRect(x+3, y+1, 1, 3);
    screenContext.fillRect(x+2, y+2, 1, 3);
 
    // Draw green leaf
    screenContext.fillStyle = '#00a933';
    screenContext.fillRect(x+1,y,3,1);
    screenContext.fillRect(x+2,y+1,1,1);
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
import { mod } from "./utils.js";

export default function createGame(){
    const state = {
        players: {},
        fruits: {},
        screen: {
            width: 30,
            height: 15,
            pixelsPerFields: 5,
        }
    }

    const observers = [];

    function start(){
        const frequency = 10000;

        setInterval(addFruit, frequency);
    }

    function subscribe(observerFunction){
        observers.push(observerFunction);
    }

    function notifyAll(command){
        for (const observerFunction of observers){
            observerFunction(command);
        }
    }

    function setState(newState){
        Object.assign(state, newState);
    }

    //retorna array com os Id's dos players
    function getIdPlayers(){
        let { players } = state;
        let playersId = [];
        
        for(const playerId in players){
            playersId.push(playerId);        
        }

        return playersId;      
    }

    function addPlayer(command) {
        const playerId = command.playerId;
        const playerName = command.playerName;
        const playerX = 'playerX' in command ? command.playerX : Math.floor(Math.random() * state.screen.width);
        const playerY = 'playerY' in command ? command.playerY : Math.floor(Math.random() * state.screen.height);

        state.players[playerId] = {
            x: playerX,
            y: playerY,
            score: 0,
            playerName: playerName,
        }

        notifyAll({
            type: 'add-player',
            playerId: playerId,
            playerName: playerName,
            score: 0,
            playerX: playerX,
            playerY: playerY,
        });

        notifyAll({
            type: 'play-audio',
            audio: 'newPlayer',
            playersId: getIdPlayers()
        });
    }

    function removePlayer(command) {
        const playerId = command.playerId;

        delete state.players[playerId];

        notifyAll({
            type: 'remove-player',
            playerId: playerId
        });
    }

    function addFruit(command) {
        const fruitId = command ? command.fruitId : Math.floor(Math.random() * 10000000);
        const fruitX = command ? command.fruitX : Math.floor(Math.random() * state.screen.width);
        const fruitY = command ? command.fruitY : Math.floor(Math.random() * state.screen.height);

        state.fruits[fruitId] = {
            x: fruitX,
            y: fruitY
        }

        notifyAll({
            type: 'add-fruit',
            fruitId: fruitId,
            fruitX: fruitX,
            fruitY: fruitY
        });

        notifyAll({
            type: 'play-audio',
            audio: 'newFruit',
            playersId: getIdPlayers()
        });
    }

    function removeFruit(command){
        const {fruitId} = command;

        delete state.fruits[fruitId];

        notifyAll({
            type: 'remove-fruit',
            fruitId: fruitId,
        });
    }

    function movePlayer(command){
        notifyAll(command);

        const acceptedMoves = {
            ArrowUp(player){
                if (player.y - 1 >= 0){
                    player.y = mod(state.screen.height, player.y - 1);
                }
            },
            ArrowRight(player){
                if (player.x + 1 < state.screen.width){
                    player.x = mod(state.screen.width, player.x + 1);
                }
            },
            ArrowDown(player){
                if (player.y + 1 < state.screen.height){
                    player.y = mod(state.screen.height, player.y + 1);
                }
            },
            ArrowLeft(player){
                if (player.x - 1 >= 0){
                    player.x = mod(state.screen.width, player.x - 1);
                }
            }
        }

        const keyPressed = command.keyPressed;
        const playerId = command.playerId;
        const player = state.players[playerId];
        const moveFunction = acceptedMoves[keyPressed];

        if (player && moveFunction) {
            moveFunction(player);
            checkForFruitCollision(playerId);
        }

    }

    function checkForFruitCollision(playerId){
        const player = state.players[playerId];

        for (const fruitId in state.fruits) {
            const fruit = state.fruits[fruitId];
            //console.log(`Checking collision between ${playerId} and ${fruitId}`);

            if(player.x === fruit.x && player.y === fruit.y){
                player.score = player.score + 1;
                removeFruit({ fruitId, playerId });
                console.log(`--> Collision detected between ${playerId} and ${fruitId} // ${playerId} - score: ${player.score}`);
            
                notifyAll({
                    type: 'play-audio',
                    audio: 'collect',
                    playersId: [playerId]
                });
            }
        }
    }

    return {
        addPlayer,
        removePlayer,
        movePlayer,
        addFruit,
        removeFruit,
        state,
        setState,
        subscribe,
        start
    }
}

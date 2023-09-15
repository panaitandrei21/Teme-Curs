let board = [];
let openedSquares = [];
let flaggedSquares = [];
let bombCount = 0;
let squaresLeft = 0;
let bombProbability = 3;
let maxProbability = 15;

class BoardSquare {
    constructor(hasBomb = false, bombsAround = 0) {
        this.hasBomb = hasBomb;
        this.bombsAround = bombsAround;
    }
}

class Pair {
    constructor(x, y) {
        this.x = x;
        this.y = y;
    }
}

function minesweeperGameBootstrapper() {
    const difficulty = document.getElementById('difficulty').value;

    let rowCount, colCount;

    switch (difficulty) {
        case 'easy':
            rowCount = 5;
            colCount = 5;
            break;
        case 'medium':
            rowCount = 10;
            colCount = 10;
            break;
        case 'hard':
            rowCount = 15;
            colCount = 15;
            break;
        default:
            rowCount = 5;
            colCount = 5;
            break;
    }

    generateBoard({'rowCount': rowCount, 'colCount': colCount});
}

function generateBoard(boardMetadata) {
    squaresLeft = boardMetadata.colCount * boardMetadata.rowCount;
    const difficulty = document.getElementById('difficulty');
    console.log(difficulty)
    for (let i = 0; i < boardMetadata.rowCount; i++) {
        board[i] = new Array(boardMetadata.colCount);
    }

    for(let i = 0; i < boardMetadata.rowCount; i++) {
        for(let j = 0; j < boardMetadata.colCount; j++) {
            board[i][j] = new BoardSquare();
            if(Math.random() * maxProbability < bombProbability) {
                board[i][j].hasBomb = true;
            }
        }
    }

    displayBoard();
}

function displayBoard() {
    const boardElem = document.getElementById('board');
    boardElem.innerHTML = ''; 
    
    for (let i = 0; i < board.length; i++) {
        const rowElem = document.createElement('tr');
        for (let j = 0; j < board[i].length; j++) {
            const cellElem = document.createElement('td');
            cellElem.style.width = '30px';
            cellElem.style.height = '30px';
            cellElem.setAttribute('data-row', i);
            cellElem.setAttribute('data-col', j);
        
            rowElem.appendChild(cellElem);
        }
        boardElem.appendChild(rowElem);
    }
}

function discoverSquare(row, col) {
    const square = board[row][col];
    const cellElem = document.querySelector(`[data-row="${row}"][data-col="${col}"]`);

    if (square.hasBomb) {
        cellElem.style.backgroundColor = 'red';
        alert('Game Over, bomb');
    } else {
        const bombsAround = countBombsAround(row, col);
        cellElem.textContent = bombsAround > 0 ? bombsAround : '';
        cellElem.style.backgroundColor = 'green';
    }
}

function countBombsAround(row, col) {
    const directions = [
        [-1, -1], [-1, 0], [-1, 1],
        [0, -1],           [0, 1],
        [1, -1], [1, 0], [1, 1]
    ];
    
    let count = 0;
    directions.forEach(direction => {
        const newRow = row + direction[0];
        const newCol = col + direction[1];
        if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[newRow].length && board[newRow][newCol].hasBomb) {
            count++;
        }
    });
    return count;
}

function setupGame() {
  
    minesweeperGameBootstrapper();
}
function selectSquare() {
    let row = parseInt(document.getElementById('selectRow').value, 10);
    let col = parseInt(document.getElementById('selectCol').value, 10);
    discoverSquare(row, col);
}
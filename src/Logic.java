import java.util.ArrayList;

public class Logic {

    public void checkMate() {
        //for blackKing:
        for(int i = Pieces.pieces.size()/2; i < Pieces.pieces.size(); i++) {
            ArrayList<Position> movingPositions = getMovingPositions(Pieces.pieces.get(i), Pieces.pieces.get(i).pos.x, Pieces.pieces.get(i).pos.y);
            for(Position position : movingPositions) {
                if(Pieces.board[position.x][position.y] != null && Pieces.board[position.x][position.y].id.equals("blackKing")) {
                    Panel.check = true;
                    Panel.checkMateKing = Pieces.board[position.x][position.y];
                    Panel.checkMatePiece = Pieces.pieces.get(i);
                }
            }
        }
        //for whiteKing:
        for(int i = 0; i < Pieces.pieces.size()/2; i++) {
            ArrayList<Position> movingPositions = getMovingPositions(Pieces.pieces.get(i), Pieces.pieces.get(i).pos.x, Pieces.pieces.get(i).pos.y);
            for(Position position : movingPositions) {
                if(Pieces.board[position.x][position.y] != null && Pieces.board[position.x][position.y].id.equals("whiteKing")) {
                    Panel.check = true;
                    Panel.checkMateKing = Pieces.board[position.x][position.y];
                    Panel.checkMatePiece = Pieces.pieces.get(i);
                }
            }
        }

    }

    public ArrayList<Position> getMovingPositions(Pieces piece, int cellX, int cellY) {

        ArrayList<Position> positions = new ArrayList<>();
        switch (piece.id) {
            case "blackPawn" -> {
                if (cellY + 1 < 8 && Pieces.board[cellX][cellY + 1] == null) {
                    positions.add(new Position(cellX, cellY + 1));
                }
                if (cellX + 1 < 8 && cellY + 1 < 8 && Pieces.board[cellX + 1][cellY + 1] != null
                        && Pieces.board[cellX + 1][cellY + 1].color.equals("white")) {
                    positions.add(new Position(cellX + 1, cellY + 1));
                }
                if (cellX - 1 >= 0 && cellY + 1 < 8 && Pieces.board[cellX - 1][cellY + 1] != null
                        && Pieces.board[cellX - 1][cellY + 1].color.equals("white")) {
                    positions.add(new Position(cellX - 1, cellY + 1));
                }
                if (cellY == 1) {
                    if (Pieces.board[cellX][cellY + 1] == null && Pieces.board[cellX][cellY + 2] == null) {
                        positions.add(new Position(cellX, cellY + 2));
                    }
                }
            }
            case "blackRook" -> {
                //for x:
                int x = cellX + 1;
                while (x < 8) {
                    if (Pieces.board[x][cellY] == null) {
                        positions.add(new Position(x, cellY));
                    } else if (Pieces.board[x][cellY].color.equals("white")) {
                        positions.add(new Position(x, cellY));
                        break;
                    } else {
                        break;
                    }
                    x++;
                }
                x = cellX - 1;
                while (x >= 0) {
                    if (Pieces.board[x][cellY] == null) {
                        positions.add(new Position(x, cellY));
                    } else if (Pieces.board[x][cellY].color.equals("white")) {
                        positions.add(new Position(x, cellY));
                        break;
                    } else {
                        break;
                    }
                    x--;
                }
                //for y:
                int y = cellY + 1;
                while (y < 8) {
                    if (Pieces.board[cellX][y] == null) {
                        positions.add(new Position(cellX, y));
                    } else if (Pieces.board[cellX][y].color.equals("white")) {
                        positions.add(new Position(cellX, y));
                        break;
                    } else {
                        break;
                    }
                    y++;
                }
                y = cellY - 1;
                while (y >= 0) {
                    if (Pieces.board[cellX][y] == null) {
                        positions.add(new Position(cellX, y));
                    } else if (Pieces.board[cellX][y].color.equals("white")) {
                        positions.add(new Position(cellX, y));
                        break;
                    } else {
                        break;
                    }
                    y--;
                }
            }
            case "blackBishop" -> {
                //for leading diagonal:
                int x = cellX + 1, y = cellY + 1;
                while (x < 8 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                        break;
                    } else {
                        break;
                    }
                    x++;
                    y++;
                }
                x = cellX - 1;
                y = cellY - 1;
                while (x >= 0 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                        break;
                    } else {
                        break;
                    }
                    x--;
                    y--;
                }
                //for non-leading diagonal:
                x = cellX - 1;
                y = cellY + 1;
                while (x >= 0 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                        break;
                    } else {
                        break;
                    }
                    x--;
                    y++;
                }
                x = cellX + 1;
                y = cellY - 1;
                while (x < 8 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                        break;
                    } else {
                        break;
                    }
                    x++;
                    y--;
                }
            }
            case "blackHorse" -> {
                int x = cellX, y = cellY;
                x += 1;
                y += 2;
                if (x < 8 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX;
                y = cellY;
                x += 2;
                y += 1;
                if (x < 8 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX;
                y = cellY;
                x += 2;
                y -= 1;
                if (x < 8 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX;
                y = cellY;
                x += 1;
                y -= 2;
                if (x < 8 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX;
                y = cellY;
                x -= 1;
                y -= 2;
                if (x >= 0 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX;
                y = cellY;
                x -= 2;
                y -= 1;
                if (x >= 0 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX;
                y = cellY;
                x -= 2;
                y += 1;
                if (x >= 0 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX;
                y = cellY;
                x -= 1;
                y += 2;
                if (x >= 0 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                    }
                }
            }
            case "blackQueen" -> {
                //for x:
                int x = cellX;
                x += 1;
                while (x < 8) {
                    if (Pieces.board[x][cellY] == null) {
                        positions.add(new Position(x, cellY));
                    } else if (Pieces.board[x][cellY].color.equals("white")) {
                        positions.add(new Position(x, cellY));
                        break;
                    } else {
                        break;
                    }
                    x++;
                }
                x = cellX;
                x -= 1;
                while (x >= 0) {
                    if (Pieces.board[x][cellY] == null) {
                        positions.add(new Position(x, cellY));
                    } else if (Pieces.board[x][cellY].color.equals("white")) {
                        positions.add(new Position(x, cellY));
                        break;
                    } else {
                        break;
                    }
                    x--;
                }
                //for y:
                int y = cellY;
                y += 1;
                while (y < 8) {
                    if (Pieces.board[cellX][y] == null) {
                        positions.add(new Position(cellX, y));
                    } else if (Pieces.board[cellX][y].color.equals("white")) {
                        positions.add(new Position(cellX, y));
                        break;
                    } else {
                        break;
                    }
                    y++;
                }
                y = cellY;
                y -= 1;
                while (y >= 0) {
                    if (Pieces.board[cellX][y] == null) {
                        positions.add(new Position(cellX, y));
                    } else if (Pieces.board[cellX][y].color.equals("white")) {
                        positions.add(new Position(cellX, y));
                        break;
                    } else {
                        break;
                    }
                    y--;
                }
                //for leading diagonal:
                x = cellX + 1;
                y = cellY + 1;
                while (x < 8 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                        break;
                    } else {
                        break;
                    }
                    x++;
                    y++;
                }
                x = cellX - 1;
                y = cellY - 1;
                while (x >= 0 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                        break;
                    } else {
                        break;
                    }
                    x--;
                    y--;
                }
                //for non-leading diagonal:
                x = cellX - 1;
                y = cellY + 1;
                while (x >= 0 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                        break;
                    } else {
                        break;
                    }
                    x--;
                    y++;
                }
                x = cellX + 1;
                y = cellY - 1;
                while (x < 8 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                        break;
                    } else {
                        break;
                    }
                    x++;
                    y--;
                }
            }
            case "blackKing" -> {
                int x = cellX, y = cellY;
                y += 1;
                if(y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX; y = cellY;
                x += 1; y += 1;
                if(x < 8 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX; y = cellY;
                x += 1;
                if(x < 8 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX; y = cellY;
                x -= 1; y += 1;
                if(x >= 0 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX; y = cellY;
                x -= 1;
                if(x < 8 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX; y = cellY;
                x -= 1; y -= 1;
                if(x >= 0 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX; y = cellY;
                x -= 1;
                if(x >= 0 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX; y = cellY;
                x -= 1; y += 1;
                if(x >= 0 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("white")) {
                        positions.add(new Position(x, y));
                    }
                }
            }
            case "whitePawn" -> {
                if (cellY - 1 >= 0 && Pieces.board[cellX][cellY - 1] == null) {
                    positions.add(new Position(cellX, cellY - 1));
                }
                if (cellX + 1 < 8 && cellY - 1 >= 0 && Pieces.board[cellX + 1][cellY - 1] != null
                        && Pieces.board[cellX + 1][cellY - 1].color.equals("black")) {
                    positions.add(new Position(cellX + 1, cellY - 1));
                }
                if (cellX - 1 >= 0 && cellY - 1 >= 0 && Pieces.board[cellX - 1][cellY - 1] != null
                        && Pieces.board[cellX - 1][cellY - 1].color.equals("black")) {
                    positions.add(new Position(cellX - 1, cellY - 1));
                }
                if (piece.pos.y == 6) {
                    if (Pieces.board[cellX][cellY - 1] == null && Pieces.board[cellX][cellY - 2] == null) {
                        positions.add(new Position(cellX, cellY - 2));
                    }
                }
            }
            case "whiteRook" -> {
                //for x:
                int x = cellX;
                x += 1;
                while (x < 8) {
                    if (Pieces.board[x][cellY] == null) {
                        positions.add(new Position(x, cellY));
                    } else if (Pieces.board[x][cellY].color.equals("black")) {
                        positions.add(new Position(x, cellY));
                        break;
                    } else {
                        break;
                    }
                    x++;
                }
                x = cellX;
                x -= 1;
                while (x >= 0) {
                    if (Pieces.board[x][cellY] == null) {
                        positions.add(new Position(x, cellY));
                    } else if (Pieces.board[x][cellY].color.equals("black")) {
                        positions.add(new Position(x, cellY));
                        break;
                    } else {
                        break;
                    }
                    x--;
                }
                //for y:
                int y = cellY;
                y += 1;
                while (y < 8) {
                    if (Pieces.board[cellX][y] == null) {
                        positions.add(new Position(cellX, y));
                    } else if (Pieces.board[cellX][y].color.equals("black")) {
                        positions.add(new Position(cellX, y));
                        break;
                    } else {
                        break;
                    }
                    y++;
                }
                y = cellY;
                y -= 1;
                while (y >= 0) {
                    if (Pieces.board[cellX][y] == null) {
                        positions.add(new Position(cellX, y));
                    } else if (Pieces.board[cellX][y].color.equals("black")) {
                        positions.add(new Position(cellX, y));
                        break;
                    } else {
                        break;
                    }
                    y--;
                }
            }
            case "whiteBishop" -> {
                //for leading diagonal:
                int x = cellX + 1, y = cellY + 1;
                while (x < 8 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                        break;
                    } else {
                        break;
                    }
                    x++;
                    y++;
                }
                x = cellX - 1;
                y = cellY - 1;
                while (x >= 0 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                        break;
                    } else {
                        break;
                    }
                    x--;
                    y--;
                }
                //for non-leading diagonal:
                x = cellX - 1;
                y = cellY + 1;
                while (x >= 0 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                        break;
                    } else {
                        break;
                    }
                    x--;
                    y++;
                }
                x = cellX + 1;
                y = cellY - 1;
                while (x < 8 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                        break;
                    } else {
                        break;
                    }
                    x++;
                    y--;
                }
            }
            case "whiteHorse" -> {
                int x = cellX, y = cellY;
                x += 1;
                y += 2;
                if (x < 8 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX;
                y = cellY;
                x += 2;
                y += 1;
                if (x < 8 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX;
                y = cellY;
                x += 2;
                y -= 1;
                if (x < 8 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX;
                y = cellY;
                x += 1;
                y -= 2;
                if (x < 8 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX;
                y = cellY;
                x -= 1;
                y -= 2;
                if (x >= 0 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX;
                y = cellY;
                x -= 2;
                y -= 1;
                if (x >= 0 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX;
                y = cellY;
                x -= 2;
                y += 1;
                if (x >= 0 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX;
                y = cellY;
                x -= 1;
                y += 2;
                if (x >= 0 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                    }
                }
            }
            case "whiteQueen" -> {
                //for x:
                int x = cellX;
                x += 1;
                while (x < 8) {
                    if (Pieces.board[x][cellY] == null) {
                        positions.add(new Position(x, cellY));
                    } else if (Pieces.board[x][cellY].color.equals("black")) {
                        positions.add(new Position(x, cellY));
                        break;
                    } else {
                        break;
                    }
                    x++;
                }
                x = cellX;
                x -= 1;
                while (x >= 0) {
                    if (Pieces.board[x][cellY] == null) {
                        positions.add(new Position(x, cellY));
                    } else if (Pieces.board[x][cellY].color.equals("black")) {
                        positions.add(new Position(x, cellY));
                        break;
                    } else {
                        break;
                    }
                    x--;
                }
                //for y:
                int y = cellY;
                y += 1;
                while (y < 8) {
                    if (Pieces.board[cellX][y] == null) {
                        positions.add(new Position(cellX, y));
                    } else if (Pieces.board[cellX][y].color.equals("black")) {
                        positions.add(new Position(cellX, y));
                        break;
                    } else {
                        break;
                    }
                    y++;
                }
                y = cellY;
                y -= 1;
                while (y >= 0) {
                    if (Pieces.board[cellX][y] == null) {
                        positions.add(new Position(cellX, y));
                    } else if (Pieces.board[cellX][y].color.equals("black")) {
                        positions.add(new Position(cellX, y));
                        break;
                    } else {
                        break;
                    }
                    y--;
                }
                //for leading diagonal:
                x = cellX + 1;
                y = cellY + 1;
                while (x < 8 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                        break;
                    } else {
                        break;
                    }
                    x++;
                    y++;
                }
                x = cellX - 1;
                y = cellY - 1;
                while (x >= 0 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                        break;
                    } else {
                        break;
                    }
                    x--;
                    y--;
                }
                //for non-leading diagonal:
                x = cellX - 1;
                y = cellY + 1;
                while (x >= 0 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                        break;
                    } else {
                        break;
                    }
                    x--;
                    y++;
                }
                x = cellX + 1;
                y = cellY - 1;
                while (x < 8 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                        break;
                    } else {
                        break;
                    }
                    x++;
                    y--;
                }
            }
            case "whiteKing" -> {
                int x = cellX, y = cellY;
                y += 1;
                if(y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX; y = cellY;
                x += 1; y += 1;
                if(x < 8 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX; y = cellY;
                x += 1;
                if(x < 8 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX; y = cellY;
                x += 1; y -= 1;
                if(x < 8 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX; y = cellY;
                y -= 1;
                if(x < 8 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX; y = cellY;
                x -= 1; y -= 1;
                if(x >= 0 && y >= 0) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX; y = cellY;
                x -= 1;
                if(x >= 0 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                    }
                }
                x = cellX; y = cellY;
                x -= 1; y += 1;
                if(x >= 0 && y < 8) {
                    if (Pieces.board[x][y] == null) {
                        positions.add(new Position(x, y));
                    } else if (Pieces.board[x][y].color.equals("black")) {
                        positions.add(new Position(x, y));
                    }
                }

                //implementing castling:
//                if() {
//
//                }
            }
        }
        return positions;

    }

    public static boolean contains(ArrayList<Position> movePositions, int cellX, int cellY) {

        for (Position positions:
                movePositions) {
            if(positions.x == cellX && positions.y == cellY) {
                return true;
            }
        }
        return false;

    }

}

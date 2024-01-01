import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    int cellX, cellY;
    @Override
    public void mouseClicked(MouseEvent e) {
        cellX = e.getX()/Panel.pixels;
        cellY = e.getY()/Panel.pixels;
        if (!Panel.pieceSelected) {
            if (Pieces.board[cellX][cellY] != null) {
                System.out.println(Panel.turn);
                if (Pieces.board[cellX][cellY].color.equals(Panel.turn)) {
                    Panel.pieceSelected = true;
                    Panel.selectedPiece = Pieces.board[cellX][cellY];
                }
            }
        } else {
            if (Logic.contains(Panel.movePositions, cellX, cellY)) {
                Panel.moveX = cellX;
                Panel.moveY = cellY;
                Panel.pieceSelected = false;
                Panel.pieceMoved = true;
            } else {
                if (Pieces.board[cellX][cellY] != null) {
                    System.out.println(Panel.turn);
                    if (Pieces.board[cellX][cellY].color.equals(Panel.turn)) {
                        System.out.println('h');
                        Panel.pieceSelected = true;
                        Panel.selectedPiece = Pieces.board[cellX][cellY];
                    } else {
                        Panel.pieceSelected = false;
                    }
                } else {
                    Panel.pieceSelected = false;
                }
            }
        }
        System.out.println(Panel.pieceSelected);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

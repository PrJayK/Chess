import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel extends JPanel implements Runnable {

    Thread gameThread;
    public static final int pixels = 60;
    Pieces pieces;
    Logic logic;
    static String turn = "white";
    static Pieces checkMateKing;
    static Pieces checkMatePiece;
    static boolean checkMate = false;
    static boolean check = false;
    MouseHandler mouseH = new MouseHandler();
    static boolean pieceSelected = false;
    static Pieces selectedPiece;
    static boolean pieceMoved = false;
    static int moveX, moveY;
    static ArrayList<Position> movePositions = new ArrayList<>();
    final int FPS = 60;
    Panel() {
        this.setPreferredSize(new Dimension(pixels*8,pixels*8));
        pieces = new Pieces();
        pieces.setDefaultValues();
        this.addMouseListener(mouseH);
    }

    public void update() {

        logic = new Logic();
        if(pieceSelected) {
            movePositions = logic.getMovingPositions(selectedPiece, selectedPiece.pos.x, selectedPiece.pos.y);
        }
        if(pieceMoved) {
            if(Pieces.board[moveX][moveY] != null) {
                Pieces.board[moveX][moveY].eliminated = true;
                Pieces.set.remove(Pieces.board[moveX][moveY].id);
                Pieces.board[moveX][moveY] = null;
            }
            Pieces.board[selectedPiece.pos.x][selectedPiece.pos.y] = null;
            selectedPiece.pos.x = moveX;
            selectedPiece.pos.y = moveY;
            Pieces.board[selectedPiece.pos.x][selectedPiece.pos.y] = selectedPiece;
            selectedPiece = null;
            pieceMoved = false;
            if(turn.equals("white")) {
                turn = "black";
            } else {
                turn = "white";
            }
            check = false;
            checkMateKing = null;
            checkMatePiece = null;
        }
        logic.checkMate();
        if(!Pieces.set.contains("whiteKing") || !Pieces.set.contains("blackKing")) {
            gameThread = null;
        }

    }

    public void paintComponent(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;
        for(int i = 1; i <= 8; i++) {
            for(int j = 1; j <= 8; j++) {
                if((i+j)%2 == 0) {
                    g2D.setColor(new Color(225, 205, 171));
                } else {
                    g2D.setColor(new Color(171, 128, 94));
                }
                g2D.fillRect((j-1)*pixels,(i-1)*pixels,pixels,pixels);
            }
        }
        if(pieceSelected) {
            g2D.setColor(new Color(86, 171, 194));
            g2D.fillRect(mouseH.cellX*pixels, mouseH.cellY*pixels, pixels, pixels);
            for (Position positions:
                 movePositions) {
                g2D.fillRect(positions.x*pixels, positions.y*pixels, pixels, pixels);
            }
        }
        if(check) {
            g2D.setColor(new Color(204, 95, 95));
            g2D.fillRect(checkMateKing.pos.x*pixels, checkMateKing.pos.y*pixels, pixels, pixels);
            g2D.fillRect(checkMatePiece.pos.x*pixels, checkMatePiece.pos.y*pixels, pixels, pixels);
        }
        pieces.draw(g2D);
        g2D.setColor(Color.black);
        for(int i = 0; i < 9; i++) {
            g2D.drawLine(i*pixels, 0, i*pixels, pixels*8);
            g2D.drawLine(0, i*pixels, pixels*8, i*pixels);
        }
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        long lastTime = System.nanoTime();
        double delta = 0;
        long currentTime;
        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime-lastTime)/drawInterval;
            lastTime = currentTime;
            if (delta > 1) {
                update();
                repaint();
                delta--;
            }
        }

    }
}

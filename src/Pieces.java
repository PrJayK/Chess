import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Pieces {

    static Pieces[][] board = new Pieces[8][8];
    Position pos;
    String id;
    boolean eliminated;
    String color;
    BufferedImage image;

    Pieces blackPawn1;
    Pieces blackPawn2;
    Pieces blackPawn3;
    Pieces blackPawn4;
    Pieces blackPawn5;
    Pieces blackPawn6;
    Pieces blackPawn7;
    Pieces blackPawn8;
    Pieces blackRook1;
    Pieces blackRook2;
    Pieces blackBishop1;
    Pieces blackBishop2;
    Pieces blackHorse1;
    Pieces blackHorse2;
    Pieces blackQueen;
    Pieces blackKing;
    Pieces whitePawn1;
    Pieces whitePawn2;
    Pieces whitePawn3;
    Pieces whitePawn4;
    Pieces whitePawn5;
    Pieces whitePawn6;
    Pieces whitePawn7;
    Pieces whitePawn8;
    Pieces whiteRook1;
    Pieces whiteRook2;
    Pieces whiteBishop1;
    Pieces whiteBishop2;
    Pieces whiteHorse1;
    Pieces whiteHorse2;
    Pieces whiteQueen;
    Pieces whiteKing;
    static ArrayList<Pieces> pieces = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();

    public Pieces(BufferedImage image, int x, int y, String id, String color) {
        this.image = image;
        this.pos = new Position();
        this.pos.x = x;
        this.pos.y = y;
        this.id = id;
        this.color = color;
        this.eliminated = false;
        pieces.add(this);
        set.add(id);
    }

    public Pieces() {

    }

    public void setDefaultValues() {

        try {
            blackPawn1 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/Black Pawn.png"))), 0, 1, "blackPawn", "black");

            blackPawn2 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/Black Pawn.png"))), 1, 1, "blackPawn", "black");

            blackPawn3 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/Black Pawn.png"))), 2, 1, "blackPawn", "black");

            blackPawn4 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/Black Pawn.png"))), 3, 1, "blackPawn", "black");

            blackPawn5 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/Black Pawn.png"))), 4, 1, "blackPawn", "black");

            blackPawn6 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/Black Pawn.png"))), 5, 1, "blackPawn", "black");

            blackPawn7 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/Black Pawn.png"))), 6, 1, "blackPawn", "black");

            blackPawn8 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/Black Pawn.png"))), 7, 1, "blackPawn", "black");

            blackRook1 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/Black Rook.png"))), 0, 0, "blackRook", "black");

            blackRook2 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/Black Rook.png"))), 7, 0, "blackRook", "black");

            blackBishop1 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/Black Bishop.png"))), 2, 0, "blackBishop", "black");

            blackBishop2 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/Black Bishop.png"))), 5, 0, "blackBishop", "black");

            blackHorse1 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/Black Horse.png"))), 1, 0, "blackHorse", "black");

            blackHorse2 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/Black Horse.png"))), 6, 0, "blackHorse", "black");

            blackQueen = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/Black Queen.png"))), 3, 0, "blackQueen", "black");

            blackKing = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/Black King.png"))), 4, 0, "blackKing", "black");

            whitePawn1 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/White Pawn.png"))), 0, 6, "whitePawn", "white");

            whitePawn2 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/White Pawn.png"))), 1, 6, "whitePawn", "white");

            whitePawn3 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/White Pawn.png"))), 2, 6, "whitePawn", "white");

            whitePawn4 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/White Pawn.png"))), 3, 6, "whitePawn", "white");

            whitePawn5 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/White Pawn.png"))), 4, 6, "whitePawn", "white");

            whitePawn6 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/White Pawn.png"))), 5, 6, "whitePawn", "white");

            whitePawn7 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/White Pawn.png"))), 6, 6, "whitePawn", "white");

            whitePawn8 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/White Pawn.png"))), 7, 6, "whitePawn", "white");

            whiteRook1 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/White Rook.png"))), 0, 7, "whiteRook", "white");

            whiteRook2 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/White Rook.png"))), 7, 7, "whiteRook", "white");

            whiteBishop1 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/White Bishop.png"))), 2, 7, "whiteBishop", "white");

            whiteBishop2 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/White Bishop.png"))), 5, 7, "whiteBishop", "white");

            whiteHorse1 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/White Horse.png"))), 1, 7, "whiteHorse", "white");

            whiteHorse2 = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/White Horse.png"))), 6, 7, "whiteHorse", "white");

            whiteQueen = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/White Queen.png"))), 3, 7, "whiteQueen", "white");

            whiteKing = new Pieces(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/White King.png"))), 4, 7, "whiteKing", "white");

            for (Pieces i:
                    pieces) {
                board[i.pos.x][i.pos.y] = i;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void draw(Graphics2D g2D) {

        for (Pieces i:
                pieces) {
            if(!i.eliminated) {
                g2D.drawImage(i.image, i.pos.x*60, i.pos.y*60, null);
            }
        }
    }

}

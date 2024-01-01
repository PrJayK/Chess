import javax.swing.*;
import java.util.Objects;

public class Chess{
    public static void main(String[] args) {

        JFrame gameFrame = new JFrame();
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(Chess.class.getResource("/res/logo.png")));
        gameFrame.setIconImage(icon.getImage());
        gameFrame.setVisible(true);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setResizable(false);
        gameFrame.setTitle("Chess");
        Panel gamePanel = new Panel();

        gameFrame.add(gamePanel);
        gameFrame.pack();
        gamePanel.startGameThread();

    }

}
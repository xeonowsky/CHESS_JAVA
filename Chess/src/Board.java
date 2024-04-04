import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    int rows=8;
    int columns=8;
    int tileSize=85;
public Board() {
    this.setPreferredSize(new Dimension(rows * tileSize, columns * tileSize));


}
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        Graphics2D gh2=(Graphics2D) g;
        for(int r=0;r<8;r++)
            for (int c=0;c<8;c++){
                gh2.setColor((c+r)%2==0?Color.white:Color.BLACK);
                gh2.fillRect(c*tileSize,r*tileSize,tileSize,tileSize);
            }
    }
}

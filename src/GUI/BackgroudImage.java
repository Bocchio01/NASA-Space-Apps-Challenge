package GUI;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.Constants;

public class BackgroudImage extends JPanel {

    public static void main(String[] args) {
        // TODO code application logic here
    }

    public BackgroudImage() {
        try {
            BufferedImage img = ImageIO.read(getClass().getResource(Constants.Path.Assets.BACKGROUND));
            ImageIcon icon = new ImageIcon(img);
            JLabel label = new JLabel(icon);
            add(label);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

package prototypes;

import java.awt.Color;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.Graphics2D;

class RendererPanel extends JPanel {
    // private Star[] stars;
    private BufferedImage backgroundImage;
    private double zoomFactor = 1.0;
    private Point zoomCenter = new Point(0, 0);

    public RendererPanel(String imagePath) {
        // this.stars = stars;
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBackground(Color.BLACK);  // Sfondo nero
    }

    // Imposta il livello di zoom e il punto centrale del zoom
    public void setZoom(double zoomFactor, Point zoomCenter) {
        this.zoomFactor = zoomFactor;
        this.zoomCenter = zoomCenter;
        repaint(); // Richiama il repaint per ridisegnare con il nuovo zoom
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(zoomFactor, zoomFactor);  // Applica lo zoom al rendering

        double translateX = (zoomCenter.x / zoomFactor) - zoomCenter.x;
        double translateY = (zoomCenter.y / zoomFactor) - zoomCenter.y;

        g2d.translate(translateX, translateY);

        // for (Star star : stars) {
        //     g2d.setColor(star.getColorByDistance());
        //     int size = (int) (star.getSizeByDistance() * zoomFactor);  // Dimensioni influenzate dallo zoom
        //     g2d.fillOval(star.x, star.y, size, size);
        // }
        g2d.drawImage(backgroundImage, 0, 0, this);
    }
}

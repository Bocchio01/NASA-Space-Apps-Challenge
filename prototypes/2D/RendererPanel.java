package prototypes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

class RendererPanel extends JPanel {
    private BufferedImage backgroundImage;
    private double zoomFactor = 1.0;
    private Point zoomCenter = new Point(0, 0);
    private static final double MAX_ZOOM = 10.0; // Valore massimo di zoom in
    private static final double MIN_ZOOM = 1.0; // Valore minimo di zoom out

    public RendererPanel(String imagePath) {
        try {
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setBackground(Color.BLACK); // Sfondo nero
    }

    public void updateZoomCenter(int deltaX, int deltaY) {
        zoomCenter.translate(deltaX, deltaY); // Commentato per non spostare
    }

    public void setZoom(double zoomFactor, Point mousePoint) {
        // Limita il massimo e minimo zoom
        double previousZoomFactor = this.zoomFactor;
        this.zoomFactor = Math.min(Math.max(zoomFactor, MIN_ZOOM), MAX_ZOOM);
        
        // Calcola la posizione del mouse in base alla posizione attuale dell'immagine scalata
        double scaledMouseX = (mousePoint.x - zoomCenter.x) / previousZoomFactor;
        double scaledMouseY = (mousePoint.y - zoomCenter.y) / previousZoomFactor;
    
        // Calcola la nuova posizione del centro di zoom
        int newCenterX = (int)(scaledMouseX * this.zoomFactor + zoomCenter.x);
        int newCenterY = (int)(scaledMouseY * this.zoomFactor + zoomCenter.y);
    
        // Aggiorna il centro di zoom
        zoomCenter.setLocation(newCenterX, newCenterY);
    
        // Ridisegna il pannello
        repaint();
    }
    
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Applica la traduzione prima di applicare il fattore di zoom
        g2d.translate(zoomCenter.x, zoomCenter.y);
        g2d.scale(zoomFactor, zoomFactor); // Applica lo zoom al rendering
        g2d.translate(-zoomCenter.x, -zoomCenter.y); // Riporta indietro la traduzione

        // Disegna l'immagine di sfondo ridimensionata per riempire il pannello
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        g2d.drawImage(backgroundImage, 0, 0, panelWidth, panelHeight, this);
    }

    public double getZoomFactor() {
        return zoomFactor;
    }

    public Point getZoomCenter() {
        return zoomCenter;
    }
}





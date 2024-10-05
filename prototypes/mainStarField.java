package prototypes;

import javax.swing.JFrame;

public class mainStarField {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Star Field with Zoom");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        

        // Star[] stars = StarGenerator.generateRandomStars(1000, 1000, 1000 );
        // RendererPanel panel = new RendererPanel(stars);
        RendererPanel panel = new RendererPanel(".resources\\team\\img\\MilkyWay.jpg");
        ZoomManager zoomManager = new ZoomManager(panel);

        // Aggiungi il listener per il mouse per gestire lo zoom
        panel.addMouseWheelListener(new MouseZoomListener(zoomManager));
        frame.add(panel);
        frame.setVisible(true);
    }
}
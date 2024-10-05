package prototypes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class RendererPanel extends JPanel {
    private Star[] stars;

    // Costruttore che riceve un array di stelle
    public RendererPanel(Star[] stars) {
        this.stars = stars;
        this.setBackground(Color.BLACK);  // Imposta lo sfondo nero
    }

    // Sovrascrivi il metodo paintComponent per disegnare le stelle
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Star star : stars) {
            // Imposta il colore modificato in base alla distanza
            g.setColor(star.getColorByDistance());

            // Dimensioni in base alla distanza
            int size = star.getSizeByDistance();

            g.fillOval(star.x, star.y, size, size);
        }
    }

    // Metodo per aggiornare le stelle e ridisegnare il pannello
    public void updateStars(Star[] newStars) {
        this.stars = newStars;
        repaint(); // Richiede a Swing di ridisegnare il pannello
    }

    // Metodo principale per testare il pannello
    public static void main(String[] args) {
        JFrame frame = new JFrame("Star Field");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Crea il pannello senza stelle inizialmente
        RendererPanel panel = new RendererPanel(new Star[0]);
        frame.add(panel);
        frame.setVisible(true);

        // Listener che reagisce quando il frame è stato ridimensionato o reso visibile
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int frameWidth = frame.getWidth();
                int frameHeight = frame.getHeight();

                // Crea un array iniziale di stelle con caratteristiche casuali
                Star[] stars = generateRandomStars(1000, frameWidth, frameHeight);
                panel.updateStars(stars); // Aggiorna il pannello con le nuove stelle

                // Aggiorna le stelle ogni 2 secondi con un nuovo set di dati
                new Timer(2000, ev -> {
                    Star[] newStars = generateRandomStars(1000, frameWidth, frameHeight);
                    panel.updateStars(newStars);
                }).start();
            }
        });
    }

    // Metodo per generare stelle casuali
    public static Star[] generateRandomStars(int count, int width, int height) {
        Star[] stars = new Star[count];
        Random random = new Random();

        for (int i = 0; i < stars.length; i++) {
            int x = random.nextInt(width); // Coordinate X casuali
            int y = random.nextInt(height); // Coordinate Y casuali
            double distance = random.nextDouble() * 100; // Distanza casuale tra 0 e 100
            Color color = Color.WHITE; // Colore fisso (bianco)
            stars[i] = new Star(x, y, color, distance);
        }

        return stars;
    }
}

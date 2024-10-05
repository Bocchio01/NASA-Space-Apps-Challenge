package prototypes;

import java.awt.*;

class Star {
    int x, y;
    Color baseColor;
    double distanceFromPlanet;  // Distanza dal pianeta (es. Terra)

    // Costruttore con la nuova logica di luminosità e distanza
    public Star(int x, int y, Color color, double distanceFromPlanet) {
        this.x = x;
        this.y = y;
        this.baseColor = color;
        this.distanceFromPlanet = distanceFromPlanet;
    }

     // Metodo per ottenere la dimensione in base alla distanza
     public int getSizeByDistance() {
        // Inversamente proporzionale alla distanza
        // return (int) Math.max(2, 10 - (distanceFromPlanet / 10));   Minimo di 2 pixel
        return 1;
    }

    // Metodo per ottenere la luminosità (opacità) in base alla distanza
    public Color getColorByDistance() {
        // Maggiore è la distanza, minore sarà la luminosità (trasparenza maggiore)
        int alpha = (int) Math.max(50, 255 - distanceFromPlanet * 2);  // Minimo 50 di alpha (molto trasparente)
        return new Color(baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue(), alpha);
    }
}
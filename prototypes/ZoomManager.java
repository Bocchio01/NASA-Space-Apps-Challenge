package prototypes;

import java.awt.Point;

class ZoomManager {
    private double zoomFactor = 1.0;
    private RendererPanel panel;

    public ZoomManager(RendererPanel panel) {
        this.panel = panel;
    }

    public void zoomIn(Point mousePoint) {
        zoomFactor *= 1.1;  // Aumenta il fattore di zoom
        panel.setZoom(zoomFactor, mousePoint);  // Aggiorna il pannello con il nuovo zoom
    }

    public void zoomOut(Point mousePoint) {
        zoomFactor /= 1.1;  // Diminuisce il fattore di zoom
        panel.setZoom(zoomFactor, mousePoint);  // Aggiorna il pannello con il nuovo zoom
    }
}

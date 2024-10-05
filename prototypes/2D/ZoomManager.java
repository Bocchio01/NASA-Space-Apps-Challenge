package prototypes;

import java.awt.Point;

class ZoomManager {
    private double zoomFactor = 1.0;
    private static final double MIN_ZOOM = 1.0;
    private static final double MAX_ZOOM = 10.0;
    private RendererPanel panel;

    public ZoomManager(RendererPanel panel) {
        this.panel = panel;
    }

    public void zoomIn(Point mousePoint) {
        zoomFactor *= 1.1;  // Aumenta il fattore di zoom
        if (zoomFactor > MAX_ZOOM) {
            zoomFactor = MAX_ZOOM;  // Limita il massimo zoom in
        }
        panel.setZoom(zoomFactor, mousePoint);  // Aggiorna il pannello con il nuovo zoom
    }

    public void zoomOut(Point mousePoint) {
        zoomFactor /= 1.1;  // Diminuisce il fattore di zoom
        if (zoomFactor < MIN_ZOOM) {
            zoomFactor = MIN_ZOOM;  // Limita il massimo zoom out
        }
        panel.setZoom(zoomFactor, mousePoint);  // Aggiorna il pannello con il nuovo zoom
    }

    public double getZoomFactor() {
        return zoomFactor;
    }
}
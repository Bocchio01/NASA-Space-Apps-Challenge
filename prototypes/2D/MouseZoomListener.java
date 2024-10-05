package prototypes;

import java.awt.Point;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

class MouseZoomListener implements MouseWheelListener {
    private ZoomManager zoomManager;

    public MouseZoomListener(ZoomManager zoomManager) {
        this.zoomManager = zoomManager;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        // Ottieni la posizione del mouse
        Point mousePosition = e.getPoint();

        // Gestisci lo zoom in e zoom out
        if (e.getWheelRotation() < 0) {
            zoomManager.zoomIn(mousePosition);  // Zoom in
        } else {
            zoomManager.zoomOut(mousePosition); // Zoom out
        }
    }
}

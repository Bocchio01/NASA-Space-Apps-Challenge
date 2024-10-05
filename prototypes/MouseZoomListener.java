package prototypes;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
class MouseZoomListener implements MouseWheelListener {
    private ZoomManager zoomManager;

    public MouseZoomListener(ZoomManager zoomManager) {
        this.zoomManager = zoomManager;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() < 0) {
            // Zoom in (scroll up)
            zoomManager.zoomIn(e.getPoint());
        } else {
            // Zoom out (scroll down)
            zoomManager.zoomOut(e.getPoint());
        }
    }
}

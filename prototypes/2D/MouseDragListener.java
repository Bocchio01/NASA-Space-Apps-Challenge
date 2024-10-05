// package prototypes;

// import java.awt.Point;
// import java.awt.event.MouseAdapter;
// import java.awt.event.MouseEvent;

// class MouseDragListener extends MouseAdapter {
//     private RendererPanel panel;
//     private Point previousMousePoint = null; // Per tenere traccia della posizione precedente del mouse
//     private boolean isDragging = false; // Per verificare se si sta trascinando

//     public MouseDragListener(RendererPanel panel) {
//         this.panel = panel;
//     }

//     @Override
//     public void mousePressed(MouseEvent e) {
//         // Inizia a trascinare
//         if (e.getButton() == MouseEvent.BUTTON1) { // Tasto sinistro del mouse
//             isDragging = true;
//             previousMousePoint = e.getPoint();
//         }
//     }

//     @Override
//     public void mouseReleased(MouseEvent e) {
//         // Termina il trascinamento
//         isDragging = false;
//         previousMousePoint = null;
//     }

//     @Override
//     public void mouseDragged(MouseEvent e) {
//         if (isDragging) {
//             // Calcola la distanza spostata
//             Point currentMousePoint = e.getPoint();
//             int deltaX = currentMousePoint.x - previousMousePoint.x;
//             int deltaY = currentMousePoint.y - previousMousePoint.y;

//             // Aggiorna il punto centrale di zoom in base al movimento
//             panel.updateZoomCenter(-deltaX, -deltaY);

//             // Aggiorna il punto precedente
//             previousMousePoint = currentMousePoint;

//             // Ridisegna il pannello
//             panel.repaint();
//         }
//     }
// }

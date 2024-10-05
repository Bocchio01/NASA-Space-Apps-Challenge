package GUI.layouts;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuLayout extends JPanel {

    public MenuLayout() {
        new BoxLayout(this, BoxLayout.Y_AXIS);
    }

    public void addComponent(JLabel component) {
        add(component);
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public void addComponent(JButton component) {
        add(component);
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}

package GUI.mainElements;

import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import GUI.GUI;
import GUI.panels.HomePanel;
import GUI.panels.Visual;

/**
 * The MenuBar class represents a custom menu bar for the graphical user
 * interface.
 * It includes menu items for navigating across the application.
 */
public class MenuBar extends JMenuBar {

    public MenuBar(GUI gui) {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JMenuItem itemHomePanel = new JMenuItem("Home");
        JMenuItem itemViualizerPanel = new JMenuItem("Visualizer");

        JMenuItem[] jMenuItems = new JMenuItem[] {
                itemHomePanel,
                itemViualizerPanel
        };

        itemHomePanel.addActionListener(e -> {
            gui.goToPanel(HomePanel.ID, null);
            gui.goToPanel(Visual.ID, null);
        });

        add(itemHomePanel);
        add(itemViualizerPanel);

        for (JMenuItem jMenuItem : jMenuItems) {
            jMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }
}
package GUI.mainElements;

import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import GUI.GUI;
import GUI.panels.ExamplePanel;

/**
 * The MenuBar class represents a custom menu bar for the graphical user interface.
 * It includes menu items for navigating across the application.
 */
public class MenuBar extends JMenuBar {

    public MenuBar(GUI gui) {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JMenuItem itemExamplePanel = new JMenuItem("ExamplePanel");
        JCheckBoxMenuItem itemToggleTheme = new JCheckBoxMenuItem("Tema scuro");
        itemToggleTheme.setSelected(gui.appTheme.isDarkTheme());

        JMenuItem[] jMenuItems = new JMenuItem[] {
                itemExamplePanel,
                itemToggleTheme };

        itemExamplePanel.addActionListener(e -> {
            gui.goToPanel(ExamplePanel.ID, null);
        });

        itemToggleTheme.addActionListener(e -> {
            gui.appTheme.toggleTheme();
        });

        add(itemExamplePanel);
        add(itemToggleTheme);

        for (JMenuItem jMenuItem : jMenuItems) {
            jMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }
}
package GUI.mainElements;

import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import GUI.GUI;
import GUI.menus.ExplorerMenu;
import GUI.menus.HomeMenu;

public class MenuBar extends JMenuBar {

    private GUI gui;

    public MenuBar(GUI gui) {
        this.gui = gui;

        setLayout(new FlowLayout(FlowLayout.LEFT));

        JMenuItem itemHomePanel = createMenuItem("Home", HomeMenu.ID);
        JMenuItem itemViualizerPanel = createMenuItem("Visualizer", ExplorerMenu.ID);

        add(itemHomePanel);
        add(itemViualizerPanel);
    }

    public JMenuItem createMenuItem(String text, String ID) {
        JMenuItem item = new JMenuItem(text);
        
        item.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        if (ID != null) {
            item.addActionListener(e -> {
                gui.goToPanel(ID, null);
            });
        }

        return item;
    }
}
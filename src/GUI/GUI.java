package GUI;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import GUI.explorer.ExplorerDisplay;
import GUI.mainElements.MainFrame;
import GUI.mainElements.MenuBar;
import GUI.menus.ExplorerMenu;
import GUI.menus.HomeMenu;
import models.MainModel;
import utils.Interfaces;

public class GUI {

    public Theme appTheme = new Theme();
    private MainFrame mainFrame = new MainFrame();
    private Map<String, Interfaces.UIPanel> menuPanels = new HashMap<>();

    private HomeMenu homeMenu;
    private ExplorerMenu explorerMenu;

    public GUI(MainModel mainModel) {

        mainFrame.setJMenuBar(new MenuBar(this));
        mainFrame.setExplorerDisplay(new ExplorerDisplay(mainModel).createPanel(this));

        homeMenu = new HomeMenu(mainModel);
        explorerMenu = new ExplorerMenu(mainModel);
    }

    public void addPanels() {
        addMenuPanel(homeMenu.createPanel(this));
        addMenuPanel(explorerMenu.createPanel(this));
    }

    public void addMenuPanel(Interfaces.UIPanel Panel) {
        menuPanels.put(Panel.getID(), Panel);
        mainFrame.getMenuPanel().add((Component) Panel, Panel.getID());

        appTheme.registerPanel((JPanel) Panel);
        appTheme.applyTheme();
    }

    public Interfaces.UIPanel getUIPanel(String ID) {
        return menuPanels.get(ID);
    }

    public void goToPanel(String ID, Object[] args) {
        try {
            mainFrame.getMenuCardLayout().show(mainFrame.getMenuPanel(), ID);
            getUIPanel(ID).onOpen(args);
            mainFrame.getMainFrame().revalidate();
            mainFrame.getMainFrame().repaint();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Errore: Panel " + ID + " non trovato.");
        }
    }

}

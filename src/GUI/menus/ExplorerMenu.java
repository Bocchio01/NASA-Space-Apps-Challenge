package GUI.menus;

import javax.swing.*;

import GUI.GUI;
import GUI.Widget;
import GUI.layouts.MenuLayout;
import models.MainModel;
import utils.Interfaces;

public class ExplorerMenu extends MenuLayout implements Interfaces.UIPanel {

    public static String ID = "Explorer";
    private GUI gui;
    private MainModel mainModel;

    public ExplorerMenu(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    private void addActionEvent() {
    }

    @Override
    public ExplorerMenu createPanel(GUI gui) {
        this.gui = gui;

        addComponent(new Widget.LogoLabel());

        addActionEvent();

        return this;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void onOpen(Object[] args) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainModel mainModel = new MainModel();
            GUI gui = new GUI(mainModel);
            ExplorerMenu home = new ExplorerMenu(mainModel);

            gui.addMenuPanel(home.createPanel(gui));
            home.onOpen(args);
        });
    }
}

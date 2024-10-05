package GUI.panels;

import javax.swing.*;

import GUI.GUI;
import GUI.Widget;
import GUI.layouts.TwoRows;
import models.MainModel;
import utils.Interfaces;

public class HomePanel extends TwoRows implements Interfaces.UIPanel {

    public static String ID = "Home";
    private GUI gui;
    private MainModel mainModel;

    private JLabel labelTitle = new JLabel("Exosky!");
    private JLabel labelCaption = new JLabel("Exosky!");

    public HomePanel(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    private void addActionEvent() {
    }

    @Override
    public HomePanel createPanel(GUI gui) {
        this.gui = gui;

        addTop(labelTitle);
        addTop(labelCaption);

        gui.appTheme.registerPanel(topPanel);
        gui.appTheme.registerPanel(bottomPanel);        

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
            HomePanel home = new HomePanel(mainModel);

            gui.addPanel(home.createPanel(gui));
            home.onOpen(args);
        });
    }
}

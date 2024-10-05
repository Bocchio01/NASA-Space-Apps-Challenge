package GUI.panels;

import javax.swing.*;

import GUI.GUI;
import GUI.Widget;
import GUI.Widget.Button;
import GUI.layouts.TwoRows;
import models.MainModel;
import utils.Interfaces;

public class VisualizerPanel extends TwoRows implements Interfaces.UIPanel {

    public static String ID = "Visualizer";
    private GUI gui;
    private MainModel mainModel;

    private JLabel labelWelcome = new JLabel("Benvenuto!");

    public VisualizerPanel(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    private void addActionEvent() {
    }

    @Override
    public VisualizerPanel createPanel(GUI gui) {
        this.gui = gui;

        addTop(new Widget.LogoLabel());
        addBottom(labelWelcome);

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
            VisualizerPanel home = new VisualizerPanel(mainModel);

            gui.addPanel(home.createPanel(gui));
            home.onOpen(args);
        });
    }
}

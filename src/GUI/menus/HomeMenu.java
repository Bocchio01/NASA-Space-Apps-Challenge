package GUI.menus;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import GUI.GUI;
import GUI.layouts.MenuLayout;
import models.MainModel;
import utils.Interfaces;

public class HomeMenu extends MenuLayout implements Interfaces.UIPanel {

    public static String ID = "Home";
    private GUI gui;
    private MainModel mainModel;

    private JLabel labelTitle = new JLabel("Exosky!");
    private JLabel labelCaption = new JLabel("Hunting new horizons");

    public HomeMenu(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    private void addActionEvent() {
    }

    @Override
    public HomeMenu createPanel(GUI gui) {
        this.gui = gui;

        this.setBackground(Color.BLACK);
        
        labelTitle.setForeground(Color.WHITE);
        labelTitle.setFont(new Font(Font.DIALOG, Font.BOLD,  50));
        labelCaption.setForeground(Color.WHITE);

        addComponent(labelTitle);
        addComponent(labelCaption);

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
            HomeMenu home = new HomeMenu(mainModel);

            gui.addMenuPanel(home.createPanel(gui));
            home.onOpen(args);
        });
    }
}

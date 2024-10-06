package GUI.menus;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import GUI.GUI;
import GUI.Widget;
import GUI.layouts.MenuLayout;
import models.MainModel;
import models.data.DataQuery.QueryCondition;
import utils.Interfaces;

public class ExplorerMenu extends MenuLayout implements Interfaces.UIPanel {

    public static String ID = "Explorer";

    @SuppressWarnings("unused")
    private GUI gui;

    private MainModel mainModel;

    private JTextField queryCelestialName = new JTextField();
    private JTextField queryCelestialValue = new JTextField();
    private JButton queryCelestialButton = new Widget.Button("Perform Query");

    public ExplorerMenu(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    private void addActionEvent() {
    
        queryCelestialButton.addActionListener(e -> {
            String name = queryCelestialName.getText();
            String value = queryCelestialValue.getText();
            
            List<QueryCondition> conditions = new ArrayList<>();
            conditions.add(new QueryCondition(name, value));
            mainModel.data.getExoplanetBy(conditions);
        });
    
    }

    @Override
    public ExplorerMenu createPanel(GUI gui) {
        this.gui = gui;

        addComponent(new Widget.FormPanel(gui.appTheme, "Query parameter name", queryCelestialName));
        addComponent(new Widget.FormPanel(gui.appTheme, "Query parameter value", queryCelestialValue));
        addComponent(queryCelestialButton);

        gui.appTheme.registerPanel(subPanel);

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

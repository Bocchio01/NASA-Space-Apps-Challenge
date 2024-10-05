package GUI.explorer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.*;

import GUI.GUI;
import GUI.Widget;
import models.MainModel;
import models.record.Star;
import utils.Interfaces;

public class ExplorerDisplay extends JPanel implements Interfaces.UIPanel {

    public static String ID = "VisualPanel";
    private GUI gui;
    private MainModel mainModel;

    private Widget.StarField starField;

    public ExplorerDisplay(MainModel mainModel) {
        this.mainModel = mainModel;

        this.setBackground(Color.BLACK);


        this.starField = new Widget.StarField(List.of(
                new Star(100, 150, 1, 3),
                new Star(200, 100, 5, 2),
                new Star(300, 200, 10, 5)));
    }

    private void addActionEvent() {
    }

    @Override
    public ExplorerDisplay createPanel(GUI gui) {
        this.gui = gui;

        this.setLayout(new BorderLayout());
        this.add(starField, BorderLayout.CENTER);
        gui.appTheme.registerPanel(this);

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
            ExplorerDisplay home = new ExplorerDisplay(mainModel);

            gui.addMenuPanel(home.createPanel(gui));
            home.onOpen(args);
        });
    }
}

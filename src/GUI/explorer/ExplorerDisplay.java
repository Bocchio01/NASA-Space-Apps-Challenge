package GUI.explorer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import GUI.GUI;
import GUI.Widget;
import models.MainModel;
import models.record.ExoplanetRecord;
import models.record.StarRecord;
import utils.Interfaces;

public class ExplorerDisplay extends JPanel implements Interfaces.UIPanel {

    public static String ID = "ExplorerDisplay";

    private GUI gui;
    private MainModel mainModel;

    private Widget.StarField starField;

    public ExplorerDisplay(MainModel mainModel) {
        this.mainModel = mainModel;

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(800, 600));

        List<ExoplanetRecord> exoplanets = new ArrayList<>();
        for (int i = 1; i < 500; i++) {
            exoplanets.add(mainModel.data.getExoplanetBy(i));
        }

        Dimension dim = getSize();

        List<StarRecord> stars = new ArrayList<>();
        for (ExoplanetRecord exoplanet : exoplanets) {
            stars.add(new StarRecord(
               (int) (exoplanet.ra() / 360 * 600),
               (int) (exoplanet.dec() / 90 * 500 / 2 + 500 / 2),
                10,
                5));
            
        }

        this.starField = new Widget.StarField(stars);
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

package GUI.explorer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import GUI.GUI;
import GUI.Widget;
import models.MainModel;
import models.record.ExoplanetRecord;
import models.record.StarRecord;
import models.record.CelestialObjectRecord;
import utils.Interfaces;

public class GraphicsExplorer extends JPanel implements Interfaces.UIPanel {

    public static String ID = "GraphicsExplorer";

    @SuppressWarnings("unused")
    private GUI gui;
    
    @SuppressWarnings("unused")
    private MainModel mainModel;

    private Widget.StarField starField;
    private Graphics graphics = new Graphics() {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    };

    public GraphicsExplorer(MainModel mainModel) {
        this.mainModel = mainModel;

        setBackground(Color.BLACK);

        List<ExoplanetRecord> exoplanets = new ArrayList<>();
        for (int i = 1; i < 500; i++) {
            exoplanets.add(mainModel.data.getExoplanetBy(i));
        }

        Dimension dim = getSize();

        List<CelestialObjectRecord> stars = new ArrayList<>();
        for (ExoplanetRecord exoplanet : exoplanets) {
            stars.add(new CelestialObjectRecord(
                    3,
                    exoplanet.ra(),
                    exoplanet.dec(),
                    exoplanet.mag_v(),
                    1.0));

        }

        this.starField = new Widget.StarField(stars);
    }

    private void addActionEvent() {
    }

    public void drawPoint(Graphics g, int x, int y, int size) {
        g.fillOval(x, y, size, size);
    }

    @Override
    public GraphicsExplorer createPanel(GUI gui) {
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
            GraphicsExplorer home = new GraphicsExplorer(mainModel);

            gui.addMenuPanel(home.createPanel(gui));
            home.onOpen(args);
        });
    }
}

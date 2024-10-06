package GUI.explorer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import GUI.GUI;
import GUI.Widget;
import models.CurrentCelestialObject;
import models.CurrentCelestialObject.CurrentCelestialObjectChangeListener;
import models.MainModel;
import models.record.ExoplanetRecord;
import models.record.StarRecord;
import utils.Interfaces;

public class GraphicsExplorer extends JPanel implements Interfaces.UIPanel, CurrentCelestialObjectChangeListener {

    public static String ID = "GraphicsExplorer";

    @SuppressWarnings("unused")
    private GUI gui;

    @SuppressWarnings("unused")
    private MainModel mainModel;

    private Widget.StarField starField = new Widget.StarField(new ArrayList<>());

    public GraphicsExplorer(MainModel mainModel) {
        this.mainModel = mainModel;

        CurrentCelestialObject celestialObject = CurrentCelestialObject.getInstance();
        celestialObject.addCurrentUserChangeListener(this);

        setBackground(Color.BLACK);
    }

    private void addActionEvent() {
    }

    private void paintNewCelestialObject() {
        List<ExoplanetRecord> exoplanets = mainModel.data.getDataStorage().getExoplanets();

        List<StarRecord> stars = new ArrayList<>();
        for (ExoplanetRecord exoplanet : exoplanets) {
            stars.add(new StarRecord(
                    (int) (exoplanet.ra() * 1200 / 360.0),
                    (int) (exoplanet.dec() * 500 / 90.0 + 500 / 2),
                    5.0,
                    1));

        }

        this.starField = new Widget.StarField(stars);
    }

    @Override
    public void onCelestialObjectChange()
    {
        paintNewCelestialObject();
        
        removeAll();
        add(starField, BorderLayout.CENTER);
        
        
        revalidate();
        repaint();


    }

    @Override
    public GraphicsExplorer createPanel(GUI gui) {
        this.gui = gui;

        setLayout(new BorderLayout());
        add(starField, BorderLayout.CENTER);

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

import GUI.GUI;
import GUI.panels.HomePanel;
import models.MainModel;

class Main {

    public GUI gui;
    public MainModel mainModel;

    public Main() {
        mainModel = new MainModel();
    }

    public void lauchGUI() {
        gui = new GUI(mainModel);
        gui.addPanels();
        gui.goToPanel(HomePanel.ID, null);
    }

    public static void main(String[] args) {
        Main mainIstance = new Main();
        mainIstance.lauchGUI();
    }

}

package GUI.explorer;

import models.MainModel;

public class ControllerExplorer {

    private MainModel mainModel;

    private GraphicsExplorer graphicsExplorer;
    private EventsExplorer eventsExplorer; 

    public ControllerExplorer(MainModel mainModel) {
        this.mainModel = mainModel;
        this.graphicsExplorer = new GraphicsExplorer(mainModel);
        this.eventsExplorer = new EventsExplorer();
    }


    public GraphicsExplorer getGraphicsExplorer() {
        return graphicsExplorer;
    }

    public static void main(String[] args) {
    }
}

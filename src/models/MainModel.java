package models;

import models.data.DataHandler;
import models.file.FileHandler;
import models.logic.LogicExoplanet;

public class MainModel {
    
    public FileHandler file;
    public DataHandler data;

    public LogicExoplanet logicExoplanet;


    public MainModel() {

        file = new FileHandler();

        data = new DataHandler();

        logicExoplanet = new LogicExoplanet(data);

    }
}

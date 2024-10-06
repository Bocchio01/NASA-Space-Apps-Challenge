package models.data;

import java.util.List;

import java.util.ArrayList;
import java.util.HashMap;

import models.CurrentCelestialObject;
import models.data.DataQuery.QueryCondition;
import models.file.TAPCaller;
import models.record.ExoplanetRecord;

public class DataHandler {

    private DataStorage dataStorage;

    public DataHandler() {

        this.dataStorage = new DataStorage();

    }

    public List<ExoplanetRecord> getExoplanetBy(List<QueryCondition> conditions) {
        String queryURL = DataQuery.queryExoplanet(conditions);
        List<String> bodyResponse = TAPCaller.fetchAPI(queryURL);

        HashMap<Integer, ExoplanetRecord> hashExoplanet = dataStorage.createExoplanetMap(bodyResponse);

        CurrentCelestialObject.getInstance().notifyCelestialObjectChange();

        return new ArrayList<ExoplanetRecord>(hashExoplanet.values());

    }

    public DataStorage getDataStorage() {
        return dataStorage;
    }

}

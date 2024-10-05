package models.data;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

import utils.Constants;
import models.database.TAPServices;
import models.record.PlanetRecord;

public class DataStorage {

    public HashMap<Integer, PlanetRecord> planetMap;

    public DataStorage() {

        // planetMap = createPlanetMap();

    }

    public PlanetRecord getCityByID(Integer planetID) {
        return planetMap.get(planetID);
    }

    private HashMap<Integer, PlanetRecord> createPlanetMap() {
        HashMap<Integer, PlanetRecord> map = new HashMap<>();

        try {

            List<String> lines = TAPServices.getPlanetData();

            PlanetRecord[] planetDatas = new PlanetRecord[lines.size() - 1];

            for (int i = 1; i < lines.size(); i++) {

                String[] line = lines.get(i).split(Constants.SEPARATOR);

                // planetDatas[i - 1] = new PlanetRecord(
                // Integer.parseInt(line[0]),
                // line[1],
                // line[2],
                // line[3],
                // line[4],
                // Double.parseDouble(line[5].replace(",", ".")),
                // Double.parseDouble(line[6].replace(",", ".")));

                for (PlanetRecord planetData : planetDatas) {
                    map.put(planetData.ID(), planetData);
                }

                return map;
            }

        } catch (IOException e) {
            // TODO: handle exception
            return null;
        }
    }

    public static void main(String[] args) {
        DataStorage appData = new DataStorage();

        // System.out.println(appData.getCityByID(3178229));
        // System.out.println(appData.getOperatorByID(1));
        // System.out.println(appData.getAreaByID(1));
        // System.out.println(appData.getWeatherByID(1));
    }
}

package models.data;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

import models.record.ConstellationRecord;
import models.record.ExoplanetRecord;

public class DataStorage {

    public HashMap<Integer, ExoplanetRecord> exoplanetMap;
    public HashMap<Integer, ConstellationRecord> constellationMap;

    public DataStorage() {
    }

    public HashMap<Integer, ExoplanetRecord> createExoplanetMap(List<String> lines) {
        HashMap<Integer, ExoplanetRecord> map = new HashMap<>();

        Pattern pattern = Pattern.compile(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

        for (int i = 1; i < lines.size(); i++) {
            String[] line = pattern.split(lines.get(i));

            ExoplanetRecord exoplanet = new ExoplanetRecord(
                line[0], // pl_name
                line[1], // hostname
                parseDoubleOrNull(line[2]), // ra
                parseDoubleOrNull(line[3]) // dec
            );

            map.put(i, exoplanet);
        }

        exoplanetMap = map;

        return map;
    }

    // private HashMap<Integer, ConstellationRecord> createConstellationMap() {
    // HashMap<Integer, ConstellationRecord> map = new HashMap<>();

    // try {
    // List<String> lines =
    // FileHandler.readFile(Constants.Path.Files.CONSTELLATIONS);

    // for (int i = 1; i < lines.size(); i++) {
    // String[] line = lines.get(i).split(Constants.SEPARATOR);

    // // ConstellationRecord constellation = new ConstellationRecord(
    // // i,
    // // Integer.parseInt(line[1]), // cityID
    // // Integer.parseInt(line[2]), // areaID
    // // line[3] // date
    // // );

    // // map.put(constellation.ID(), constellation);
    // }

    // return map;

    // } catch (IOException e) {
    // return null;
    // }
    // }

    // Utility methods for parsing
    private Double parseDoubleOrNull(String value) {
        try {
            return value != null && !value.trim().isEmpty() ? Double.parseDouble(value.replace(",", ".")) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Integer parseIntegerOrNull(String value) {
        try {
            return value != null && !value.trim().isEmpty() ? Integer.parseInt(value) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Boolean parseBooleanOrNull(String value) {
        return value != null && !value.trim().isEmpty() ? Boolean.parseBoolean(value) : null;
    }

    private List<String> parseStringList(String value) {
        return value != null && !value.trim().isEmpty() ? List.of(value.split(",")) : List.of();
    }

    // Getters
    public List<ExoplanetRecord> getExoplanets() {
        return new ArrayList<>(exoplanetMap.values());
    }

    public static void main(String[] args) {
        DataStorage appData = new DataStorage();

        // System.out.println(appData.getCityByID(3178229));
        // System.out.println(appData.getOperatorByID(1));
        // System.out.println(appData.getAreaByID(1));
        // System.out.println(appData.getWeatherByID(1));
    }
}

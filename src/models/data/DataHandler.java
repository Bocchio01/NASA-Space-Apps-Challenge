package models.data;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import models.file.FileHandler;
import models.record.ConstellationRecord;
import utils.Constants;

public class DataHandler extends DataQuery {

    private static DataStorage dataStorage = new DataStorage();

    public DataHandler() {
        super(dataStorage);
    }

    public Integer generatePrimaryKey(HashMap<Integer, ?> map) {
        int highestKey = 0;

        for (int key : map.keySet()) {
            if (key > highestKey) {
                highestKey = key;
            }
        }

        return highestKey + 1;
    }

    // public ConstellationRecord addNewRecord(
    //         Integer cityID,
    //         Integer areaID,
    //         String date) {

    //     ConstellationRecord newConstellation = new ConstellationRecord(
    //             generatePrimaryKey(dataStorage.constellationMap),
    //             cityID,
    //             areaID,
    //             date);

    //     try {
    //         FileHandler.appendToFile(Constants.Path.Files.CONSTELLATIONS, newConstellation.toString());
    //         dataStorage.constellationMap.put(newConstellation.ID(), newConstellation);
    //         return newConstellation;
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //     }
    //     return null;
    // }

    public void updateRecord(ConstellationRecord constellation) {
        updateRecord(Constants.Path.Files.CONSTELLATIONS, constellation.ID(), constellation);
        dataStorage.constellationMap.put(constellation.ID(), constellation);
    }

    private void updateRecord(String filePath, int ID, Object object) {
        try {
            List<String> lines = FileHandler.readFile(filePath);

            for (int i = 1; i < lines.size(); i++) {
                String[] line = lines.get(i).split(Constants.SEPARATOR);

                if (Integer.parseInt(line[0]) == ID) {
                    lines.set(i, object.toString());
                    break;
                }
            }

            FileHandler.writeFile(filePath, lines);

        } catch (IOException e) {
            // TODO: handle exeprion
        }
    }

}

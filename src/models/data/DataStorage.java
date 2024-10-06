package models.data;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

import utils.Constants;
import models.file.FileHandler;
import models.record.ConstellationRecord;
import models.record.ExoplanetRecord;

public class DataStorage {

    public HashMap<Integer, ExoplanetRecord> exoplanetMap;
    public HashMap<Integer, ConstellationRecord> constellationMap;

    public DataStorage() {

        exoplanetMap = createExoplanetMap();
        // constellationMap = createConstellationMap();

    }

    private HashMap<Integer, ExoplanetRecord> createExoplanetMap() {
        HashMap<Integer, ExoplanetRecord> map = new HashMap<>();

        try {
            Pattern pattern = Pattern.compile(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            List<String> lines = FileHandler.readFile(Constants.Path.Files.EXOPLANETS);

            Integer numberOfField = lines.get(0).split(",").length;

            for (int i = 1; i < lines.size(); i++) {

                String[] line = pattern.split(lines.get(i));
                String[] newLine = new String[numberOfField];
                System.arraycopy(line, 0, newLine, 0, line.length);
                line = newLine;

                ExoplanetRecord exoplanet = new ExoplanetRecord(
                        i,
                        line[0], // name
                        line[1], // planet_status
                        parseDoubleOrNull(line[2]), // mass
                        // parseDoubleOrNull(line[3]), // mass_error_min
                        // parseDoubleOrNull(line[4]), // mass_error_max
                        // parseDoubleOrNull(line[5]), // mass_sini
                        // parseDoubleOrNull(line[6]), // mass_sini_error_min
                        // parseDoubleOrNull(line[7]), // mass_sini_error_max
                        parseDoubleOrNull(line[8]), // radius
                        // parseDoubleOrNull(line[9]), // radius_error_min
                        // parseDoubleOrNull(line[10]), // radius_error_max
                        parseDoubleOrNull(line[11]), // orbital_period
                        // parseDoubleOrNull(line[12]), // orbital_period_error_min
                        // parseDoubleOrNull(line[13]), // orbital_period_error_max
                        parseDoubleOrNull(line[14]), // semi_major_axis
                        // parseDoubleOrNull(line[15]), // semi_major_axis_error_min
                        // parseDoubleOrNull(line[16]), // semi_major_axis_error_max
                        parseDoubleOrNull(line[17]), // eccentricity
                        // parseDoubleOrNull(line[18]), // eccentricity_error_min
                        // parseDoubleOrNull(line[19]), // eccentricity_error_max
                        parseDoubleOrNull(line[20]), // inclination
                        // parseDoubleOrNull(line[21]), // inclination_error_min
                        // parseDoubleOrNull(line[22]), // inclination_error_max
                        parseDoubleOrNull(line[23]), // angular_distance
                        parseIntegerOrNull(line[24]), // discovered
                        line[25], // updated
                        parseDoubleOrNull(line[26]), // omega
                        // parseDoubleOrNull(line[27]), // omega_error_min
                        // parseDoubleOrNull(line[28]), // omega_error_max
                        // parseDoubleOrNull(line[29]), // tperi
                        // parseDoubleOrNull(line[30]), // tperi_error_min
                        // parseDoubleOrNull(line[31]), // tperi_error_max
                        // parseDoubleOrNull(line[32]), // tconj
                        // parseDoubleOrNull(line[33]), // tconj_error_min
                        // parseDoubleOrNull(line[34]), // tconj_error_max
                        // parseDoubleOrNull(line[35]), // tzero_tr
                        // parseDoubleOrNull(line[36]), // tzero_tr_error_min
                        // parseDoubleOrNull(line[37]), // tzero_tr_error_max
                        // parseDoubleOrNull(line[38]), // tzero_tr_sec
                        // parseDoubleOrNull(line[39]), // tzero_tr_sec_error_min
                        // parseDoubleOrNull(line[40]), // tzero_tr_sec_error_max
                        // parseDoubleOrNull(line[41]), // lambda_angle
                        // parseDoubleOrNull(line[42]), // lambda_angle_error_min
                        // parseDoubleOrNull(line[43]), // lambda_angle_error_max
                        // parseDoubleOrNull(line[44]), // impact_parameter
                        // parseDoubleOrNull(line[45]), // impact_parameter_error_min
                        // parseDoubleOrNull(line[46]), // impact_parameter_error_max
                        // parseDoubleOrNull(line[47]), // tzero_vr
                        // parseDoubleOrNull(line[48]), // tzero_vr_error_min
                        // parseDoubleOrNull(line[49]), // tzero_vr_error_max
                        parseDoubleOrNull(line[50]), // k
                        // parseDoubleOrNull(line[51]), // k_error_min
                        // parseDoubleOrNull(line[52]), // k_error_max
                        parseDoubleOrNull(line[53]), // temp_calculated
                        // parseDoubleOrNull(line[54]), // temp_calculated_error_min
                        // parseDoubleOrNull(line[55]), // temp_calculated_error_max
                        parseDoubleOrNull(line[56]), // temp_measured
                        // parseDoubleOrNull(line[57]), // hot_point_lon
                        // parseDoubleOrNull(line[58]), // geometric_albedo
                        // parseDoubleOrNull(line[59]), // geometric_albedo_error_min
                        // parseDoubleOrNull(line[60]), // geometric_albedo_error_max
                        // parseDoubleOrNull(line[61]), // log_g
                        // line[62], // publication
                        // line[63], // detection_type
                        // line[64], // mass_measurement_type
                        // line[65], // radius_measurement_type
                        parseStringList(line[66]), // alternate_names
                        parseStringList(line[67]), // molecules
                        line[68], // star_name
                        parseDoubleOrNull(line[69]), // ra
                        parseDoubleOrNull(line[70]), // dec
                        parseDoubleOrNull(line[71]), // mag_v
                        // parseDoubleOrNull(line[72]), // mag_i
                        // parseDoubleOrNull(line[73]), // mag_j
                        // parseDoubleOrNull(line[74]), // mag_h
                        // parseDoubleOrNull(line[75]), // mag_k
                        parseDoubleOrNull(line[76]), // star_distance
                        // parseDoubleOrNull(line[77]), // star_distance_error_min
                        // parseDoubleOrNull(line[78]), // star_distance_error_max
                        parseDoubleOrNull(line[79]), // star_metallicity
                        // parseDoubleOrNull(line[80]), // star_metallicity_error_min
                        // parseDoubleOrNull(line[81]), // star_metallicity_error_max
                        parseDoubleOrNull(line[82]), // star_mass
                        // parseDoubleOrNull(line[83]), // star_mass_error_min
                        // parseDoubleOrNull(line[84]), // star_mass_error_max
                        parseDoubleOrNull(line[85]), // star_radius
                        // parseDoubleOrNull(line[86]), // star_radius_error_min
                        // parseDoubleOrNull(line[87]), // star_radius_error_max
                        // line[88], // star_sp_type
                        parseDoubleOrNull(line[89]), // star_age
                        // parseDoubleOrNull(line[90]), // star_age_error_min
                        // parseDoubleOrNull(line[91]), // star_age_error_max
                        // parseDoubleOrNull(line[92]), // star_teff
                        // parseDoubleOrNull(line[93]), // star_teff_error_min
                        // parseDoubleOrNull(line[94]), // star_teff_error_max
                        parseBooleanOrNull(line[95]), // star_detected_disc
                        parseBooleanOrNull(line[96]), // star_magnetic_field
                        parseStringList(line[97]) // star_alternate_names
                );

                map.put(exoplanet.ID(), exoplanet);
            }

        } catch (IOException e) {
            System.out.println(e);
            return null;
        }

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

    public static void main(String[] args) {
        DataStorage appData = new DataStorage();

        // System.out.println(appData.getCityByID(3178229));
        // System.out.println(appData.getOperatorByID(1));
        // System.out.println(appData.getAreaByID(1));
        // System.out.println(appData.getWeatherByID(1));
    }
}

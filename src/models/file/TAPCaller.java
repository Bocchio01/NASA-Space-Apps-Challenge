package models.file;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TAPCaller {

    public static List<String> fetchAPI(String queryURL) {

        List<String> responseLines = new ArrayList<>();

        try {
            URL obj = new URL(queryURL);

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    responseLines.add(inputLine);
                }

                in.close();

            } else {
                System.out.println("GET request did not work. Response Code: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseLines;
    }

    public static String composeURL(String DB_NAME, String[] requestedFields, List<String> whereConditions) {

        String select = String.join(",", requestedFields);
        String where = String.join("+", whereConditions);

        return "https://exoplanetarchive.ipac.caltech.edu/TAP/sync?query=" +
                "select+" + select + "+" +
                "from+" + DB_NAME + "+" +
                "where+" + where +
                "&format=CSV";
    }

}

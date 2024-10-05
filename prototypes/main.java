package prototypes;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
// import org.json.JSONArray;
// import org.json.JSONObject;

public class main {

    public static void main(String[] args) {
        try {
            // Create an HTTP client
            HttpClient client = HttpClient.newHttpClient();
            
            // Build the request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://exoplanetarchive.ipac.caltech.edu/cgi-bin/nstedAPI/nph-nstedAPI?table=cumulative"))
                    .GET() // GET method
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Check the status code
            if (response.statusCode() != 200) {
                throw new RuntimeException("HttpResponseCode: " + response.statusCode());
            } 
            
            String responseBody = response.body();

            // Print first 1000 characters of the response body
            System.out.println(responseBody.substring(0, 1000));


            // // Parse the response body into a JSON object
            // String responseBody = response.body();
            // JSONObject dataObj = new JSONObject(responseBody);

            // // Access the global object and get relevant data (update this based on actual API structure)
            // // Assuming the 'Global' key exists and contains some info, adjust according to the real API
            // JSONObject globalObj = dataObj.optJSONObject("Global");
            // if (globalObj != null) {
            //     System.out.println("Total Recovered (Global): " + globalObj.optInt("TotalRecovered"));
            // }

            // // Access array of countries if exists
            // JSONArray countriesArray = dataObj.optJSONArray("Countries");
            // if (countriesArray != null) {
            //     for (int i = 0; i < countriesArray.length(); i++) {
            //         JSONObject countryObj = countriesArray.getJSONObject(i);

            //         // Check for Albania
            //         if (countryObj.getString("Slug").equals("albania")) {
            //             System.out.println("Total Recovered (Albania): " + countryObj.getInt("TotalRecovered"));
            //             break;
            //         }
            //     }
            // }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

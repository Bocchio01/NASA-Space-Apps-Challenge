package models.database;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TAPServices {

    private TAPServices() {
        throw new IllegalStateException("Utility class");
    }

    public static String getPlanetData()
    {
        return fetchTAP("select+*+from+ps+where+default_flag=1");
    }

    private static String fetchTAP(String query)
    {
        try {
            HttpClient client = HttpClient.newHttpClient();
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://exoplanetarchive.ipac.caltech.edu/TAP/sync?query=" + query + "&format=csv"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("HttpResponseCode: " + response.statusCode());
            } 
            
            return response.body();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static void main(String[] args) {
        System.out.println(fetchTAP("select+count(pl_name)+from+ps+where+default_flag=1"));
    }
}

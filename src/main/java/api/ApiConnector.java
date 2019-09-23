package api;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

abstract class ApiConnector {
    private boolean isOld = true;

    String getBaseUrl() {
        return isOld ? "https://ckan.multimediagdansk.pl" : "https://ckan2.multimediagdansk.pl";
    }

    JSONObject get(String urlToGet) {
        try {
            URL url = new URL(getBaseUrl() + urlToGet);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                Scanner scanner = new Scanner(url.openStream());
                StringBuilder inlineResponse = new StringBuilder();
                while (scanner.hasNext()) {
                    inlineResponse.append(scanner.nextLine());
                }

                return new JSONObject(inlineResponse.toString());
            } else {
                throw new RuntimeException("HttpCode: " + responseCode);
            }
        } catch (IOException e) {
            return new JSONObject();
        }
    }
}

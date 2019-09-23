import api.LineApi;
import api.StopsApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import database.Stops;
import models.Stop;

public class StartJob {
    public static void main(String[] args) {
        loadZones();
    }

    public static void loadZones() {
        Stops stopsCollection = new Stops();
        stopsCollection.addZones();
    }

    public static void loadStops() {
        StopsApi stopsApi = new StopsApi();
        Stops stopsCollection = new Stops();
        try {
            Stop[] stops = stopsApi.getStops();
            stopsCollection.addStops(stops);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

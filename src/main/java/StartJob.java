import api.BusStopsApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import database.BusStops;
import models.BusStop;

public class StartJob {
    public static void main(String[] args) {
        loadZones();
    }

    public static void loadZones() {
        BusStops stopsCollection = new BusStops();
        stopsCollection.addZones();
    }

    public static void loadStops() {
        BusStopsApi stopsApi = new BusStopsApi();
        BusStops stopsCollection = new BusStops();
        try {
            BusStop[] stops = stopsApi.getStops();
            stopsCollection.addStops(stops);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

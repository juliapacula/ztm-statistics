package models;

import org.bson.Document;

public class Stop extends DatabaseModel {
    public int id;
    public String time;
    public int routeId;
    public int busStopId;

    @Override
    public Document writeToDatabase() {
        return new Document("_id", id)
                .append("time", time)
                .append("route_id", routeId)
                .append("bus_stop_id", busStopId);
    }
}

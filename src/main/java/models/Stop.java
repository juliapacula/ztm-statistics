package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.Document;
import utils.CommonDate;

import java.util.Date;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stop extends DatabaseModel {
    public int id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @JsonProperty("arrivalTime")
    public Date time;
    @JsonProperty("tripId")
    public int routeId;
    @JsonProperty("stopId")
    public int busStopId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date date;

    @Override
    public Document writeToDatabase() {
        return new Document("_id", UUID.randomUUID())
                .append("time", CommonDate.getTimeAsString(time))
                .append("date", date)
                .append("route_id", routeId)
                .append("bus_stop_id", busStopId);
    }
}

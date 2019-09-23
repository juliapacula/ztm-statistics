package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.Document;

import java.rmi.server.UID;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActualStop extends DatabaseModel {
    @JsonProperty("routeId")
    public int routeId;
    @JsonProperty("tripId")
    public int busLine;
    @JsonProperty("delayInSeconds")
    public int delay;
    @JsonProperty("estimatedTime")
    public String time;
    @JsonProperty("scheduledTime")
    public String scheduledTime;
    public int stopId;

    @Override
    public Document writeToDatabase() {
        return new Document("_id", new UID())
                .append("time", time)
                .append("stop_id", stopId)
                .append("delay", delay)
                .append("created_at", new Date());
    }
}

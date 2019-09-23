package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.Document;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Route extends DatabaseModel {
    public String id;
    public int tripId;
    @JsonProperty("routeId")
    public int busLine;
    @JsonProperty("tripHeadsign")
    public String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("activationDate")
    public Date createdAt;

    @Override
    public Document writeToDatabase() {
        return new Document("_id", id)
                .append("trip_id", tripId)
                .append("bus_line", busLine)
                .append("name", name)
                .append("created_at", createdAt);
    }
}

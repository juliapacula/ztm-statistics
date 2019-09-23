package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.Document;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Route extends DatabaseModel {
    @JsonProperty("tripId")
    public int id;
    @JsonProperty("routeId")
    public int busLine;
    @JsonProperty("tripHeadSign")
    public String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public String createdAt;

    @Override
    public Document writeToDatabase() {
        return new Document("_id", id)
                .append("bus_line", busLine)
                .append("name", name)
                .append("created_at", createdAt);
    }
}

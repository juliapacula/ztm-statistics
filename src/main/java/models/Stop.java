package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.BasicDBObject;
import org.bson.Document;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stop extends DatabaseModel {
    @JsonProperty("stopId")
    public int id;
    @JsonProperty("stopName")
    public String name;
    @JsonProperty("stopDesc")
    public String description;
    public int zoneId;
    public String zoneName;

    @Override
    public Document writeToDatabase() {
        return new Document("_id", id)
                .append("name", name)
                .append("description", description)
                .append("zone",
                        new BasicDBObject("_id", zoneId)
                                .append("name", zoneName));
    }
}

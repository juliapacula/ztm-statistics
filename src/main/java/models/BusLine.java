package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.Document;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusLine extends DatabaseModel {
    @JsonProperty("routeId")
    public int id;
    @JsonProperty("routeShortName")
    public String number;
    @JsonProperty("routeLongName")
    public String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("activationDate")
    public Date createdAt;

    @Override
    public Document writeToDatabase() {
        return new Document("_id", id)
                .append("number", number)
                .append("name", name)
                .append("created_at", createdAt);
    }
}

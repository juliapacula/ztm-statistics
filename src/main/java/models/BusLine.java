package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.Document;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusLine extends DatabaseModel {
    //  line identificator
    @JsonProperty("routeId")
    public int number;
    //  opis linii najczęściej składający się z nazw przystanków krańcowych
    @JsonProperty("routeLongName")
    public String name;
    //  data aktywacji wersji topologii dot. linii
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("activationDate")
    public String createdAt;

    @Override
    public Document writeToDatabase() {
        return new Document("_id", number)
                .append("number", number)
                .append("name", name)
                .append("created_at", createdAt);
    }
}

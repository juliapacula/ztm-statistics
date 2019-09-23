package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Route {
    @JsonProperty("tripId")
    public int busId;
    @JsonProperty("routeId")
    public int lineId;
    @JsonProperty("tripHeadSign")
    public String headsign;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public String activationDate;
}

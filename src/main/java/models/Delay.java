package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Delay {
    public int routeId;
    public int tripId;
    public int delayInSeconds;
    public String estimatedTime;
    public String scheduledTime;
    public String status;
}

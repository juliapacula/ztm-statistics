package models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Line {
    //  wewnętrzny identyfikator linii unikalny w skali Trójmiasta
    @JsonProperty("routeId")
    public int id;
    //  opis linii najczęściej składający się z nazw przystanków krańcowych
    @JsonProperty("routeLongName")
    public String name;
    //  data aktywacji wersji topologii dot. linii
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public String activationDate;
}

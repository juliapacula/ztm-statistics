package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.BusLine;
import org.json.JSONObject;
import utils.CommonDate;

public class BusLineApi extends ApiConnector {
    private String dataUrl = "/dataset/c24aa637-3619-4dc2-a171-a23eec8f2172/resource/22313c56-5acf-41c7-a5fd-dc5dc72b3851/download/routes.json";

    public BusLine[] getLines() throws JsonProcessingException {
        JSONObject jsonLines = this.get(dataUrl).getJSONObject(CommonDate.getToday());
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(jsonLines.getJSONArray("routes").toString(), BusLine[].class);
    }
}

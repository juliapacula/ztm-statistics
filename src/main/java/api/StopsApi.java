package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Stop;
import org.json.JSONArray;
import utils.CommonDate;

public class StopsApi extends ApiConnector {
    private String dataUrl = "/dataset/c24aa637-3619-4dc2-a171-a23eec8f2172/resource/4c4025f0-01bf-41f7-a39f-d156d201b82b/download/stops.json";

    public Stop[] getStops() throws JsonProcessingException {
        JSONArray jsonLines = this.get(dataUrl).getJSONObject(CommonDate.getToday()).getJSONArray("stops");
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(jsonLines.toString(), Stop[].class);
    }
}

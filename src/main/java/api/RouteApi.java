package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Route;
import org.json.JSONObject;
import utils.CommonDate;

public class RouteApi extends ApiConnector {
    private String dataUrl = "/dataset/c24aa637-3619-4dc2-a171-a23eec8f2172/resource/b15bb11c-7e06-4685-964e-3db7775f912f/download/trips.json";

    public Route[] getRoutes() throws JsonProcessingException {
        JSONObject jsonLines = this.get(dataUrl).getJSONObject(CommonDate.getToday());
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(jsonLines.getJSONArray("trips").toString(), Route[].class);
    }
}

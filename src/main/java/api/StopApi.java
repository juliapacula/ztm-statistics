package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Stop;
import org.json.JSONArray;
import utils.CommonDate;

import java.util.Date;

public class StopApi extends ApiConnector {
    private String dataUrl = "/stopTimes?";

    @Override
    public boolean isOld() {
        return false;
    }

    public Stop[] getStops(Date date, int busLine) throws JsonProcessingException {
        String url = dataUrl + "date=" + CommonDate.getDate(date) + "&routeId=" + busLine;
        JSONArray jsonStops = this.get(url).getJSONArray("stopTimes");
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(jsonStops.toString(), Stop[].class);
    }
}

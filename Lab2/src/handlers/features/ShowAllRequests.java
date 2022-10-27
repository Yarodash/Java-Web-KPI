package handlers.features;

import dao.DAO;
import daos.Request;
import json.JsonArray;
import json.JsonDict;

public class ShowAllRequests implements Feature {

    @Override
    public JsonDict answer(JsonDict request) throws Exception {

        JsonArray answer = new JsonArray();
        for (DAO dao: Request.table.getAll().convert())
            answer.push(dao.toString() + ": id=" + dao.id);

        return new JsonDict().put("Status", "OK").put("requests", answer);
    }
}

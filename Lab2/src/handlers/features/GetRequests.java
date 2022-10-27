package handlers.features;

import dao.DAO;
import dao.FirstEmptyException;
import dao.filters.F;
import daos.Request;
import daos.Route;
import daos.Session;
import json.JsonArray;
import json.JsonDict;

public class GetRequests implements Feature {

    @Override
    public JsonDict answer(JsonDict request) throws Exception {

        String token = (String) request.get("token");

        try {
            Session session = (Session) Session.table.getAll().filter(F.E("token", token)).first().convert();

            JsonArray answer = new JsonArray();
            for (DAO dao : Request.table.getAll().filter(F.E("account_id", session.account_id)).convert()) {

                Route route = (Route) Route.table.getById(((Request) dao).route_id).convert();

                answer.push("{" + route + ", weight=" + ((Request)dao).weight + "}");
            }

            return new JsonDict().put("Status", "OK").put("requests", answer);

        } catch (FirstEmptyException ignored) {}

        return new JsonDict().put("Status", "Error");
    }
}

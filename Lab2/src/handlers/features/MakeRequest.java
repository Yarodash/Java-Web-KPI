package handlers.features;

import dao.FirstEmptyException;
import dao.filters.F;
import daos.Request;
import daos.Route;
import daos.Session;
import json.JsonDict;

public class MakeRequest implements Feature {

    @Override
    public JsonDict answer(JsonDict request) throws Exception {

        String token = (String) request.get("token");
        String code = (String) request.get("code");
        int weight = (Integer) request.get("weight");

        try {

            Session session = (Session) Session.table.getAll().filter(F.E("token", token)).first().convert();

            Route route = (Route) Route.table.getAll().filter(F.E("code", code)).first().convert();

            new Request(route.id, session.account_id, weight).save();

            return new JsonDict().put("Status", "OK");

        } catch (FirstEmptyException ignored) {}

        return new JsonDict().put("Status", "Error");
    }
}

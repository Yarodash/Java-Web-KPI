package handlers.features;

import json.JsonDict;

public class AccessDenied implements Feature {

    public JsonDict answer(JsonDict request) throws Exception {

        return new JsonDict().put("Status", "Access denied");
    }

}

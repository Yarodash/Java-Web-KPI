package handlers.features;

import json.JsonDict;

public interface Feature {

    public JsonDict answer(JsonDict request) throws Exception;

}

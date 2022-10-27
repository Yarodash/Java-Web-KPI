package handlers;

import json.JsonDict;

public interface Handler {

    public JsonDict answer(JsonDict request) throws Exception;

}

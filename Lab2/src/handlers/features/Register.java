package handlers.features;

import daos.Account;
import json.JsonDict;

public class Register implements Feature {

    public JsonDict answer(JsonDict request) throws Exception {

        String login = (String)request.get("login");
        String password = (String)request.get("password");

        Account account = new Account(login, password, "base");
        if (account.register())
            return new JsonDict().put("Status", "Register successful");

        return new JsonDict().put("Status", "Register error");
    }

}

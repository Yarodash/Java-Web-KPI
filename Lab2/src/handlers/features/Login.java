package handlers.features;

import dao.FirstEmptyException;
import dao.filters.F;
import daos.Account;
import daos.Session;
import json.JsonDict;

public class Login implements Feature {

    public JsonDict answer(JsonDict request) throws Exception {

        String login = (String)request.get("login");
        String password = (String)request.get("password");

        try {
            Account account = (Account) Account.table.getAll()
                    .filter(
                            F.And(
                                    F.E("login", login),
                                    F.E("password", password)
                            )
                    ).first().convert();

            Session session = new Session(account.id, Session.generateUniqueToken());
            session.save();
            return new JsonDict().put("Status", "Login successful").put("token", session.token);

        } catch (FirstEmptyException e) {
            return new JsonDict().put("Status", "Login error");
        }
    }

}

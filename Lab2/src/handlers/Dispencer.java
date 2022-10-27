package handlers;

import dao.FirstEmptyException;
import dao.filters.F;
import daos.Account;
import daos.Session;
import handlers.usertypes.AuthorizedUserHandler;
import handlers.usertypes.BaseUserHandler;
import handlers.usertypes.ManagerUserHandler;
import handlers.usertypes.UserHandler;
import json.JsonDict;

import java.util.Objects;

public class Dispencer {

    public static UserHandler getUserHandler(JsonDict request) throws Exception {

        String token = (String) request.get("token");

        if (token == null)
            return new BaseUserHandler();

        try {
            Session session = (Session) Session.table.getAll().filter(F.E("token", token)).first().convert();

            Account account = (Account) Account.table.getById(session.account_id).convert();

            if (Objects.equals(account.user_type, "base"))
                return new AuthorizedUserHandler();

            if (Objects.equals(account.user_type, "admin"))
                return new ManagerUserHandler();

        } catch (FirstEmptyException ignored) {}

        return new BaseUserHandler();
    }

}

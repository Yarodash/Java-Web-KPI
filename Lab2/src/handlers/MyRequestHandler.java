package handlers;

import handlers.usertypes.UserHandler;
import json.JsonDict;

import java.util.Objects;

public class MyRequestHandler implements Handler {

    @Override
    public JsonDict answer(JsonDict request) throws Exception {

        UserHandler userHandler = Dispencer.getUserHandler(request);
        System.out.println(userHandler);

        if (Objects.equals(request.get("request_type"), "register"))
            return userHandler.register_handler.answer(request);

        if (Objects.equals(request.get("request_type"), "login"))
            return userHandler.login_handler.answer(request);

        if (Objects.equals(request.get("request_type"), "getData"))
            return userHandler.getData_handler.answer(request);

        if (Objects.equals(request.get("request_type"), "calculatePrice"))
            return userHandler.calculatePrice_handler.answer(request);

        if (Objects.equals(request.get("request_type"), "makeRequest"))
            return userHandler.makeRequest_handler.answer(request);

        if (Objects.equals(request.get("request_type"), "getRequests"))
            return userHandler.getRequests_handler.answer(request);

        if (Objects.equals(request.get("request_type"), "showAllRequests"))
            return userHandler.showAllRequests_handler.answer(request);

        if (Objects.equals(request.get("request_type"), "formRecipe"))
            return userHandler.formRecipe_handler.answer(request);

        if (Objects.equals(request.get("request_type"), "getReceipts"))
            return userHandler.getReceipts_handler.answer(request);

        return request;
    }
}

package handlers.features;

import dao.FirstEmptyException;
import daos.Receipt;
import daos.Request;
import daos.Route;
import handlers.PriceCalculator;
import json.JsonDict;

public class FormRecipe implements Feature {

    @Override
    public JsonDict answer(JsonDict user_request) throws Exception {

        int request_id = (Integer) user_request.get("request_id");
        String bank_url = (String) user_request.get("bank_url");

        try {

            Request request = (Request) Request.table.getById(request_id).convert();

            Route route = (Route) Route.table.getById(request.route_id).convert();

            int price = PriceCalculator.calculate_price(route.distance, request.weight);

            new Receipt(request.route_id, request.account_id, request.weight, price, bank_url).save();
            request.delete();

            return new JsonDict().put("Status", "OK");

        } catch (FirstEmptyException ignored) {}

        return new JsonDict().put("Status", "Error");
    }
}

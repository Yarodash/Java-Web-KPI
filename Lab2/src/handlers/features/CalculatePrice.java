package handlers.features;

import dao.FirstEmptyException;
import dao.filters.F;
import daos.Route;
import handlers.PriceCalculator;
import json.JsonDict;

public class CalculatePrice implements Feature {

    public JsonDict answer(JsonDict request) throws Exception {

        String code = (String) request.get("code");
        int weight = (int) request.get("weight");

        try {

            Route route = (Route) Route.table.getAll().filter(F.E("code", code)).first().convert();

            int price = PriceCalculator.calculate_price(route.distance, weight);

            return new JsonDict().put("Status", "OK").put("Price", price);

        } catch (FirstEmptyException ignored) {}

        return new JsonDict().put("Status", "Error");
    }

}

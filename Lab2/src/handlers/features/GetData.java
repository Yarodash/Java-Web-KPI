package handlers.features;

import dao.DAO;
import dao.Selection;
import dao.filters.F;
import daos.Route;
import json.JsonArray;
import json.JsonDict;

import java.util.Objects;

public class GetData implements Feature {

    public Selection applyFilter(Selection selection, JsonArray filter_info) {
        String field = (String) filter_info.get(0);
        String filter_type = (String) filter_info.get(1);

        if (Objects.equals(filter_type, "StringEqual"))
            return selection.filter(F.E(field, (String) filter_info.get(2)));

        if (Objects.equals(filter_type, "IntegerLess"))
            return selection.filter(F.L(field, (Integer) filter_info.get(2)));

        if (Objects.equals(filter_type, "IntegerEqual"))
            return selection.filter(F.E(field, (Integer) filter_info.get(2)));

        if (Objects.equals(filter_type, "IntegerGreater"))
            return selection.filter(F.G(field, (Integer) filter_info.get(2)));

        return selection;
    }

    public JsonDict answer(JsonDict request) throws Exception {

        Selection selection = Route.table.getAll();

        JsonArray filters = (JsonArray) request.get("filters");
        for (int i = 0; i < filters.size(); i++)
            selection = applyFilter(selection, (JsonArray) filters.get(i));

        JsonArray dataTable = new JsonArray();

        for (DAO dao: selection.convert()) {
            dataTable.push( dao.toString() );
        }

        return new JsonDict().put("Status", "OK").put("routes", dataTable);
    }

}

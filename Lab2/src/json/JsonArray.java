package json;

import java.util.ArrayList;

public class JsonArray {

    public ArrayList<Object> content = new ArrayList<>();

    public JsonArray push(Object value) {
        content.add(value);
        return this;
    }

    public Object get(int index) {
        return content.get(index);
    }

    public int size() {
        return content.size();
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder("[\n");

        JsonPrintTabCounter.increase();
        for (Object value: content)
            result.append(JsonPrintTabCounter.tab()).append(value).append(",\n");
        JsonPrintTabCounter.decrease();

        return result.append("]").toString();
    }
}

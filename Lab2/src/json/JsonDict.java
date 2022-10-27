package json;

import java.util.HashMap;
import java.util.Map;

public class JsonDict {

    public Map<String, Object> content = new HashMap<>();

    public JsonDict put(String key, Object value) {
        content.put(key, value);
        return this;
    }

    public Object get(String key) {
        return content.get(key);
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder("{\n");

        JsonPrintTabCounter.increase();
        for (String key: content.keySet())
            result.append(JsonPrintTabCounter.tab()).append(key).append(": ").append(content.get(key)).append(",\n");
        JsonPrintTabCounter.decrease();

        return result.append("}").toString();
    }
}

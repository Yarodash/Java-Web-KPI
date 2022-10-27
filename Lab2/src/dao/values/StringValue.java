package dao.values;

import java.lang.reflect.Field;

public class StringValue implements Value {

    public String value;

    public StringValue(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setDeclaredField(Field f, Object obj) throws IllegalAccessException {
        f.set(obj, value);
    }

    @Override
    public String toSQLData() {
        return "'" + value + "'";
    }
}

package dao.values;

import java.lang.reflect.Field;

public class IntegerValue implements Value {

    public Integer value;

    public IntegerValue(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void setDeclaredField(Field f, Object obj) throws IllegalAccessException {
        f.set(obj, value);
    }

    @Override
    public String toSQLData() {
        return "" + value;
    }
}

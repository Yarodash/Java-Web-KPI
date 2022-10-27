package dao;

import dao.fields.Field;
import dao.values.Value;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class Row {

    public final Value[] values;
    public final Table table;

    public Row(Value[] values, Table table) {
        this.values = values;
        this.table = table;
    }

    public Value get(String field_name) {
        for (int i = 0; i < table.fields.length; i++)
            if (Objects.equals(table.fields[i].name, field_name))
                return values[i];

        return null;
    }

    public DAO convert()
            throws NoSuchFieldException, IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {

        DAO converted = table.template.createEmpty();
        converted.generateModel(this);
        return converted;
    }

}

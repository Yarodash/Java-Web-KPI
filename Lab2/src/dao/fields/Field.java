package dao.fields;

import dao.values.Value;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Field
{
    public String name;

    public Field(String name) {
        this.name = name;
    }

    public abstract Value consumeData(ResultSet resultSet) throws SQLException;

    public abstract Value fromValue(Object value);

}

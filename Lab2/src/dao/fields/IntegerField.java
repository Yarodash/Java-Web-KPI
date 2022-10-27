package dao.fields;

import dao.values.IntegerValue;
import dao.values.Value;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IntegerField extends Field {

    public IntegerField(String name) {
        super(name);
    }

    @Override
    public IntegerValue consumeData(ResultSet resultSet) throws SQLException {
        return new IntegerValue(resultSet.getInt(name));
    }

    @Override
    public Value fromValue(Object value) {
        return new IntegerValue((Integer) value);
    }

}

package dao.fields;

import dao.values.StringValue;
import dao.values.Value;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StringField extends Field {

    public StringField(String name) {
        super(name);
    }

    @Override
    public StringValue consumeData(ResultSet resultSet) throws SQLException {
        return new StringValue(resultSet.getString(name));
    }

    @Override
    public Value fromValue(Object value) {
        return new StringValue((String) value);
    }
}

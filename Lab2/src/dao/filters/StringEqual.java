package dao.filters;

import dao.Row;
import dao.values.StringValue;

import java.util.Objects;

public class StringEqual implements Filter {

    public String field_name;
    public String right;

    public StringEqual(String field_name, String right) {
        this.field_name = field_name;
        this.right = right;
    }

    @Override
    public boolean fits(Row row) {
        String left = ((StringValue)row.get(field_name)).getValue();

        return Objects.equals(left, right);
    }
}

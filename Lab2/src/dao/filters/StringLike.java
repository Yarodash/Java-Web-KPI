package dao.filters;

import dao.Row;
import dao.values.StringValue;

public class StringLike implements Filter {

    public String field_name;
    public String right;

    public StringLike(String field_name, String right) {
        this.field_name = field_name;
        this.right = right;
    }

    @Override
    public boolean fits(Row row) {
        String left = ((StringValue)row.get(field_name)).getValue();

        return left.contains(right);
    }
}

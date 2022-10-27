package dao.filters;

import dao.Row;
import dao.values.IntegerValue;

public class IntGreater implements Filter {

    public String field_name;
    public int right;

    public IntGreater(String field_name, int right) {
        this.field_name = field_name;
        this.right = right;
    }

    @Override
    public boolean fits(Row row) {
        int left = ((IntegerValue)row.get(field_name)).getValue();

        return (left > right);
    }
}

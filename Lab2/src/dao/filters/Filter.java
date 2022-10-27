package dao.filters;

import dao.Row;

public interface Filter {

    public boolean fits(Row row);

}

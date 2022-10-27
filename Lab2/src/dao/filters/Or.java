package dao.filters;

import dao.Row;

public class Or implements Filter {

    public Filter first, second;

    public Or(Filter first, Filter second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean fits(Row row) {
        return first.fits(row) || second.fits(row);
    }
}

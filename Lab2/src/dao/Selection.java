package dao;

import dao.fields.Field;
import dao.filters.Filter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Selection {

    public final Field[] fields;
    public final ArrayList<Row> rows;
    public final Table table;

    public Selection(Field[] fields, Table table) {
        this.fields = fields;
        this.rows = new ArrayList<Row>();

        this.table = table;
    }

    public void add(Row Row) {
        this.rows.add(Row);
    }

    public void print() {
        for (Row Row : rows)
            System.out.println("Row: " + Row);
    }

    public int size() {
        return rows.size();
    }

    public Row first() throws FirstEmptyException {
        if (rows.size() == 0)
            throw new FirstEmptyException();

        return rows.get(0);
    }

    public DAO[] convert() throws NoSuchFieldException, IllegalAccessException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        DAO[] daos = new DAO[size()];

        for (int i = 0; i < size(); i++)
            daos[i] = rows.get(i).convert();

        return daos;
    }

    public Selection filter(Filter filter) {
        Selection selection = new Selection(fields, table);

        for (Row row: rows) {
            if (filter.fits(row))
                selection.add(row);
        }

        return selection;
    }

}

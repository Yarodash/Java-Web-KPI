package dao;

import dao.fields.Field;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public abstract class DAO {

    public int id = -1;

    public static Table loadTable(String table_name, Field[] fields, DAO template) {
        return Tables.get(table_name, fields, template);
    }

    private Table getTable() throws NoSuchFieldException, IllegalAccessException {
        java.lang.reflect.Field f = this.getClass().getDeclaredField("table");
        f.setAccessible(true);
        return (Table) f.get(this);
    }

    public void generateModel(Row row) throws NoSuchFieldException, IllegalAccessException {
        id = (Integer) row.values[0].getValue();
        Table table = getTable();

        for (int i = 1; i < table.fields.length; i++) {
            java.lang.reflect.Field f = this.getClass().getDeclaredField(table.fields[i].name);
            f.setAccessible(true);
            row.values[i].setDeclaredField(f, this);
        }
    }

    public String generateUpdateQuery() throws NoSuchFieldException, IllegalAccessException {
        Table table = getTable();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("UPDATE ").append(table.table_name).append(" SET ");
        stringBuilder.append("id=").append(id).append(", ");

        for (int i = 1; i < table.fields.length; i++) {
            java.lang.reflect.Field f = this.getClass().getDeclaredField(table.fields[i].name);
            f.setAccessible(true);
            Object value = f.get(this);

            String sql_value = table.fields[i].fromValue(value).toSQLData();

            stringBuilder.append('`').append(table.fields[i].name).append('`').append("=").append(sql_value);

            if (i != table.fields.length - 1)
                stringBuilder.append(", ");
        }
        stringBuilder.append(" WHERE id=").append(id);

        return stringBuilder.toString();
    }

    public String generateInsertQuery() throws NoSuchFieldException, IllegalAccessException {
        Table table = getTable();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("INSERT INTO ").append(table.table_name).append(" (");

        for (int i = 1; i < table.fields.length; i++) {
            stringBuilder.append('`').append(table.fields[i].name).append('`');

            if (i != table.fields.length - 1)
                stringBuilder.append(", ");
        }

        stringBuilder.append(") VALUES (");

        for (int i = 1; i < table.fields.length; i++) {
            java.lang.reflect.Field f = this.getClass().getDeclaredField(table.fields[i].name);
            f.setAccessible(true);
            Object value = f.get(this);

            String sql_value = table.fields[i].fromValue(value).toSQLData();

            stringBuilder.append(sql_value);

            if (i != table.fields.length - 1)
                stringBuilder.append(", ");
        }

        stringBuilder.append(")");

        return stringBuilder.toString();
    }

    public void save()
            throws NoSuchFieldException, IllegalAccessException, SQLException {
        Table table = getTable();

        String query;

        if (id == -1) {
            id = table.getNextId();
            query = generateInsertQuery();
        } else {
            query = generateUpdateQuery();
        }

        table.makeQuery(query);
    }

    public void delete() throws NoSuchFieldException, IllegalAccessException, SQLException {
        String query = "DELETE FROM " + getTable().table_name + " WHERE id=" + id;
        id = -1;

        getTable().makeQuery(query);
    }

    public DAO createEmpty()
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return this.getClass().getDeclaredConstructor().newInstance();
    }

}

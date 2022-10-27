package dao;

import dao.fields.Field;
import dao.fields.IntegerField;
import dao.values.Value;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Table {

    public final String table_name;
    public final Field[] fields;
    public final DAO template;

    public Table(String table_name, Field[] fields, DAO template) {
        this.table_name = table_name;

        this.fields = new Field[fields.length + 1];
        this.fields[0] = new IntegerField("id");
        System.arraycopy(fields, 0, this.fields, 1, fields.length);

        this.template = template;
    }

    public Selection getAll() throws SQLException {
        ResultSet resultSet = DataBase.get().createStatement().executeQuery("SELECT * FROM " + table_name);

        Selection selection = new Selection(fields, this);

        while (resultSet.next()) {
            Value[] values = new Value[this.fields.length];

            for (int i = 0; i < this.fields.length; i++)
                values[i] = this.fields[i].consumeData(resultSet);

            selection.add(new Row(values, this));
        }

        return selection;
    }

    public Row getById(int id) throws SQLException, FirstEmptyException {
        ResultSet resultSet = DataBase.get().createStatement()
                .executeQuery("SELECT * FROM " + table_name + " WHERE id=" + id);

        if (resultSet.next()) {
            Value[] values = new Value[this.fields.length];

            for (int i = 0; i < this.fields.length; i++)
                values[i] = this.fields[i].consumeData(resultSet);

            return new Row(values, this);
        }

        throw new FirstEmptyException();
    }

    public int getNextId() throws SQLException {

        System.out.println("SELECT AUTO_INCREMENT AS next_id FROM information_schema.tables WHERE table_name = '" + table_name + "'");

        ResultSet resultSet = DataBase.get().createStatement().executeQuery(
                "SELECT AUTO_INCREMENT AS next_id FROM information_schema.tables WHERE table_name = '" + table_name + "'");

        resultSet.next();

        return resultSet.getInt("next_id");
    }

    public void makeQuery(String query) throws SQLException {
        System.out.println(query);
        DataBase.get().createStatement().executeUpdate(query);
    }

}

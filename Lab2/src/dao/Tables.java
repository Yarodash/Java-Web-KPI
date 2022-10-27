package dao;

import dao.fields.Field;

import java.util.HashMap;

public class Tables {

    static HashMap<String, Table> tables = new HashMap<>();

    public static Table get(String table_name, Field[] fields, DAO template) {
        if (!tables.containsKey(table_name))
            tables.put(table_name, new Table(table_name, fields, template));

        return tables.get(table_name);
    }

}

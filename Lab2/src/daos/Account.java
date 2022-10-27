package daos;

import dao.DAO;
import dao.Table;
import dao.fields.Field;
import dao.fields.StringField;
import dao.filters.F;

public class Account extends DAO {

    public static Table table = loadTable("accounts",
            new Field[]{
                    new StringField("login"),
                    new StringField("password"),
                    new StringField("user_type"),
            }, new Account());

    public Account() {}

    public String login;
    public String password;
    public String user_type;

    public Account(String login, String password, String user_type) {
        this.login = login;
        this.password = password;
        this.user_type = user_type;
    }

    public boolean register() throws Exception {

        if (table.getAll().filter(F.E("login", login)).size() > 0)
            return false;

        save();
        return true;
    }

}

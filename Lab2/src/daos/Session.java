package daos;

import dao.DAO;
import dao.Table;
import dao.fields.*;
import dao.filters.F;

import java.util.Random;

public class Session extends DAO {

    public static Table table = loadTable("sessions",
            new Field[]{
                    new IntegerField("account_id"),
                    new StringField("token"),
            }, new Session());

    public Session() {}

    public static final int TOKEN_SIZE = 8;

    public int account_id;
    public String token;

    public Session(int account_id, String token) {
        this.account_id = account_id;
        this.token = token;
    }

    private static String generateToken() {
        Random random = new Random();

        String token = "";
        for (int i = 0; i < TOKEN_SIZE; i++)
            token += (char)(random.nextInt(26) + 'a');

        return token;
    }

    public static String generateUniqueToken() throws Exception
    {
        String token;

        do {
            token = generateToken();
        } while (table.getAll().filter(F.E("token", token)).size() > 0);

        return token;
    }

}

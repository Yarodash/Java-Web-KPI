package daos;

import dao.DAO;
import dao.Table;
import dao.fields.Field;
import dao.fields.IntegerField;
import dao.fields.StringField;
import dao.filters.F;

import java.util.Random;

public class Route extends DAO {


    public static Table table = loadTable("routes",
            new Field[]{
                    new StringField("from"),
                    new StringField("to"),
                    new IntegerField("distance"),
                    new StringField("code"),
            }, new Route());

    public Route() {}

    public static final int CODE_SIZE = 4;

    public String from;
    public String to;
    public int distance;
    public String code;

    public Route(String from, String to, int distance, String code) {
        this.from = from;
        this.to = to;
        this.distance = distance;
        this.code = code;
    }

    private static String generateCode() {
        Random random = new Random();

        String token = "";
        for (int i = 0; i < CODE_SIZE; i++)
            token += (char)(random.nextInt(10) + '0');

        return token;
    }

    public static String generateUniqueCode() throws Exception
    {
        String code;

        do {
            code = generateCode();
        } while (table.getAll().filter(F.E("code", code)).size() > 0);

        return code;
    }

    @Override
    public String toString() {
        return "Route{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", distance=" + distance +
                ", code='" + code + '\'' +
                '}';
    }
}

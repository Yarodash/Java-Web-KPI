package daos;

import dao.DAO;
import dao.Table;
import dao.fields.Field;
import dao.fields.IntegerField;

public class Request extends DAO {

    public static Table table = loadTable("request",
            new Field[]{
                    new IntegerField("route_id"),
                    new IntegerField("account_id"),
                    new IntegerField("weight"),
            }, new Request());

    public Request() {}

    public int route_id;
    public int account_id;
    public int weight;

    public Request(int route_id, int account_id, int weight) {
        this.route_id = route_id;
        this.account_id = account_id;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Request{" +
                "route_id=" + route_id +
                ", account_id=" + account_id +
                ", weight=" + weight +
                '}';
    }
}

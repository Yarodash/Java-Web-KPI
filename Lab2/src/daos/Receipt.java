package daos;

import dao.DAO;
import dao.Table;
import dao.fields.*;

public class Receipt extends DAO {

    public static Table table = loadTable("receipts",
            new Field[]{
                    new IntegerField("route_id"),
                    new IntegerField("account_id"),
                    new IntegerField("weight"),
                    new IntegerField("price"),
                    new StringField("bank_url"),
            }, new Receipt());

    public Receipt() {}

    public int route_id;
    public int account_id;
    public int weight;
    public int price;
    public String bank_url;


    public Receipt(int route_id, int account_id, int weight, int price, String bank_url) {
        this.route_id = route_id;
        this.account_id = account_id;
        this.weight = weight;
        this.price = price;
        this.bank_url = bank_url;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "route_id=" + route_id +
                ", account_id=" + account_id +
                ", weight=" + weight +
                ", price=" + price +
                ", bank_url='" + bank_url + '\'' +
                '}';
    }
}

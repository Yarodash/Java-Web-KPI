import daos.Account;
import handlers.MyRequestHandler;
import json.JsonArray;
import json.JsonDict;
import server.Server;

public class Main {

    public static Server server;

    public static void make_request(JsonDict request) throws InterruptedException {
        System.out.println("Request: " + request);
        System.out.println("Response: " + server.requests.make_quick_request(request));
    }

    public static void main(String[] args) throws Exception {

        server = new Server(new MyRequestHandler());
        server.run();

        String token = "nxkmhhgr";
        //String token = "puesaats";

        /*make_request(
                new JsonDict()
                        .put("request_type", "register")
                        .put("login", "admin")
                        .put("password", "root")
        );*/

        /*make_request(
                new JsonDict()
                        .put("request_type", "login")
                        .put("login", "admin")
                        .put("password", "root")
        );*/

        /*make_request(
                new JsonDict()
                        .put("token", token)
                        .put("request_type", "getData")
                        .put("filters",
                                new JsonArray()
                                        .push(new JsonArray().push("from").push("StringEqual").push("New York") )
                                        .push(new JsonArray().push("distance").push("IntegerLess").push(3000))
                        )
        );*/

        /*make_request(
                new JsonDict()
                        .put("token", token)
                        .put("request_type", "calculatePrice")
                        .put("code", "4658")
                        .put("weight", 100)
        ); */

        /*make_request(
                new JsonDict()
                        .put("token", token)
                        .put("request_type", "makeRequest")
                        .put("code", "4658")
                        .put("weight", 100)
        );*/

        /*make_request(
                new JsonDict()
                        .put("token", token)
                        .put("request_type", "getRequests")
        );*/

        /*make_request(
                new JsonDict()
                        .put("token", token)
                        .put("request_type", "showAllRequests")
        );*/

        /*make_request(
                new JsonDict()
                        .put("token", token)
                        .put("request_type", "formRecipe")
                        .put("request_id", 2)
                        .put("bank_url", "https://www.privatbank.com/pay/token456")
        );*/

        /*make_request(
                new JsonDict()
                        .put("token", token)
                        .put("request_type", "getReceipts")
        );*/

        server.disable();

    }

}

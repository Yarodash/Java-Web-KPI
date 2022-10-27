package requests;

import json.JsonDict;

import java.util.ArrayDeque;
import java.util.Deque;

public class Requests {

    public Deque<GET> requests;

    public Requests() {
        requests = new ArrayDeque<>();
    }

    public void add_request(GET request) {
        requests.addLast(request);
    }

    public GET get() {
        if (requests.size() > 0)
            return requests.pop();
        return null;
    }

    public JsonDict make_quick_request(JsonDict request) throws InterruptedException {
        GET get = new GET(request);
        add_request(get);
        return get.getAnswer();
    }

}

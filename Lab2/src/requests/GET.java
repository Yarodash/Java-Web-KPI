package requests;

import json.JsonDict;

import java.util.concurrent.Semaphore;

public class GET {

    public JsonDict request;
    public JsonDict response;
    public Semaphore semaphore;

    public GET(JsonDict request) throws InterruptedException {
        this.request = request;

        semaphore = new Semaphore(1);
        semaphore.acquire();
    }

    public void answer(JsonDict response) {
        this.response = response;
        semaphore.release();
    }

    public JsonDict getAnswer() throws InterruptedException {
        semaphore.acquire();
        return response;
    }

}

package server;

import json.JsonDict;
import requests.GET;
import requests.Requests;

public class Worker implements Runnable {

    private final Server owner;
    private volatile boolean running = true;

    public Worker(Server owner) {
        this.owner = owner;
    }

    private JsonDict prepareAnswer(JsonDict request) throws Exception {
        return owner.handler.answer(request);
    }

    private void mainloop() throws Exception {
        while (running) {
            GET request = owner.requests.get();

            if (request == null) {
                Thread.sleep(100);
                continue;
            }

            request.answer(prepareAnswer(request.request));
        }
    }

    public void disable() {
        running = false;
    }

    @Override
    public void run() {
        try {
            mainloop();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

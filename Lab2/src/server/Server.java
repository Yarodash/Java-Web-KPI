package server;

import handlers.Handler;
import requests.Requests;

public class Server {

    public final Handler handler;
    public Requests requests = new Requests();
    private final Worker worker = new Worker(this);
    private final Thread worker_thread = new Thread(worker);

    public Server(Handler handler) {
        this.handler = handler;
    }

    public void run() {
        worker_thread.start();
    }

    public void disable() throws InterruptedException {
        worker.disable();
        worker_thread.join();
    }

}

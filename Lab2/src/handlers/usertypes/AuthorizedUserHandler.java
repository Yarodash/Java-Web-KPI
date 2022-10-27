package handlers.usertypes;

import handlers.features.*;

public class AuthorizedUserHandler extends BaseUserHandler {

    public AuthorizedUserHandler() {
        super();
        makeRequest_handler = new MakeRequest();
        getRequests_handler = new GetRequests();

        getReceipts_handler = new GetReceipts();
    }

}

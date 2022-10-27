package handlers.usertypes;

import handlers.features.*;

public abstract class UserHandler {

    public Feature register_handler = new AccessDenied();
    public Feature login_handler = new AccessDenied();
    public Feature getData_handler = new AccessDenied();
    public Feature calculatePrice_handler = new AccessDenied();
    public Feature makeRequest_handler = new AccessDenied();
    public Feature getRequests_handler = new AccessDenied();
    public Feature showAllRequests_handler = new AccessDenied();
    public Feature formRecipe_handler = new AccessDenied();
    public Feature getReceipts_handler = new AccessDenied();

}

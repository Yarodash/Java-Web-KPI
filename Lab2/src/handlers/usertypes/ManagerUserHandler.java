package handlers.usertypes;

import handlers.features.*;

public class ManagerUserHandler extends AuthorizedUserHandler {

    public ManagerUserHandler() {
        super();
        showAllRequests_handler = new ShowAllRequests();
        formRecipe_handler = new FormRecipe();
    }

}

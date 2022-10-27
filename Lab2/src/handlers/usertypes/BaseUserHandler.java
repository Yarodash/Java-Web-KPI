package handlers.usertypes;

import handlers.features.*;

public class BaseUserHandler extends UserHandler {

    public BaseUserHandler() {
        login_handler = new Login();
        register_handler = new Register();
        getData_handler = new GetData();
        calculatePrice_handler = new CalculatePrice();
    }

}

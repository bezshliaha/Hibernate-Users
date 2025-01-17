package org.example.app.service;

import org.example.app.controller.UserController;
import org.example.app.exception.OptionException;
import org.example.app.utils.Constants;
import org.example.app.utils.AppStarter;
import org.example.app.view.AppView;

public class AppService {
    UserController controller = new UserController();

    public void filterChoise(int choise) {
        switch (choise) {
            case 1 -> controller.createUser();
            case 2 -> controller.readUsers();
            case 3 -> controller.updateUser();
            case 4 -> controller.deleteUser();
            case 5 -> controller.readUserById();
            case 0 -> new AppView().getOutput(Integer.toString(choise));
            default -> {
                try {
                    throw new OptionException(Constants.INCORRECT_OPTION_MSG);
                } catch (OptionException e) {
                    new AppView().getOutput(e.getMessage());
                    AppStarter.startApp();
                }
            }
        }
    }
}

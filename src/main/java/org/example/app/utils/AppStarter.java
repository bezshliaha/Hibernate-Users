package org.example.app.utils;

import org.example.app.controller.AppController;
import org.example.app.service.AppService;
import org.example.app.view.AppView;

public class AppStarter {
    public static void startApp() {
        AppService appService = new AppService();
        AppView appView = new AppView();
        AppController controller = new AppController(appView, appService);
        controller.runApp();
    }
}

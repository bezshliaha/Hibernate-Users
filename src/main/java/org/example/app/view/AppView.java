package org.example.app.view;

import org.example.app.utils.Constants;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppView {
    Scanner scanner;
    int option;

    public int chooseOption() {
        scanner = new Scanner(System.in);
        showMenu();
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println(Constants.INCORRECT_OPTION_MSG);
        }
        return option;
    }

    private void showMenu() {
        System.out.print("""
                                
                ______ MENU ___________
                1 - Create user.
                2 - Read all users.
                3 - Update user info.
                4 - Delete user.
                5 - Read user by id.
                0 - Close the App.
                """);
        System.out.print("Input option: ");
    }

    public void getOutput(String output) {
        if (output.equals("0")) {
            System.out.println(Constants.APP_CLOSE_MSG);
            System.exit(0);
        } else System.out.println(output);
    }
}

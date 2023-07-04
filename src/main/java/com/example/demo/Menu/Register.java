package com.example.demo.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.example.demo.Service.User_Service;

public class Register {
    Scanner scanner = new Scanner(System.in);

    public void reg(int opt) {
        User_Service usr_register = new User_Service();
        Login usr_login = new Login();

        boolean notDone = true;
        while (notDone) {
            // clear screen
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Register.java");
            System.out.println("Register or Login Menu:");
            System.out.println("");
            System.out.println("0 - Back");
            System.out.println("1 - Register");
            System.out.println("2 - Login");

            System.out.println("");
            System.out.print("Enter a choice: ");

            try {
                opt = scanner.nextInt();
                // clear screen
                System.out.print("\033[H\033[2J");
                System.out.flush();

                switch (opt) {
                    // register
                    case 0:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        notDone = false;
                        break;
                    case 1:
                        usr_register.register_menu(opt);
                        break;
                    case 2:
                        usr_login.login_menu(opt);
                        break;
                }

            } catch (InputMismatchException e) {
                // clear screen
                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("Invalid input");
                System.out.println("press a character and Enter to continue");

                char choice = scanner.next().charAt(0);

                choice = scanner.next().charAt(0);
                if ((choice == 'c') || (choice == 'C')) {
                    System.out.println("Back to Option Menu");
                    notDone = true;
                }
            }
        }
    }
}

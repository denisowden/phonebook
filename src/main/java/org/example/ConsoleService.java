package org.example;

import java.util.Scanner;

public class ConsoleService {
    private static Scanner scanner = new Scanner(System.in);

    public static String readLine() {
        return scanner.nextLine();
    }

    public static long readNumber() {
        long a;
        while (true) {
            try {
                a = Long.parseLong(readLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Only numbers are accepted");
            }
        }
        return a;
    }

    public static void start() {
        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            if (a.equalsIgnoreCase("add")) {
                ContactService.add();
            } else if (a.equalsIgnoreCase("remove")) {
                ContactService.remove();
            } else if (a.equalsIgnoreCase("show")) {
                ContactService.showbook();
            } else if (a.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Wrong command");
            }
        }
    }
}

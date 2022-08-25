package org.example;


import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String a = scanner.nextLine();
            if(a.equalsIgnoreCase("add")){
                AddContact.add();
            }else if(a.equalsIgnoreCase("remove")){
                DeleteContact.remove();
            }else if(a.equalsIgnoreCase("show")){
                Showbook.showbook();
            }else if(a.equalsIgnoreCase("exit")){
                break;
            }else {
                System.out.println("Wrong command");
                continue;
            }
        }


    }
}
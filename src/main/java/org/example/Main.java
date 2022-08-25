package org.example;


public class Main {

    public static void main(String[] args) {

        while (ConsoleService.scanner.hasNext()){
            String a = ConsoleService.scanner.nextLine();
            if(a.equalsIgnoreCase("add")){
                ContactService.add();
            }else if(a.equalsIgnoreCase("remove")){
                ContactService.remove();
            }else if(a.equalsIgnoreCase("show")){
                ContactService.showbook();
            }else if(a.equalsIgnoreCase("exit")){
                break;
            }
            else {
                System.out.println("Wrong command");
            }
        }
    }
}
package processor;

import java.util.Scanner;

public class Main {
    public final static Scanner SRC = new Scanner(System.in);
    public static Menu menu;

    public static void main(String[] args) {
        menu = new Menu();
        menu.show();
    }

}



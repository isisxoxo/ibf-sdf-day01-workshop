import java.io.Console;
import java.util.*;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

//Compile: javac --source-path src -d bin src/*
//Run: java -cp bin App
//Package into jar: (in bin folder for this line) jar -c -v -f src.jar -e src.* .
//Execute jar: (in day01-workshop folder for this line) java -cp src.jar src/*


public class App {

    public static void main(String[] args) throws Exception {

        List<String> cartList = new ArrayList<>();
        System.out.println("Welcome to your shopping cart");

        Console cons = System.console();
        String input = cons.readLine("> ");
        input = input.toLowerCase();

        while (!input.equals("quit")) {

            if (input.equals("list")) {

                if (cartList.size() <= 0) {
                    System.out.println("Your cart is empty");
                } else {
                    for (String item : cartList) {
                        int index = cartList.indexOf(item) + 1;
                        System.out.printf("%d. %s\n", index, item);
                    }
                }

            }
            
            if (input.startsWith("add")) {
                String stringAdd = input.substring(4).replace(",", " "); //so that we start from after "add "
                Scanner scan = new Scanner(stringAdd);
                while (scan.hasNext()) {
                    String addItem = scan.next();

                    if (cartList.contains(addItem)) {
                        System.out.println("You have " + addItem + " in your cart");
                    } else {
                        cartList.add(addItem);
                        System.out.println(addItem + " added to cart");
                    }
                }
                scan.close();
            }

            if (input.startsWith("delete")) {
                String stringDelete = input.substring(7).replace(",", " ");
                Scanner scan = new Scanner(stringDelete);
                while (scan.hasNext()) {
                    String deleteItem = scan.next();
                    int deleteIndex = Integer.parseInt(deleteItem);
                    deleteIndex = deleteIndex - 1;

                    if (deleteIndex < cartList.size()) {
                        System.out.println(cartList.get(deleteIndex) + " removed from cart");
                        cartList.remove(deleteIndex);
                    } else {
                        System.err.println("Incorrect item index");
                    }
                }
            }

            input = cons.readLine("> ");
            input = input.toLowerCase();

        }
        System.out.println("Bye! Thank you for shopping");

    }
}

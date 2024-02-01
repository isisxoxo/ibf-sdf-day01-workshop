import java.io.Console;
import java.util.ArrayList;
import java.util.List;

//Compile: javac --source-path src -d bin src/*
//Run: java -cp bin App
//Package into jar: (in bin folder) jar -c -v -f src.jar -e src.* .
//Execute jar: java -cp App.jar src.App


public class App {
    public static void main(String[] args) throws Exception {
        List<String> cartList = new ArrayList<>();
        System.out.println("Welcome to your shopping cart");

        Console cons = System.console();
        String input = cons.readLine("> ");

        // while (cartList.size() <= 0) {
        //     System.out.println("Your cart is empty");
        // }
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Raven {

    private String [ ] positive;
    private String [ ] negative;
    private int posCount;
    private int negCount;
    private String input = "";
    private Scanner in;
    private ArrayList<String> chatHistory;
    private Invoice invoice;
    private ArrayList<Invoice> invoiceList;
    private int questionCounter;

    public Raven() {
        positive = new String [] {"good", "glad", "happy", "relaxed", "accomplished", "alert", "creative"};
        negative  = new String [] {"bad", "sad", "tired", "angry", "anxious", "hungry", "moody", "afraid"};
        in = new Scanner(System.in);
        chatHistory = new ArrayList<>();
        invoice = new Invoice();
        invoiceList = new ArrayList<>();
        questionCounter = 0;
    }

    // Returns the user input
    public String getInput () {
        return input;
    }

    // Returns the # of positive words in the user input
    public int getPosCount() {
        return posCount;
    }

    // Returns the # of negative words in the user input
    public int getNegCount() {
        return negCount;
    }

    // Starts the program
    public void start() {
        Scanner in = new Scanner(System.in);
        String gm = "Good morning, how are you feeling today? ";
        System.out.print(gm);
        input = in.nextLine();
        chatHistory.add(gm + input);
        questionCounter++;
    }

    // Scans user input and increments the pos and neg counters depending on the input
    public void scanInput(String input) {
        String inputArray [] = input.split(" ");
        posCount = 0;
        negCount = 0;

        for (int i = 0; i < positive.length; i++) {
            posCount += Collections.frequency(Arrays.asList(inputArray), positive[i]);
        }

        for (int j = 0; j < negative.length; j++) {
            negCount += Collections.frequency(Arrays.asList(inputArray), negative[j]);
        }
    }

    // Prints out responses depending on the # of neg and pos words the user inputs
    public void printRavenResponse() {
        String response = "";

        if (getPosCount() > getNegCount()) {
            response += "I am so happy for you...Yay...";
            System.out.println(response);
            chatHistory.add(response);
        } else if (getPosCount() < getNegCount()) {
            response += "Really! Why, tell me more!";
            System.out.println(response);
            chatHistory.add(response);
        } else {
            response += "Meh.";
            System.out.println(response);
            chatHistory.add(response);
        }
    }

    // Runs the program again if the user does not enter N or n.
    public void again() {

        while (true) {
            String contTalking = "Would you like to continue talking? (Y/N): ";
            System.out.print(contTalking);
            String again = in.nextLine();
            chatHistory.add(contTalking + again);
            if (!again.equalsIgnoreCase("Y")) {
                String ended = "The chat has ended.";
                System.out.println(ended);
                chatHistory.add(ended);
                break;
            } else {
                start();
                scanInput(input);
                printRavenResponse();
            }
        }
    }

    // Method prints the chat history
    public void printHistory() {
        System.out.println("\nCHAT HISTORY\n------------");
        for (String s : chatHistory) {
            System.out.println(s);
        }
    }

    // Method asks for the users info
    public void askInfo() {
        System.out.println("\nPlease enter your billing information below");
        System.out.print("Enter your full name: ");
        String name = in.nextLine();
        invoice.setName(name);
        System.out.print("Enter your street address: ");
        String address = in.nextLine();
        invoice.setStAddress(address);
        System.out.print("Enter your city: ");
        String city = in.nextLine();
        invoice.setCity(city);
        System.out.print("Enter your state: ");
        String state = in.nextLine();
        invoice.setState(state);
        System.out.print("Enter your zip code: ");
        int zip = in.nextInt();
        invoice.setZipCode(zip);
    }

    public void addInvoice() {
        invoiceList.add(new Invoice(1, "Session", 100, 1 * 100));
        invoiceList.add(new Invoice(questionCounter, "Questions", .35, questionCounter * .35));
    }

    public void printInvoice() {
        String s = "";
        double total = 0;
        invoice.printBillingInfo();
        System.out.println("\nItems:");
        for (Invoice i : invoiceList) {
            s += i.getQuantity() + "\t\t" + i.getDescription() + "    " + i.getPrice() + "    " + i.getTotal() + "\n";
            total += i.getTotal();
        }
        System.out.println("Quantity Description Price Total");
        System.out.println(s);
        System.out.println("Total due : $" + total + "\n");
        System.out.println("Thank you for doing business with Raven");
    }

}

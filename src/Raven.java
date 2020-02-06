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

    public Raven() {
        positive = new String [] {"good", "glad", "happy", "relaxed", "accomplished", "alert", "creative"};
        negative  = new String [] {"bad", "sad", "tired", "angry", "anxious", "hungry", "moody", "afraid"};
        in = new Scanner(System.in);
        chatHistory = new ArrayList<>();
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

}

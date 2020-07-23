import java.util.*;

public class Project4 {

  static String input() {
    Scanner user_input = new Scanner(System.in);
    return user_input.nextLine().trim();
  }

  static int testForInt(String input, String regExPattern, int defaultInt) {
    if (input.matches(regExPattern)) {
      return Integer.parseInt(input);
    } else {
      return defaultInt;
    }
  }

  static String capFirstChar(String input) {
    return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
  }

  static String testArticle(String nextWord) {
    if (nextWord.matches("^[aeiou].*$")) {
      return "an " + nextWord;
    } else {
      return "a " + nextWord;
    }
  }

  static String getWord(String type) {
    System.out.println("Enter " + testArticle(type) + ":");
    ArrayList<String> errors = new ArrayList<String>();
    while (true) {
      String testMe = input();
      if (testMe.matches("^[-\\sa-zA-Z]+$")) {
        return testMe.toLowerCase();
      }
      if (testMe.matches("^.*[^-\\sa-z].*$")) {
        errors.add("only A through Z characters");
      }
      if (testMe.matches("^$")) {
        errors.add("typing anything at all");
      }
      System.out.println("Oops! Your answer doesn't look quite right.");
      if (!errors.isEmpty()) {
        System.out.println("(Check for " + errors.toString().replace("[","").replace("]","") + ")");
      }
      errors.clear();
    }
  }

  static String itemPicker(String message, String[] itemArray) {
    System.out.println(message);
    for (String i : itemArray) {
      System.out.println(" " + (Arrays.asList(itemArray).indexOf(i) + 1) + " " + i);
    }
    return input();   
  }

//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

  public static void main(String[] args) {

    System.out.println("-- Project4 --");

    System.out.println("\nYou are creating an email that you can copy & paste to your friends...\n");

    while (true) {
      String[] hi = {"Hello!", "Hi!", "Greetings!", "Good morning!", "Good afternoon!", "Good evening!"};
      String greet = hi[testForInt(itemPicker("Choose a greeting (or hit enter for default):", hi), "^[1-6]$", 1) - 1];

      String name = capFirstChar(getWord("first name")) + " " + capFirstChar(getWord("last name"));

      String color = getWord("color");
      
      String food = getWord("favorite food");

      String animal = getWord("favorite animal (PLURAL)");

      String other = "I have " + testArticle(getWord("adjective")) + " " + getWord("noun");

      String[] bye = {"Bye!", "Goodbye!", "Have a good day!", "Adios!", "See ya!", "Take care!"};
      String farewell = bye[testForInt(itemPicker("Choose a farewell (or hit enter for default):", bye), "^[1-6]$", 1) - 1];
      

      System.out.println("Here is your message to send to all your friends:\n");
      System.out.println(greet + "\n\n   My name is " + name + " and I like eating " + food + " while petting " + color + " " + animal + ". One final thing that I would like to tell you is that " + other + ".\n\n" + farewell + "\n~" + name);

      System.out.println("\n\nHit enter to write another message or key(s) + enter to exit the program");
      String loop = input();
      if (loop.matches("^$")) {
        continue;
      } else {
        break;
      }
    }
  }
}

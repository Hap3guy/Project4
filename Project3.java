import java.util.*;

public class Project3 {

  static String input() {
    Scanner user_input = new Scanner(System.in);
    return user_input.nextLine();
  }

  static int testForInt(String input, String regExPattern, int defaultInt) {
    if (input.matches(regExPattern)) {
      return Integer.parseInt(input);
    } else {
      return defaultInt;
    }
  }

  static String testArticle(String nextWord) {
    System.out.println(nextWord.charAt(0));
    System.out.println(nextWord.equals("\b[aeiou]"));
    if (nextWord.matches("\b[aeiou]")) {
      return "an " + nextWord;
    } else {
      return "a " + nextWord;
    }
  }

  static String getWord(String type) {
    System.out.println("Enter " + testArticle(type) + ":");
    return input();
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

    // a standard Java method for output of a STRING LITERAL
    // the \n denotes a "carriage return" - or blank line
    System.out.println("-- Project3 --");

    System.out.println("\nYou are creating an email that you can copy & paste to your friends...\n");

    while (true) {
      String[] hi = {"Hello!", "Hi!", "Greetings!", "Good morning!", "Good afternoon!", "Good evening!"};
      String greet = hi[testForInt(itemPicker("Choose a greeting (or hit enter for default):", hi), "^[1-6]$", 1) - 1];

      String name = getWord("full name");

      String color = getWord("color");
      
      String food = getWord("favorite food");

      String animal = getWord("favorite animal (PLURAL)");

      String other = "I have a " + getWord("adjective") + " " + getWord("noun");

      String[] bye = {"Bye!", "Goodbye!", "Have a good day!", "Adios!", "See ya!", "Take care!"};
      String farewell = bye[testForInt(itemPicker("Choose a farewell (or hit enter for default):", bye), "^[1-6]$", 1) - 1];
      

      System.out.println("Here is your message to send to all your friends:\n");
      System.out.println(greet + "\n\n   My name is " + name + " and I like eating " + food + " while petting " + color + " " + animal + ". One final thing that I would like to tell you is that " + other + ".\n\n" + farewell + "\n~" + name);

      System.out.println("\n\nHit enter to write another message or key(s) + enter to exit");
      String loop = input();
      if (loop.matches("^$")) {
        continue;
      } else {
        break;
      }
    }
  }
}

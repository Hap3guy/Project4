import java.util.*;

class Main {

  public static String input(boolean forDialogue) {
    if (forDialogue) {
      System.out.println("Press enter to continue");
    }
    Scanner user_input = new Scanner(System.in);
    return user_input.nextLine().trim();
  }

  public static boolean isEmail(String email) {
    if (email.matches("^.*@.*")) {
      return true;
    } else {
      System.out.println("Sorry, that is not a valid email address.");
      return false;
    }
  }

  public static boolean isPassword(String password) {
    if (password.matches("^(?=.*[a-z]){1,}(?=.*[A-Z]){1,}(?=.*[0-9]){1,}(?=.*[!@#$%^&*()--__+.]){1,}.{8,}$")) {
      return true;
    } else {
      System.out.println("Password not secure enough! (requires a password length of 8 or more and have at least one instance of an uppercase, lowercase, number, and special character)");
      return false;
    }
  }

  public static boolean isWord(String word) {
    ArrayList<String> errors = new ArrayList<String>();
    if (word.matches("^[-\\sa-zA-Z]+$")) {
      return true;
    }
    if (word.matches("^.*[^-\\sa-z].*$")) {
      errors.add("only A through Z characters");
    } 
    if (word.matches("^$")) {
      errors.add("typing anything at all");
    }
    System.out.println("Oops! Your answer doesn't look quite right.");
    if (!errors.isEmpty()) {
      System.out.println("(Check for " + errors.toString().replace("[","").replace("]","") + ")");
    }
    errors.clear();
    return false;
  }

  public static String capFirstChar(String word) {
    return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
  }

  // public static int testForInt(String input, String regExPattern, int defaultInt) {
  //   if (input.matches(regExPattern)) {
  //     return Integer.parseInt(input);
  //   } else {
  //     return defaultInt;
  //   }
  // }

  // public static String itemPicker(String[] itemArray) {
  //   for (String i : itemArray) {
  //     System.out.println(" " + (Arrays.asList(itemArray).indexOf(i) + 1) + " " + i);
  //   }
  //   return inputLoop();   
  // }

  public static String testArticle(String nextWord) {
    if (nextWord.matches("^[aeiou].*$")) {
      return "an " + nextWord;
    } else {
      return "a " + nextWord;
    }
  }

  public static void createAccount() {
    // inputLoop("Enter your first name:", isWord(input(false)));
  }

  //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

  public static void main(String[] args) {

    System.out.println("-- Project4 --");

    System.out.println("Wel-Wel-Wel-Welcome to Wonderful Words Inc. My name is Wordy and I'm here to guide you through what we have to offer!");
    input(true);
    System.out.println("First things first, we need to get ya set up with an account.");
    input(true);


    // System.out.println("\nYou are creating an email that you can copy & paste to your friends...\n");

    // while (true) {

    //   System.out.println("\n\nHit enter to write another message or key(s) + enter to exit the program");
    //   String loop = inputLoop(boolean testSucess);
    //   if (loop.matches("^$")) {
    //     continue;
    //   } else {
    //     break;
    //   }
    // }
  }

}
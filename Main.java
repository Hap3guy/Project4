import java.util.*;

class Main {

  private static ArrayList<Account> accounts = new ArrayList<Account>();

  public static String input() {
    Scanner user_input = new Scanner(System.in);
    return user_input.nextLine().trim();
  }

  public static String testArticle(String nextWord) {
    if (nextWord.matches("^[aeiou].*$")) {
      return "an " + nextWord;
    } else {
      return "a " + nextWord;
    }
  }

  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }  

  static String getWord(String type) {
    System.out.println("Please enter " + testArticle(type) + ":");
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

  public static String getEmail() {
    System.out.println("Enter an email address:");
    while (true) {
      String testMe = input();
      if (testMe.matches("^.*@.*")) {
        return testMe.toLowerCase();
      } else {
        System.out.println("Sorry, that is not a valid email address.");
      }
    }
  }

  public static String getPassword() {
    System.out.println("Enter a password:");
    while (true) {
      String testMe = input();
      if (testMe.matches("^(?=.*[a-z]){1,}(?=.*[A-Z]){1,}(?=.*[0-9]){1,}(?=.*[!@#$%^&*()--__+.]){1,}.{8,}$")) {
        return testMe;
      } else {
        System.out.println("Password not secure enough! (requires a password length of 8 or more and have at least one instance of an uppercase, lowercase, number, and special character)");
      }
    }
  }

  public static String capFirstChar(String word) {
    return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
  }

  public static int itemPicker(String[] itemArray) {
    while (true) {
      for (String i : itemArray) {
        System.out.println(" " + (Arrays.asList(itemArray).indexOf(i) + 1) + " " + i);
      }
      String testMe = input();

      if (testMe.matches("^[1-" + Integer.toString(itemArray.length) + "]$")) {
        return Integer.parseInt(testMe);
      } else {
        clearScreen();
        System.out.println("Invalid input.");
      }
    }
  }

  public static void createAccount() {
    accounts.add(new Account(getWord("first name"), getWord("last name"), getEmail(), getPassword()));
    System.out.println("Account created successfully!");
    input();
  }

  public static void createAccountTutorial() {
    System.out.println("Wel-Wel-Wel-Welcome to Wonderful Words Inc. My name is Wordy and I'm here to guide you through what we have to offer!");
    input();
    System.out.println("First things first, we need to get ya set up with an account.");
    input();
    createAccount();
    System.out.println("Nice! Now that you have your own account, I can show you the very simplistic menu, where you will be able to choose programs to run. Hopefully the rest is self-explanitary!");
    input();
  }

  public static void listAccounts() {
    System.out.println("Here is a list of active accounts:");
    System.out.println(accounts);
    input();
  }

  public static void callMenu() {
    String[] menu = {"Create Account Tutorial", "Create Account", "Update Account", "List Active Accounts", "Email Generator","Quit"};
    clearScreen();
    System.out.println("This is the main menu.");
    menuProgram(itemPicker(menu));
  }

  public static void menuProgram(int programNumber) {
    clearScreen();
    switch (programNumber) {
      case 1:
        createAccountTutorial();
        break;
      case 2:
        createAccount();
        break;
      case 3:
        System.out.println("Sorry, this isn't available yet :(");
        input();
        break;
      case 4:
        listAccounts();
        break;
      case 5:
        System.out.println("Sorry, this isn't available yet :(");
        input();
        break;
      case 6:
        System.out.println("See ya later!");
        java.lang.System.exit(0);
    }
    callMenu();
  }

  //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

  public static void main(String[] args) {

    System.out.println("-- Project4 --");

    callMenu();

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
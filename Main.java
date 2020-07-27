import java.util.*;
import java.io.*;

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

  public static String getWord(String type) {
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
      if (testMe.matches("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")) {
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
        return testMe.replace(" ", "");
      } else {
        System.out.println("Password not secure enough! (requires a password length of 8 or more and have at least one instance of an uppercase, lowercase, number, and special character)");
      }
    }
  }

  public static String capFirstChar(String word) {
    return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
  }

  public static int itemPicker(String message, String[] itemArray) {
    System.out.println(message);
    while (true) {
      for (String i : itemArray) {
        System.out.println(" " + (Arrays.asList(itemArray).indexOf(i) + 1) + " " + i);
      }
      String testMe = input();

      if (testMe.matches("^[1-" + Integer.toString(itemArray.length) + "]$")) {
        return Integer.parseInt(testMe);
      } else {
        // clearScreen();
        System.out.println("Invalid input. Type a number between 1 and " + Integer.toString(itemArray.length));
      }
    }
  }

  public static void importDataFile() {
    try {
      File myObj = new File("datafile.txt");
      Scanner myReader = new Scanner(myObj);
      String data = myReader.nextLine();
      String[] split = data.split("\\]\\[", 0);
      accounts.clear();
      for (String s : split) {
        s = s.replace("[","").replace("]","");
        String[] subsplit = s.split(", ", 0);
        accounts.add(new Account(subsplit[0], subsplit[1], subsplit[2], subsplit[3]));
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("Unable to read datafile.txt");
      e.printStackTrace();
    }
  }

  public static void createDataFile() {
    try {
      File myObj = new File("datafile.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        importDataFile();
      }
    } catch (IOException e) {
      System.out.println("An error occurred while trying to create a file.");
      e.printStackTrace();
    }
  }

  public static void updateDataFile() {
    try {
      FileWriter myWriter = new FileWriter("datafile.txt");
      for (Account i : accounts) {
        myWriter.write(Arrays.toString(i.getInfo()));
      }
      myWriter.close();
      System.out.println("Updated datafile.txt");
    } catch (IOException e) {
      System.out.println("Unable to update datafile.txt");
      e.printStackTrace();
    }
  }

  public static void createAccount() {
    createDataFile();
    accounts.add(new Account(capFirstChar(getWord("first name")), capFirstChar(getWord("last name")), getEmail(), getPassword()));
    System.out.println("Account created successfully!");
    updateDataFile();
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
    callMenu();
  }

  public static void listAccounts() {
    importDataFile();
    for (Account i : accounts) {
      System.out.println(accounts.indexOf(i) + 1);
      i.printAccount();
    }
  }

  public static Account accountPicker() {
    listAccounts();
    while (true) {
      String testMe = input();
      int parsedInput;
      if (testMe.matches("^[1-" + Integer.toString(accounts.size()) + "]$")) {
        return accounts.get(Integer.parseInt(testMe) - 1);
      } else {
        System.out.println("Invalid input. Type a number between 1 and " + Integer.toString(accounts.size()));
      }
    }
  }

  public static void updateAccount() {
    System.out.println("Enter the number of the account you want to update:");
    Account chosenAccount = accountPicker();
    switch (itemPicker("Choose what you would like to update:", chosenAccount.getInfo())) {
      case 1:
        chosenAccount.setFirstname(capFirstChar(getWord("first name")));
        break;
      case 2:
        chosenAccount.setLastname(capFirstChar(getWord("last name")));
        break;
      case 3:
        chosenAccount.setEmail(getEmail());
        break;
      case 4:
        chosenAccount.setPassword(getPassword());
        break;
    }
    updateDataFile();
    System.out.println("Sucessfully updated the account.");
    input();
  }

  public static void deleteAccount() {
    System.out.println("Enter the number of the account you want to delete:");
    accounts.remove(accountPicker());
    updateDataFile();
    System.out.println("Account deleted successfully.");
    input();
  }

  public static void emailGenerator() {
    System.out.println("\nYou are creating an email that you can copy & paste to your friends...\n");

    // EmailGenerator myEmail = new EmailGenerator(getWord("first name"),getWord("last name"), getWord("favorite color"), getword("favorite food"), getWord("favorite animal"), getword("noun"), getWord("adjective"), itemPicker("Choose a greeting:", myEmail.greetings), itemPicker("Choose a farewell:", myEmail.farwells));
    input();
  }

  public static void callMenu() {
    String[] menu = {"Create Account Tutorial", "Create Account", "Update Account", "Delete Account", "List All Accounts", "Email Generator","Quit"};
    clearScreen();
    System.out.println("-- Project4 --");
    menuProgram(itemPicker("This is the main menu.", menu));
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
        updateAccount();
        break;
      case 4:
        deleteAccount();
        break;
      case 5:
        System.out.println("Here is a list of accounts:");
        listAccounts();
        input();
        break;
      case 6:
        // emailGenerator();
        System.out.println("Sorry, this program isn't available yet :(");
        input();
        break;
      case 7:
        System.out.println("See ya later!");
        java.lang.System.exit(0);
    }
    callMenu();
  }

  public static boolean dataFileExists() {
    File f = new File("datafile.txt");
    return f.exists() ? true : false;
  }

  //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

  public static void main(String[] args) {

    if (dataFileExists()) {
      callMenu();
    } else {
      createAccountTutorial();
    }

  }

}

// the import keyword is used to load in additional Java PACKAGE code for our programs
// in this case, we are loading in the standard "util" package for the Scanner class
import java.util.*;


// we use the class keyword to denote an OBJECT
// an object is simply a collection of PROPERTIES (variables)
// and METODS (functions) that relate to each other
public class Project1_1 {

  // all of our Java programs will have a "main method"
  // this is the ENTRY POINT of our program
  // the keywords prior to main:
  // - public: denotes the access permissions for other objects
  // - static: denotes procedural style code (i.e., not Object Oriented)
  // - void: the return type of the method (in this case NOTHING)
  public static void main(String[] args) {

    // initialize a variable of type OBJECT Scanner and call its CONSTRUCTOR with the System.in parameter)
    Scanner user_input = new Scanner(System.in);

    // a standard Java method for output of a STRING LITERAL
    // the \n denotes a "carriage return" - or blank line
    System.out.println("-- Project1_1 --");

    System.out.println("Enter your full name:");
    String name = user_input.nextLine();

    System.out.println("Enter your favorite color");
    String color = user_input.nextLine();
    
    System.out.println("Enter your favorite food:");
    String food = user_input.nextLine();

    System.out.println("Enter your favorite animal (PLURAL):");
    String animal = user_input.nextLine();

    System.out.println("Enter something else you want to tell someone special (no exclamations or questions):");
    String other = user_input.nextLine();

    System.out.println("Here is your message to send to all your friends:\n");
    System.out.println("Hello!\n\n   My name is " + name + " and I like eating " + food + " while petting " + color + " " + animal + ". One final thing that I would like to tell you is that " + other + ".\n\nAdios!\n~" + name);

  }
}

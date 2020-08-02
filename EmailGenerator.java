class EmailGenerator{

  private String firstname;
  private String lastname;
  private String color;
  private String food;
  private String animal;
  private String noun;
  private String adjective;
  private String hi;
  private String bye;
  public String[] greetings = {"Hello!", "Hi!", "Greetings!", "Good morning!", "Good afternoon!", "Good evening!"};
  public String[] farewells = {"Bye!", "Goodbye!", "Have a good day!", "Adios!", "See ya!", "Take care!"};

  public void setFirstname(String fn) {
    firstname = fn;
  }

  public void setLastname(String ln) {
    lastname = ln;
  }
  
  public void setColor(String c) {
    color = c;
  }

  public void setFood(String f) {
    food = f;
  }

  public void setAnimal(String a) {
    animal = a;
  }

  public void setNoun(String n) {
    noun = n;
  }

  public void setAdjective(String adj) {
    adjective = adj;
  }

  public void setHi(int h) {
    hi = greetings[h - 1];
  }

  public void setBye(int b) {
    bye = farewells[b - 1];
  }

  public void email(String fn, String ln, String c, String f, String a, String n, String adj, int h, int b) {
    setFirstname(fn);
    setLastname(ln);
    setColor(c);
    setFood(f);
    setAnimal(a);
    setNoun(n);
    setAdjective(adj);
    setHi(h);
    setBye(b);
  }

  public static String testArticle(String nextWord) {
    if (nextWord.matches("^[aeiou].*$")) {
      return "an " + nextWord;
    } else {
      return "a " + nextWord;
    }
  }

  public void printEmail() {
    String name = firstname + " " + lastname;

    System.out.println("Here is your message to send to all your friends:\n");

    System.out.println(hi + "\n\n   My name is " + name + " and I like eating " + food + " while petting " + color + " " + animal + ". One final thing that I would like to tell you is that I have " + testArticle(adjective) + " " + noun + ".\n\n" + bye + "\n~" + name);
  }

}
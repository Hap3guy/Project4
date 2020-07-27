class EmailGenerator{

  private String firstname;
  private String lastname;
  private String color;
  private String food;
  private String animal;
  private String other;
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

  public void setOther(String o) {
    other = o;
  }

  EmailGenerator(String fn, String ln, String c, String f, String a, String o) {
    setFirstname(fn);
    setLastname(ln);
    setColor(c);
    setFood(f);
    setAnimal(a);
    setOther(o);
  }

}
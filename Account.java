class Account {
  
  protected String firstname;
  protected String lastname;
  protected String email;
  protected String password;

  public void setFirstname(String fn) {
    firstname = fn;
  }

  public void setLastname(String ln) {
    lastname = ln;
  }

  public void setEmail(String e) {
    email = e;
  }

  public void setPassword(String p) {
    password = p;
  }

  public Account(String fn, String ln, String e, String p) {
    setFirstname(fn);
    setLastname(ln);
    setEmail(e);
    setPassword(p);
  }

  protected String getFirstname() {
    return firstname;
  }

  protected String getLastname() {
    return lastname;
  }

  protected String getEmail() {
    return email;
  }

  protected String getPassword() {
    return password;
  }

  public String[] getInfo() {
    String[] info = {getFirstname(), getLastname(), getEmail(), getPassword()};
    return info;
  }

  public void printAccount() {
    System.out.println("First name: " + getFirstname());
    System.out.println("Last name: " + getLastname());
    System.out.println("Email: " + getEmail());
    System.out.println("Password: " + getPassword());
  }

};
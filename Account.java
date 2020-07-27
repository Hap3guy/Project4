class Account {
  
  private String firstname;
  private String lastname;
  private String email;
  private String password;
  private String[] info = {"firstname", "lastname", "email", "password"};

  public void setFirstname(String fn) {
    firstname = fn;
    info[0] = fn;

  }

  public void setLastname(String ln) {
    lastname = ln;
    info[1] = ln;
  }

  public void setEmail(String e) {
    email = e;
    info[2] = e;
  }

  public void setPassword(String p) {
    password = p;
    info[3] = p;
  }

  public void setInfo() {
    info[0] = firstname;
    info[1] = lastname;
    info[2] = email;
    info[3] = password;
  }

  public String[] getInfo() {
    return info;
  }

  Account(String fn, String ln, String e, String p) {
    setFirstname(fn);
    setLastname(ln);
    setEmail(e);
    setPassword(p);
  }

  private String getFirstname() {
    return firstname;
  }

  private String getLastname() {
    return lastname;
  }

  private String getEmail() {
    return email;
  }

  private String getPassword() {
    return password;
  }

  public void printAccount() {
    System.out.println("First name: " + getFirstname());
    System.out.println("Last name: " + getLastname());
    System.out.println("Email: " + getEmail());
    System.out.println("Password: " + getPassword());
  }

};
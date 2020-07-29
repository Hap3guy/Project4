class Account {
  
  protected String firstname;
  protected String lastname;
  protected String email;
  protected String password;
  protected String[] info = {"firstname", "lastname", "email", "password"};

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

  public void printAccount() {
    System.out.println("First name: " + getFirstname());
    System.out.println("Last name: " + getLastname());
    System.out.println("Email: " + getEmail());
    System.out.println("Password: " + getPassword());
  }

};
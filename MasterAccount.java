class MasterAccount extends Account {

  private String role;
  private String[] info = {"firstname", "lastname", "email", "password", "role"};

  public void setRole(String r) {
    role = r;
    info[4] = r;
  }

  public void setInfo() {
    info[0] = firstname;
    info[1] = lastname;
    info[2] = email;
    info[3] = password;
    info[4] = role;
  }

  public MasterAccount(String fn, String ln, String e, String p, String r) {
    super(fn, ln, e, p);
    setRole(r);
  }

  private String getRole() {
    return role;
  }

  public String[] getInfo() {
    return info;
  }
  
  public void printAccount() {
    System.out.println("First name: " + getFirstname());
    System.out.println("Last name: " + getLastname());
    System.out.println("Email: " + getEmail());
    System.out.println("Password: " + getPassword());
    System.out.println("Role: " + getRole());
  }

};
class MasterAccount extends Account {

  private String role;

  public void setRole(String r) {
    role = r;
  }

  public MasterAccount(String fn, String ln, String e, String p, String r) {
    super(fn, ln, e, p);
    setRole(r);
  }

  private String getRole() {
    return role;
  }

  public String[] getInfo() {
    String[] info = {getFirstname(), getLastname(), getEmail(), getPassword(), getRole()};
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
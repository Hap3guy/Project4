// import java.util.*;

class Account {
  private String firstname;
  private String lastname;
  private String email;
  private String password;
  private String[] info;

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

  public void setInfo() {
    info[0] = firstname;
    info[1] = lastname;
    info[2] = email;
    info[3] = password;
  }

  Account(String fn, String ln, String e, String p) {
    setFirstname(fn);
    setLastname(ln);
    setEmail(e);
    setPassword(p);
    setInfo();
  }
};
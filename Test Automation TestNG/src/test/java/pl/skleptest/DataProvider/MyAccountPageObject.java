package pl.skleptest.DataProvider;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyAccountPageObject {
    private String mail;
    private String password;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

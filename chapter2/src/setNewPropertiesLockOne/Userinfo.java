package setNewPropertiesLockOne;

public class Userinfo {
    private String username;
    private String password;

    public Userinfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Userinfo() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

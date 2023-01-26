public class User {
    private int id;
    private String login;
    private String password;
    User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }
    int getId() {
        return this.id;
    }
    String getLogin() {
        return this.login;
    }
    String getPassword() {
        return this.password;
    }
    void setId(int id) {
        this.id = id;
    }
    void setLogin(String login) {
        this.login = login;
    }
    void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return id + " " + login + " " + password + "\n";
    }
}

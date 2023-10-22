package use_case.clear_users;

// TODO Complete me

public class ClearInputData {

    final private String username;
    final private String password;

    public ClearInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }
}

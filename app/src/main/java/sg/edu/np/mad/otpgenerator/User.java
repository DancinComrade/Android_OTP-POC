package sg.edu.np.mad.otpgenerator;

import java.io.Serializable;

public class User implements Serializable {
    public String Username;
    public String Password;

    public User(String username, String password) {
        Username = username;
        Password = password;
    }

    public User() {

    }
}

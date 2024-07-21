package task3;

import java.util.HashMap;

public class Bank {
    private HashMap<String, User> users;

    public Bank() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getUserID(), user);
    }

    public User getUser(String userID) {
        return users.get(userID);
    }

    public User validateUser(String userID, String userPIN) {
        User user = getUser(userID);
        if (user != null && user.validatePIN(userPIN)) {
            return user;
        }
        return null;
    }
}

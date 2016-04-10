package ohtu.services;

import ohtu.domain.User;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ohtu.data_access.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticationService {

    private UserDao userDao;

    @Autowired
    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean isValid(String string, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(string);
        boolean b = m.matches();
        return b;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password

        if (password.length() < 8) {
            return true;
        }

        boolean b = isValid(password, "[a-zA-Z]{8,}"); // jos on pelkkiä kirjaimia palauttaa
        // true
        boolean b2 = isValid(username, "[a-z]{3,}");

        return b || !b2;

    }
}

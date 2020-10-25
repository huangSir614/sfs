package regLogin.service;

import regLogin.domain.User;

public interface userService {
    void reg(User user);

    User findUser(User user);

    User findAdmin(User user);

    String findExist(String name);

    User find(String name);
}

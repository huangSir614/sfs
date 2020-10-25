package regLogin.dao;

import regLogin.domain.User;

public interface userDao {
    void regUser(User user);

    User findUser(String name, String pwd);

    User findAdmin(String name, String pwd);

    String findExist(String uname);

    User find(String name);
}

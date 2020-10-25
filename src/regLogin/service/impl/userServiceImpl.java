package regLogin.service.impl;

import regLogin.dao.impl.userDaoImpl;
import regLogin.dao.userDao;
import regLogin.domain.User;
import regLogin.service.userService;

public class userServiceImpl implements userService {

    private userDao dao = new userDaoImpl();


    @Override//注册
    public void reg(User user) {
        dao.regUser(user);
    }

    @Override//普通用户判断
    public User findUser(User user) {
        return dao.findUser(user.getName(),user.getPwd());
    }

    @Override//管理员判断
    public User findAdmin(User user) {
        return dao.findAdmin(user.getName(),user.getPwd());
    }

    @Override
    public String findExist(String name) {
        return dao.findExist(name);
    }

    @Override//判断是否已存在用户名
    public User find(String name) {
        return dao.find(name);
    }
}

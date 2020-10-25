package regLogin.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import regLogin.dao.userDao;
import regLogin.domain.User;
import regLogin.utils.JDBCUtils;

public class userDaoImpl implements userDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    //注册
    @Override
    public void regUser(User user) {
        String sql = "insert into tb_user values(null,?,?,0,?,0,0,?,?,?)";
        template.update(sql,user.getName(),user.getPwd(),user.getTel(),user.getDizhi(),user.getName(),user.getPwdl());
    }

    //判断用户
    @Override
    public User findUser(String name, String pwd){
        try {
            String sql = "select * from tb_user where name = ? and pwd = ?";
            return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),name,pwd);
        } catch (DataAccessException e) {
            return null;
        }

    }
    //判断是否管理员
    @Override
    public User findAdmin(String name, String pwd) {
        try {
            String sql = "select * from tb_admin where name = ? and pwd = ?";
            return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),name,pwd);
        } catch (DataAccessException e) {
            return null;
        }
    }

    @Override
    public String findExist(String uname) {
        return null;
    }
    //查找账号是否已存在
    @Override
    public User find(String name) {

        try {
            String sql = "select * from tb_user where name = ?";
            return template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),name);
        } catch (DataAccessException e) {
            return null;
        }

    }


}

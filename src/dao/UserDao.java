package dao;

import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

public class UserDao {

    //增加新用户
    public void addUser(User user) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into user(username,email,password,name,phone,address,isadmin,isvalidate) values(?,?,?,?,?,?,?,?)";
        r.update(sql,user.getUsername(),user.getEmail(),user.getPassword(),user.getName(),user.getPhone(),user.getAddress(),user.isIsadmin(),user.isIsvalidate());
    }
    public boolean isUsernameExist(String username) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username = ?";
        User u = r.query(sql, new BeanHandler<User>(User.class),username);
        if(u==null) {
            return false;
        }else {
            return true;
        }
    }
    public boolean isEmailExist(String email) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where email = ?";
        User u = r.query(sql, new BeanHandler<User>(User.class),email);
        if(u==null) {
            return false;
        }else {
            return true;
        }
    }

    //通过用户名或者密码查询是否实在用户
    public User selectByUsernamePassword(String username,String password) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where username=? and password=?";
        return r.query(sql, new BeanHandler<User>(User.class),username,password);
    }
    public User selectByEmailPassword(String email,String password) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where email=? and password=?";
        return r.query(sql, new BeanHandler<User>(User.class),email,password);
    }
    public User selectById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user where id=?";
        return r.query(sql, new BeanHandler<User>(User.class),id);
    }

    public void updateUserAddress(User user) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql ="update user set name = ?,phone=?,address=? where id = ?";
        r.update(sql,user.getName(),user.getPhone(),user.getAddress(),user.getId());
    }
    public void updatePwd(User user) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql ="update user set password = ? where id = ?";
        r.update(sql,user.getPassword(),user.getId());
    }
    public int selectUserCount() throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from user";
        return r.query(sql, new ScalarHandler<Long>()).intValue();
    }
    public List selectUserList(int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from user limit ?,?";
        return r.query(sql, new BeanListHandler<User>(User.class), (pageNo-1)*pageSize,pageSize );
    }
    public void delete(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from user where id = ?";
        r.update(sql,id);
    }
}

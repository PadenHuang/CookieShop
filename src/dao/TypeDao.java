package dao;

import model.Type;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DataSourceUtils;

import java.sql.SQLException;
import java.util.List;

public class TypeDao
{
    //查询全部类目信息
    public List<Type> GetAllType() throws SQLException {
        QueryRunner r=new QueryRunner(DataSourceUtils.getDataSource());  //创建一个数据源对象并将其作为参数用于创建一个QueryRunner对象r
        String sql="select * from type";
        return r.query(sql,new BeanListHandler<Type>(Type.class)); //BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
    }
    public Type selectTypeNameByID(int typeid) throws SQLException {
        QueryRunner r=new QueryRunner(DataSourceUtils.getDataSource());
        String sql="select * from type where id=?";
        return r.query(sql,new BeanHandler<Type>(Type.class),typeid);
    }
    public Type select(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from type where id = ?";
        return r.query(sql, new BeanHandler<Type>(Type.class),id);
    }
    //添加新的类目名
    public void insert(Type t) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into type(name) values(?)";
        r.update(sql,t.getName());
    }
    //更新类目名
    public void update(Type t) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update type set name=? where id = ?";
        r.update(sql,t.getName(),t.getId());
    }
    //删除类目
    public void delete(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from type where id = ?";
        r.update(sql,id);
    }
}

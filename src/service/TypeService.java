package service;

import dao.TypeDao;
import model.Type;

import java.sql.SQLException;
import java.util.List;

public class TypeService {
    TypeDao tDao=new TypeDao();
    //获取全部的商品类目
    public List<Type> GetAllType()
    {
        List<Type> list=null;//设置List集合变量list接受查询到的类目信息
        try {
            list=tDao.GetAllType(); //查询全部类目信息
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public Type selectTypeNameByID(int typeid)
    {
        Type type=null;
        try {
            type=tDao.selectTypeNameByID(typeid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }
    public Type select(int id) {
        Type t=null;
        try {
            t = tDao.select(id);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return t;
    }
    //添加类目
    public void insert(Type t) {
        try {
            tDao.insert(t);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //更新类目名
    public void update(Type t) {
        try {
            tDao.update(t);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //删除类目
    public boolean delete(int id) {
        try {
            tDao.delete(id);
            return true;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
    }
}

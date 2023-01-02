package service;

import dao.OrderDao;
import model.Order;
import model.OrderItem;
import model.Page;
import utils.DataSourceUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
/**@ 业务层(Service层)——
* */
public class OrderService {

    private OrderDao oDao = new OrderDao(); //订单Dao类

    public void addOrder(Order order) {
        Connection con = null; //数据库连接对象
        try {
            //获取数据库连接池对象
            con = DataSourceUtils.getConnection();
              /*Java Connection.setAutoCommit() 方法用于设置数据库连接的提交模式。
              如果是自动模式，执行所有的 SQL 语句，并作为单个事务被提交，否则 SQL 语句会被聚集到事务当中，直到调用 commit 方法或 rollback 方法为止。
              默认情况下新建连接为自动提交模式。*/
            con.setAutoCommit(false);

            oDao.insertOrder(con, order);
            int id = oDao.getLastInsertId(con);
            order.setId(id);
            for(OrderItem item : order.getItemMap().values()) {
                oDao.insertOrderItem(con, item);
            }

            con.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            if(con!=null)
                try {
                    con.rollback();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
        }
    }
    public List<Order> selectAll(int userid){
        List<Order> list=null;
        try {
            list = oDao.selectAll(userid);
            for(Order o :list) {
                List<OrderItem> l = oDao.selectAllItem(o.getId());
                o.setItemList(l);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    //请求订单页码
    public Page getOrderPage(int status,int pageNumber) {
       //页码设置
        Page p = new Page();
        p.setPageNumber(pageNumber);
        int pageSize = 10;  //设置每页最多可存放10条订单记录
        int totalCount = 0;
        try {
            totalCount = oDao.getOrderCount(status); //获取订单数目
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.SetPageSizeAndTotalCount(pageSize, totalCount); //设置页码大小——设置每页可以放置多少个订单以及页数
       //订单设置
        List list=null;
        try {
            list = oDao.selectOrderList(status, pageNumber, pageSize); //将获取到的订单封装为一个集合
            for(Order o :(List<Order>)list) {
                List<OrderItem> l = oDao.selectAllItem(o.getId());//遍历订单全部信息条目
                o.setItemList(l);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        p.setList(list);
        return p;
    }

    //更新订状态
    public void updateStatus(int id,int status) {
        try {
            oDao.updateStatus(id, status);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //删除订单
    public void delete(int id) {
        Connection con = null;
        try {
            con = DataSourceUtils.getDataSource().getConnection(); //创建数据库连接池对象
            con.setAutoCommit(false); //关闭con事务自动提交功能，必须在sql执行完commit或rollback

            oDao.deleteOrderItem(con, id); //删除订单条目信息
            oDao.deleteOrder(con, id);  //删除整个订单
            con.commit(); //提交事务
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(); //在命令行打印异常信息在程序中出错的位置及原因。
            if(con!=null)
                try {
                    con.rollback(); //回滚事务
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
        }


    }
}

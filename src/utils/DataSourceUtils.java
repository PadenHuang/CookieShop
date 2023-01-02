package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceUtils {
    private static DataSource ds=new ComboPooledDataSource();  //创建一个数据源对象

    //获取数据源
    public static DataSource getDataSource()
    {
        return  ds;
    }
    //获取数据库连接池对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection(); //创建数据库连接池对象
    }
}

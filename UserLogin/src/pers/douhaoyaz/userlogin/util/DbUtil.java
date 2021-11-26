package pers.douhaoyaz.userlogin.util;
import java.sql.*;

/**
 * 与数据库建立连接
 */
public class DbUtil {

    public static Connection getMysqlConn() {
        String url = "jdbc:mysql://127.0.0.1:3306/javaee?serverTimezone=UTC";

        String driverName = "com.mysql.cj.jdbc.Driver";

//        String sqlString = "select * from user limit 10";

        Connection connection = null;

        try {
            //加载驱动
            Class.forName(driverName);
            //创建连接
            connection = DriverManager.getConnection(url, "root", "Fusionyang_MySQL1");

            return connection;

//            //通过连接获取statement
//            Statement statement = connection.createStatement();
//            //statement 增、删、改、查
//            ResultSet resultSet = statement.executeQuery(sqlString);
//            //获取执行结果
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(2));
//            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}

package pers.douhaoyaz.userlogin.DAO;

import pers.douhaoyaz.userlogin.entity.User;
import pers.douhaoyaz.userlogin.util.DbUtil;

import java.sql.*;

/**
 * 接收前端数据，调用DbUtil与数据建立连接
 * 在login()里查询前端数据与数据库数据是否一致
 * 在register()里在数据库插入数据
 */
public class DAO {

    public static User login(String uname){

        User user = null;
        // 调用DbUtil的getMysqlConn方法与MySQL数据库建立连接
        Connection connection = DbUtil.getMysqlConn();
        // 判断是否连接成功
        if(connection != null){
            try {
                // 获取执行sql对象statment
                Statement st = connection.createStatement();
                // 定义SQL语句
                String sqlString = "SELECT * FROM user";
                // 使用resultSet接收返回数据
                ResultSet resultSet = st.executeQuery(sqlString);
                // 根据uname账号名在数据库查找对应账号
                while (resultSet.next()){
                    if(uname.equals(resultSet.getString("userName"))){
                        user = new User();
                        user.setUserName(uname);
                        user.setUserPwd(resultSet.getString("userPwd"));
                        break;
                    }
                }

                // 释放资源
                st.close();
                connection.close();
            }
            catch (SQLException e){
                e.printStackTrace();
            }

            return user;
        }
        else
            return user;

    }

    public static User register(String uname, String upwd){

        User user;
        return null;
    }
}

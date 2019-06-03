package weicelove.sqldemo;

import java.sql.*;

/**
 * @author admin
 * @title: DNUtils
 * @projectName anruoxin
 * @description: TODO
 * @date 2019/6/310:58
 */
public class DBUtils {
    private static final String DATABASE_PATH = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_PATH, USER, PASSWORD);
        String sql = "select id, state, type, add_time from test";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int anInt = resultSet.getInt(1);
            int anInt1 = resultSet.getInt(2);
            int anInt2 = resultSet.getInt(3);
            Date date = resultSet.getDate(4);
            System.out.println(anInt +"," +anInt1+","+anInt2+","+date);
        }
        connection.close();
    }
}

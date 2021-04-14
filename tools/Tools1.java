package tools;

import java.sql.*;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Tools1 {
    private static String url;              //连接数据库的路径
    private static String user;             //数据库用户名
    private static String password;         //数据库密码
    private static String insertData;       //添加数据的sql语句
    private static String select;           //查询数据的sql语句
    private static String update;           //修改数据的sql语句
    private static String delete;           //删除数据
    static{
        ClassLoader cl = Tools1.class.getClassLoader();
        URL road = cl.getResource("instructions.properties");
        String path = road.getPath();
        Properties pro=new Properties();
        try {
            pro.load(new FileReader(path));
            url=pro.getProperty("url");             //获取数据
            user=pro.getProperty("user");
            password=pro.getProperty("password");
            insertData=pro.getProperty("insertData");
            select=pro.getProperty("select");
            update=pro.getProperty("update");
            delete=pro.getProperty("delete");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {      //创建数据库连接对象
        return DriverManager.getConnection(url,user,password);
    }

    public static ResultSet getResultSet(Statement stmt) throws SQLException {
        return stmt.executeQuery(select);               //创建查询的对象
        }

    public static PreparedStatement Update(Connection conn) throws SQLException {
        return conn.prepareStatement(update);           //创建更新数据的对象
    }

    public static PreparedStatement Delete(Connection conn) throws SQLException {
        return conn.prepareStatement(delete);           //创建删除数据的对象
    }

    public static PreparedStatement Insert(Connection conn) throws SQLException {  //添加数据
        return conn.prepareStatement(insertData);       //创建添加数据的对象
    }
    //释放资源
    public static void Close(Connection conn,PreparedStatement pstmt){
        if(pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void Close(Connection conn,ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void Close(Connection conn, Statement stmt){

        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }       //释放资源
    public static void Close(Connection conn, Statement stmt, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}

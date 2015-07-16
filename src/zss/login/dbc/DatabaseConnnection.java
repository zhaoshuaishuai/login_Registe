package zss.login.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zss on 2015/7/16.
 */
public class DatabaseConnnection {
    public static final String dbDrive="com.mysql.jdbc.Driver";
    public static  final String dbUrl="jdbc:mysql://127.0.0.1:3306/login";
    public static final String dbUser="root";
    public static final String dbpassword="18883846360";
    private Connection connection=null;
    public DatabaseConnnection(){
        try{
            Class.forName(dbDrive);
            this.connection= DriverManager.getConnection(dbUrl, dbUser, dbpassword);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return  this.connection;
    }
    public void close(){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

package zss.login.dao.impl;

import zss.login.bean.User;
import zss.login.dao.IuserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by zss on 2015/7/15.
 */
public class UserDaoImpl implements IuserDao {
    private Connection connection=null;
    private PreparedStatement preparedStatement=null;
    public  UserDaoImpl(Connection connection){
        this.connection=connection;
    }
    @Override
    public User find(int userId, String userPassword) {
        String sql="SELECT* FROM user where userId=? AND userPassword=?";
        User user=new User();
        try {
            this.preparedStatement=connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, userId);
            this.preparedStatement.setString(2, userPassword);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                user.setUserId(resultSet.getInt(1));
                user.setUserPassword(resultSet.getString(2));
                user.setUserNmae(resultSet.getString(3));
                user.setUserEmail(resultSet.getString(4));
                user.setUserBirthday(resultSet.getDate(5));
            }else {
                return  null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    @Override
    public boolean add(User user) {
        boolean flag=false;
        int userId=user.getUserId();
        String userPassword=user.getUserPassword();
        String userName=user.getUserNmae();
        String userEmail=user.getUserEmail();
        Date userBirthday=user.getUserBirthday();
        String sql="INSERT into user" +
                "VALUES('"+userId+"','"+userPassword+"','"+userName+"','"+userEmail+"','"+userBirthday+"')";
        try {
            preparedStatement=connection.prepareStatement(sql);
            int resultSet=preparedStatement.executeUpdate();
            if(resultSet==0){

            }else{
                flag=true;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}

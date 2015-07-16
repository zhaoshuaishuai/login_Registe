package zss.login.dao.impl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by zss on 2015/7/15.
 */
@WebServlet(name = "CheckServlet")
public class CheckServlet extends HttpServlet {
    public static final String dbDrive="com.mysql.jdbc.Driver";
    public static  final String dbUrl="jdbc:mysql://127.0.0.1:3306/login";
    public static final String dbUser="root";
    public static final String dbpassword="18883846360";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("GBK");
        response.setContentType("text/html");
        String userId=request.getParameter("userId");
        PrintWriter out =response.getWriter();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            Class.forName(dbDrive);
            connection= DriverManager.getConnection(dbUrl, dbUser, dbpassword);
            System.out.println(connection);
            String sql="SELECT count(*)FROM user WHERE userId=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,userId);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                if(resultSet.getInt(1)>0){
                    out.print(true);
                }else {
                    out.print(false);
                }
            }
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

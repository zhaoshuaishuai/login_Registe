package zss.login.controller;

import zss.login.bean.User;
import zss.login.factory.DAOfactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zss on 2015/7/16.
 */
@WebServlet(name = "LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from=request.getParameter("from");
        if(from.equals("login")) {
            int userId = Integer.parseInt(request.getParameter("Id"));
            String password = request.getParameter("password");
            User user=null;
            user= DAOfactory.getIuserDAOInstance().find(userId,password);
            if(user!=null){
                request.getRequestDispatcher("index.html").forward(request,response);
            }else {
                String msg="用户Id或密码错误，请重新输入";
                request.setAttribute("msg",msg);
                System.out.println(request.getCharacterEncoding());
                System.out.println(response.getCharacterEncoding());

                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }else{

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

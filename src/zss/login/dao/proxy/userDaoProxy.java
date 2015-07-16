package zss.login.dao.proxy;

import zss.login.bean.User;
import zss.login.dao.IuserDao;
import zss.login.dao.impl.UserDaoImpl;
import zss.login.dbc.DatabaseConnnection;

/**
 * Created by zss on 2015/7/16.
 */
public class userDaoProxy implements IuserDao {
    private DatabaseConnnection dbc=null;
    private  IuserDao dao=null;
    public userDaoProxy(){
        try{
            this.dbc=new DatabaseConnnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        this.dao=new UserDaoImpl(this.dbc.getConnection());
    }
    @Override
    public User find(int userid, String userPassword) {
        User user=null;
        try{
            user=this.dao.find(userid,userPassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean add(User user) {
        boolean flag=false;
        try{
            flag=this.dao.add(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}

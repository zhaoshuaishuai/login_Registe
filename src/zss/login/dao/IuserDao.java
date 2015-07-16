package zss.login.dao;
import zss.login.bean.User;
/**
 * Created by zss on 2015/7/15.
 */
public interface IuserDao {
    User find(int userid,String userPassword);
    boolean add(User user);

}

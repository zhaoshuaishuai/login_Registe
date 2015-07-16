package zss.login.factory;

import zss.login.dao.IuserDao;
import zss.login.dao.proxy.userDaoProxy;

/**
 * Created by zss on 2015/7/16.
 */
public class DAOfactory {
    public static IuserDao getIuserDAOInstance(){
        return new userDaoProxy();
    }
}

package cn.sepiggy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

public class TableDAOFactory {
    private static TableDAO tDao = new TableDAO();

    public static TableDAO getInstance() {
        return tDao;
    }

    public static TableDAO getAuthInstance(AuthProxy authProxy) {
        Enhancer enhancer = new Enhancer();

        // 进行代理
        enhancer.setSuperclass(TableDAO.class);
        enhancer.setCallback(authProxy);

        // 生成代理实例
        return (TableDAO) enhancer.create();
    }

    public static TableDAO getAuthInstanceByFilter(AuthProxy authProxy){
        Enhancer en = new Enhancer();
        en.setSuperclass(TableDAO.class);
        en.setCallbacks(new Callback[]{authProxy, NoOp.INSTANCE});
        en.setCallbackFilter(new AuthProxyFilter());
        return (TableDAO)en.create();
    }

}



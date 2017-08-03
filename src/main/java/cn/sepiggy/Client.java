package cn.sepiggy;

import org.junit.Test;

public class Client {

    @Test
    public void testWithoutProxy() {
        TableDAO tableDAO = TableDAOFactory.getInstance();
        doMethod(tableDAO);
    }

    @Test
    public void testHaveAuth() {
        TableDAO tableDAO = TableDAOFactory.getAuthInstance(new AuthProxy("张三"));
        doMethod(tableDAO);
    }

    @Test
    public void testHaveNoAuth() {
        TableDAO tableDAO = TableDAOFactory.getAuthInstance(new AuthProxy("李四"));
        doMethod(tableDAO);
    }

    @Test
    public void haveAuthByFilter(){
        TableDAO tDao = TableDAOFactory.getAuthInstanceByFilter(new AuthProxy("张三"));
        doMethod(tDao);

        tDao = TableDAOFactory.getAuthInstanceByFilter(new AuthProxy("李四"));
        doMethod(tDao);
    }


    public void doMethod(TableDAO dao) {
        dao.create();
        dao.query();
        dao.update();
        dao.delete();
    }
}

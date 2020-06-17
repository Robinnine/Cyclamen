package cn.cl.cyclamen;

import cn.cl.cyclamen.entity.admin.Menu;
import org.junit.Test;

import java.util.List;

import cn.cl.cyclamen.dao.admin.MenuDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:cn.cll.cyclamen.testMysql
 * package:PACKAGE_NAME
 * Description:
 *
 * @date:2020/5/11 23:24
 * @author:cll@163.com
 */
public class testMysql {
    /*@Test
    public void getConnection() throws SQLException {
        ClassPathXmlApplicationContext ac
                = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        DataSource dataSource
                = ac.getBean("dataSource", DataSource.class);

        Connection conn =dataSource.getConnection();
        System.out.println(conn);

        ac.close();
    }*/
    @Test
    public void findChildernList() throws Exception {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        MenuDao menuDao
                = ac.getBean("menuDao", MenuDao.class);

        List<Menu> u = menuDao.findChildernList(Long.valueOf(8));

        System.out.println(u);
    }

    @Test
    public void findListByIds() throws Exception {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        MenuDao menuDao
                = ac.getBean("menuDao", MenuDao.class);

        List<Menu> u = menuDao.findListByIds(String.valueOf(8));

        System.out.println(u);
    }

}


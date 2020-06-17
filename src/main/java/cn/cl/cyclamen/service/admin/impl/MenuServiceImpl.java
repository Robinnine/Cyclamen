package cn.cl.cyclamen.service.admin.impl;

import cn.cl.cyclamen.dao.admin.MenuDao;
import cn.cl.cyclamen.entity.admin.Menu;
import cn.cl.cyclamen.service.admin.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:MenuServiceImpl
 * package:cn.cll.cyclamen.service.admin.impl
 * Description:
 *
 * @date:2020/4/15 16:10
 * @author:cll@163.com
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public int add(Menu menu) {
        // TODO Auto-generated method stub
        return menuDao.add(menu);
    }

    @Override
    public List<Menu> findList(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return menuDao.findList(queryMap);
    }

    @Override
    public List<Menu> findTopList() {
        // TODO Auto-generated method stub
        return menuDao.findTopList();
    }

    @Override
    public int getTotal(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return menuDao.getTotal(queryMap);
    }

    @Override
    public int edit(Menu menu) {
        // TODO Auto-generated method stub
        return menuDao.edit(menu);
    }

    @Override
    public int delete(Long id) {
        // TODO Auto-generated method stub
        return menuDao.delete(id);
    }

    @Override
    public List<Menu> findChildernList(Long parentId) {
        // TODO Auto-generated method stub
        return menuDao.findChildernList(parentId);
    }

    @Override
    public List<Menu> findListByIds(String ids) {
        // TODO Auto-generated method stub
        return menuDao.findListByIds(ids);
    }

}


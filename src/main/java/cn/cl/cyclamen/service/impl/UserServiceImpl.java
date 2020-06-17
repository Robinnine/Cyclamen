package cn.cl.cyclamen.service.impl;

import cn.cl.cyclamen.dao.UserDao;
import cn.cl.cyclamen.entity.User;
import cn.cl.cyclamen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:UserServiceImpl
 * package:cn.cll.cyclamen.service.impl
 * Description:
 *
 * @date:2020/4/14 21:14
 * @author:cll@163.com
 */
@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int add(User user) {
        // TODO Auto-generated method stub
        return userDao.add(user);
    }

    @Override
    public int edit(User user) {
        // TODO Auto-generated method stub
        return userDao.edit(user);
    }

    @Override
    public int delete(Long id) {
        // TODO Auto-generated method stub
        return userDao.delete(id);
    }

    @Override
    public List<User> findList(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return userDao.findList(queryMap);
    }

    @Override
    public Integer getTotal(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return userDao.getTotal(queryMap);
    }

    @Override
    public User find(Long id) {
        // TODO Auto-generated method stub
        return userDao.find(id);
    }

    @Override
    public User findByName(String name) {
        // TODO Auto-generated method stub
        return userDao.findByName(name);
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return userDao.findAll();
    }



}

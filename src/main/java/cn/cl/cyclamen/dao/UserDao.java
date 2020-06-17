package cn.cl.cyclamen.dao;

import cn.cl.cyclamen.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * ClassName:UserDao
 * package:cn.cll.cyclamen.dao
 * Description:
 *
 * @date:2020/4/13 21:00
 * @author:cll@163.com
 */
@Repository
public interface UserDao {
    public int add(User user);
    public int edit(User user);
    public int delete(Long id);
    public List<User> findList(Map<String, Object> queryMap);
    public Integer getTotal(Map<String, Object> queryMap);
    public User find(Long id);
    public User findByName(String name);
    public List<User> findAll();
}
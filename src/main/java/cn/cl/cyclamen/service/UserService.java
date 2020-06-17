package cn.cl.cyclamen.service;

import cn.cl.cyclamen.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/** 用户service
 * ClassName:UserService
 * package:cn.cll.cyclamen.service.impl
 * Description:
 *
 * @date:2020/4/14 21:06
 * @author:cll@163.com
 */
@Service
public interface UserService {
    public int add(User user);
    public int edit(User user);
    public int delete(Long id);
    public List<User> findList(Map<String, Object> queryMap);
    public Integer getTotal(Map<String, Object> queryMap);
    public User find(Long id);
    public User findByName(String name);
    public List<User> findAll();
}

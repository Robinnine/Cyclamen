package cn.cl.cyclamen.dao.admin;

import cn.cl.cyclamen.entity.admin.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * ClassName:RoleDao
 * package:cn.cll.cyclamen.dao.admin
 * Description:
 *
 * @date:2020/4/14 23:39
 * @author:cll@163.com
 */
@Repository
public interface RoleDao {
    public int add(Role role);
    public int edit(Role role);
    public int delete(Long id);
    public List<Role> findList(Map<String, Object> queryMap);
    public int getTotal(Map<String, Object> queryMap);
    public Role find(Long id);
}

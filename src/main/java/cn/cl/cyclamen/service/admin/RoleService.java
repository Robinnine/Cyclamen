package cn.cl.cyclamen.service.admin;

import cn.cl.cyclamen.entity.admin.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:RoleService
 * package:cn.cll.cyclamen.service
 * Description:
 *
 * @date:2020/4/14 22:41
 * @author:cll@163.com
 */
@Service
public interface RoleService {
    public int add(Role role);
    public int edit(Role role);
    public int delete(Long id);
    public List<Role> findList(Map<String, Object> queryMap);
    public int getTotal(Map<String, Object> queryMap);
    public Role find(Long id);
}

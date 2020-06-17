package cn.cl.cyclamen.service.admin;

import cn.cl.cyclamen.entity.admin.Authority;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:AuthorityService
 * package:cn.cll.cyclamen.service.admin
 * Description:
 *
 * @date:2020/4/14 22:48
 * @author:cll@163.com
 */
@Service
public interface AuthorityService {
    public int add(Authority authority);
    public int deleteByRoleId(Long roleId);
    public List<Authority> findListByRoleId(Long roleId);
}

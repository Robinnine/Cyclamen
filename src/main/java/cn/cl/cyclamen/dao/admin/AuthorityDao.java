package cn.cl.cyclamen.dao.admin;

import cn.cl.cyclamen.entity.admin.Authority;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName:AuthorityDao
 * package:cn.cll.cyclamen.dao.admin
 * Description:
 *
 * @date:2020/4/14 23:41
 * @author:cll@163.com
 */
@Repository
public interface AuthorityDao {
    public int add(Authority authority);
    public int deleteByRoleId(Long roleId);
    public List<Authority> findListByRoleId(Long roleId);
}

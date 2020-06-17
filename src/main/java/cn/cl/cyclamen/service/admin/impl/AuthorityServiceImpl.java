package cn.cl.cyclamen.service.admin.impl;

import cn.cl.cyclamen.dao.admin.AuthorityDao;
import cn.cl.cyclamen.entity.admin.Authority;
import cn.cl.cyclamen.service.admin.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:AuthorityServiceImpl
 * package:cn.cll.cyclamen.service.admin.impl
 * Description:
 *
 * @date:2020/4/15 16:11
 * @author:cll@163.com
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    private AuthorityDao authorityDao;

    @Override
    public int add(Authority authority) {
        // TODO Auto-generated method stub
        return authorityDao.add(authority);
    }

    @Override
    public int deleteByRoleId(Long roleId) {
        // TODO Auto-generated method stub
        return authorityDao.deleteByRoleId(roleId);
    }

    @Override
    public List<Authority> findListByRoleId(Long roleId) {
        // TODO Auto-generated method stub
        return authorityDao.findListByRoleId(roleId);
    }

}


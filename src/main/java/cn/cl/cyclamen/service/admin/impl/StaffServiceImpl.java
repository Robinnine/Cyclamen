package cn.cl.cyclamen.service.admin.impl;

import cn.cl.cyclamen.dao.admin.StaffDao;
import cn.cl.cyclamen.entity.admin.Staff;
import cn.cl.cyclamen.service.admin.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:StaffServiceImpl
 * package:cn.cll.cyclamen.service.admin.impl
 * Description:
 *
 * @date:2020/4/14 21:40
 * @author:cll@163.com
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;

    @Override
    public Staff findByStaffname(String username) {
        // TODO Auto-generated method stub
        return staffDao.findByStaffname(username);
    }

    @Override
    public int add(Staff staff) {
        // TODO Auto-generated method stub
        return staffDao.add(staff);
    }

    @Override
    public int edit(Staff staff) {
        // TODO Auto-generated method stub
        return staffDao.edit(staff);
    }

    @Override
    public int delete(String ids) {
        // TODO Auto-generated method stub
        return staffDao.delete(ids);
    }

    @Override
    public List<Staff> findList(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return staffDao.findList(queryMap);
    }

    @Override
    public int getTotal(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return staffDao.getTotal(queryMap);
    }

    @Override
    public int editPassword(Staff staff) {
        // TODO Auto-generated method stub
        return staffDao.editPassword(staff);
    }

}

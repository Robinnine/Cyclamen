package cn.cl.cyclamen.service.admin;

import cn.cl.cyclamen.entity.admin.Staff;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:StaffService
 * package:cn.cll.cyclamen.service.admin
 * Description:
 *
 * @date:2020/4/14 21:38
 * @author:cll@163.com
 */
@Service
public interface StaffService {
    public Staff findByStaffname(String username);
    public int add(Staff staff);
    public int edit(Staff staff);
    public int editPassword(Staff staff);
    public int delete(String ids);
    public List<Staff> findList(Map<String, Object> queryMap);
    public int getTotal(Map<String, Object> queryMap);


}

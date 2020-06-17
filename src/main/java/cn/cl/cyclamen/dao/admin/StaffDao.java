package cn.cl.cyclamen.dao.admin;

import cn.cl.cyclamen.entity.admin.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/** 员工
 * ClassName:StaffDao
 * package:cn.cll.cyclamen.dao.admin
 * Description:
 *
 * @date:2020/4/14 21:31
 * @author:cll@163.com
 */
@Repository
public interface StaffDao {
    public Staff findByStaffname(String username);
    public int add(Staff staff);
    public int edit(Staff staff);
    public int editPassword(Staff staff);
    public int delete(String ids);
    public List<Staff> findList(Map<String, Object> queryMap);
    public int getTotal(Map<String, Object> queryMap);
}

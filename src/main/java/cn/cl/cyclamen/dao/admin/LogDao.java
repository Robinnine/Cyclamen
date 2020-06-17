package cn.cl.cyclamen.dao.admin;

import cn.cl.cyclamen.entity.admin.Log;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * ClassName:LogDao
 * package:cn.cll.cyclamen.dao.admin
 * Description:
 *
 * @date:2020/4/14 23:38
 * @author:cll@163.com
 */
@Repository
public interface LogDao {
    public int add(Log log);
    public List<Log> findList(Map<String, Object> queryMap);
    public int getTotal(Map<String, Object> queryMap);
    public int delete(String ids);

}

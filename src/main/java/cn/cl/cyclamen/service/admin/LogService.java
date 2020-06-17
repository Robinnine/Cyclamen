package cn.cl.cyclamen.service.admin;

import cn.cl.cyclamen.entity.admin.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:LogService
 * package:cn.cll.cyclamen.service.admin
 * Description:
 *
 * @date:2020/4/14 22:45
 * @author:cll@163.com
 */
@Service
public interface LogService {
    public int add(Log log);
    public int add(String content);
    public List<Log> findList(Map<String, Object> queryMap);
    public int getTotal(Map<String, Object> queryMap);
    public int delete(String ids);
}

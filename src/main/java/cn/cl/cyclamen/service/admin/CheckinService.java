package cn.cl.cyclamen.service.admin;

import cn.cl.cyclamen.entity.admin.Checkin;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:CheckinService
 * package:cn.cll.cyclamen.service.admin
 * Description:
 *
 * @date:2020/4/14 22:47
 * @author:cll@163.com
 */
@Service
public interface CheckinService {
    public int add(Checkin checkin);
    public int edit(Checkin checkin);
    public int delete(Long id);
    public List<Checkin> findList(Map<String, Object> queryMap);
    public Integer getTotal(Map<String, Object> queryMap);
    public Checkin find(Long id);
    public List<Map> getStatsByMonth();
    public List<Map> getStatsByDay();
}

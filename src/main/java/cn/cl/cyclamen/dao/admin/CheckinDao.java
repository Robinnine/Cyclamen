package cn.cl.cyclamen.dao.admin;

import cn.cl.cyclamen.entity.admin.Checkin;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * ClassName:CheckinDao
 * package:cn.cll.cyclamen.dao.admin
 * Description:
 *
 * @date:2020/4/14 23:40
 * @author:cll@163.com
 */
@Repository
public interface CheckinDao {
    public int add(Checkin checkin);
    public int edit(Checkin checkin);
    public int delete(Long id);
    public List<Checkin> findList(Map<String, Object> queryMap);
    public Integer getTotal(Map<String, Object> queryMap);
    public Checkin find(Long id);
    public List<Map> getStatsByMonth();
    public List<Map> getStatsByDay();
}

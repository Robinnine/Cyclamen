package cn.cl.cyclamen.dao.admin;

import cn.cl.cyclamen.entity.admin.Floor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * ClassName:FloorDao
 * package:cn.cll.cyclamen.dao.admin
 * Description:
 *
 * @date:2020/4/14 23:37
 * @author:cll@163.com
 */
@Repository
public interface FloorDao {
    public int add(Floor floor);
    public int edit(Floor floor);
    public int delete(Long id);
    public List<Floor> findList(Map<String, Object> queryMap);
    public List<Floor> findAll();
    public Integer getTotal(Map<String, Object> queryMap);
}

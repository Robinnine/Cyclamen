package cn.cl.cyclamen.dao.admin;

import cn.cl.cyclamen.entity.admin.Room;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * ClassName:RoomDao
 * package:cn.cll.cyclamen.dao.admin
 * Description:
 *
 * @date:2020/4/14 23:40
 * @author:cll@163.com
 */
@Repository
public interface RoomDao {
    public int add(Room room);
    public int edit(Room room);
    public int delete(Long id);
    public List<Room> findList(Map<String, Object> queryMap);
    public List<Room> findAll();
    public Integer getTotal(Map<String, Object> queryMap);
    public Room find(Long id);
    public Room findBySn(String sn);
}

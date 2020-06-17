package cn.cl.cyclamen.service.admin;

import cn.cl.cyclamen.entity.admin.Room;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:RoomService
 * package:cn.cll.cyclamen.service.admin
 * Description:
 *
 * @date:2020/4/14 22:44
 * @author:cll@163.com
 */
@Service
public interface RoomService {
    public int add(Room room);
    public int edit(Room room);
    public int delete(Long id);
    public List<Room> findList(Map<String, Object> queryMap);
    public List<Room> findAll();
    public Integer getTotal(Map<String, Object> queryMap);
    public Room find(Long id);
    public Room findBySn(String sn);
}

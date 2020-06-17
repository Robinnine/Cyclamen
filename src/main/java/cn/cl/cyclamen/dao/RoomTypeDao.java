package cn.cl.cyclamen.dao;

import cn.cl.cyclamen.entity.RoomType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * ClassName:RoomTypeDao
 * package:cn.cll.cyclamen.dao
 * Description:
 *
 * @date:2020/4/14 23:37
 * @author:cll@163.com
 */
@Repository
public interface RoomTypeDao {
    public int add(RoomType roomType);
    public int edit(RoomType roomType);
    public int delete(Long id);
    public List<RoomType> findList(Map<String, Object> queryMap);
    public Integer getTotal(Map<String, Object> queryMap);
    public List<RoomType> findAll();
    public RoomType find(Long id);
    public int updateNum(RoomType roomType);
}

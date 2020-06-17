package cn.cl.cyclamen.service;

import cn.cl.cyclamen.entity.RoomType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:RoomTypeService
 * package:cn.cll.cyclamen.service
 * Description:
 *
 * @date:2020/4/14 22:38
 * @author:cll@163.com
 */
@Service
public interface RoomTypeService {
    public int add(RoomType roomType);
    public int edit(RoomType roomType);
    public int delete(Long id);
    public List<RoomType> findList(Map<String, Object> queryMap);
    public List<RoomType> findAll();
    public Integer getTotal(Map<String, Object> queryMap);
    public RoomType find(Long id);
    public int updateNum(RoomType roomType);
}
